package com.usingJPA;

import com.usingJPA.JPA.model.entity.Team;
import com.usingJPA.JPA.model.entity.Members;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    private EntityManagerFactory emf;

    public void mainpage() {
        String username = "";
        MemberExample memberList = this.memberService.getmember(username);
    }

    public void apply() {
        String username = "myname";
        Integer age = 23;
    }

    public void main() {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            //logic(em);
            //logic1(em); //커밋되기 전 모든 엔티티는 내부 저장소에 저장되고 쓰기 지연 상태로 된다.
            //logic2(em);
            //logic3(em); //detach된 엔티티는 commit에 반영되지 않음
            tx.commit(); //커밋 순간에 insert를 실행 만약 쓰기 지연 저장소의 데이터 중 변경 사항이 감지되면 update도 실행해주고 commit
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); //영속성 컨텍스트 종료
        }
        //emf.close();
    }

    private static void logic(EntityManager em) {
        //String id = "id1";
        MemberExample member = new MemberExample();
        //member.setId();
        member.setUsername("지한");
        member.setAge(2);

        em.persist(member); //엔티티매핑
        member.setAge(20); //update

        MemberExample findMember = em.find(MemberExample.class, member.getId());
        System.out.println("findMemeber=" + findMember.getUsername() + ", age=" + findMember.getAge());

        List<Members> members = em.createQuery("select m from Member m", Members.class).getResultList();
        System.out.println("members.size=" + members.size());

        em.remove(member);


    }

    private static void logic1(EntityManager em) {
        MemberExample member = new MemberExample();
        //member.setId("member1");
        member.setUsername("회원1");
        member.setAge(2);

        em.persist(member); //엔티티 매핑
        MemberExample findmember1 = em.find(MemberExample.class, 1L); //캐시에 있는지 찾아봄  //있기에 찾음
        MemberExample findmember2 = em.find(MemberExample.class, 2L); //캐시에 있는지 찾아봄 //없기에 db에 새로 데이터를 입력


        MemberExample a = em.find(MemberExample.class, 1L);
        MemberExample b = em.find(MemberExample.class, 2L);
        System.out.println(a == b); //같은 캐시에서 가져오는 값이기에 같은 엔티티 인스턴스이다
        em.remove(member);
    }

    private static void logic2(EntityManager em) {

        MemberExample memberA = em.find(MemberExample.class, 1L);
        if(memberA == null){ //만약 엔티티를 찾지 못한다면 생성해줌
            memberA = new MemberExample();
            //memberA.setId("memberA");
            memberA.setAge(123);
            memberA.setUsername("1234");
            em.persist(memberA);
        }
        memberA.setUsername("hi");
        memberA.setAge(10);

        //em.update(memberA); //없어도 되는 이유는 엔티티의 변경이 생기면 sql 저장소에 변경된 데이터를 바꿔 저장한다
        //em.remove(memberA);
    }

    private static void logic3(EntityManager em) {
        MemberExample memberA = new MemberExample();
        //memberA.setId("memberA");
        memberA.setAge(123);
        memberA.setUsername("1234");

        Members memberx = em.find(Members.class, 1L);

        em.persist(memberA);
        
        //em.clear(); detach와 같은 역할을 하지만 영속성 컨텍스트에 있는 모든 엔티티를 detach해준다
        
        em.detach(memberA);
        //em.update(memberA); //없어도 되는 이유는 엔티티의 변경이 생기면 sql 저장소에 변경된 데이터를 바꿔 저장한다
        //em.remove(memberA);
    }

    public void testSave(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        /*
        tx.begin();
        Team team1 = new Team();
        team1.setId("team1");
        team1.setName("팀1");
        em.persist(team1);

        Members member1 = new Members();
        member1.setTeam(team1);
        member1.setId("memeber1");
        member1.setUsername("회원1");
        team1.getMembers().add(member1);
        em.persist(member1);

        Members member2 = new Members();
        member2.setTeam(team1);
        member2.setId("member2");
        member2.setUsername("회원2");
        team1.getMembers().add(member2); //양방향을 위해 모두 설정해줌
        em.persist(member2);
        tx.commit();
        */
        //queryLogicJoin(em);
        //tx.begin();
        //updateRelation(em);
        //tx.commit();
        checkbidirection(em);
        em.close();
        emf.close();
    }

    private static void queryLogicJoin(EntityManager em){
        String jpql = "select m from Members m join m.team t where " +
                        "t.name = :teamName";

        List<Members> resultList = em.createQuery(jpql,Members.class)
                                .setParameter("teamName","팀1")
                                .getResultList();

        for(Members members: resultList){
            System.out.println("[query] members.username=" + members.getUsername());
        }
    }

    private static void updateRelation(EntityManager em){
        Team team2 = new Team();
        team2.setId("team2");
        team2.setName("팀2");
        em.persist(team2);

        Members members = em.find(Members.class,"member1"); //pk값이 member1인 객체를 가져옴
        members.setTeam(team2); //객체의 팀을 update

        Members members1 = em.find(Members.class,"member1");
        members1.setTeam(null); //외래키 종속 제거
        
        em.remove(team2); //팀삭제
    }

    public void checkbidirection(EntityManager em){
        Team team = em.find(Team.class,"team1");

        List<Members> members = team.getMembers();

        System.out.println(members.size());

        for(Members member: members){
            System.out.println("members.username = "+member.getUsername());
        }
    }
}
