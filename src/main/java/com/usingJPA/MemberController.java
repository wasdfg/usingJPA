package com.usingJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    private EntityManagerFactory emf;
    public void mainpage(){
        String username = "";
        Member memberList = this.memberService.getmember(username);
    }

    public void apply(){
        String username = "myname";
        Integer age = 23;
    }
    
    public void main(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try{
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
    
    private static void logic(EntityManager em){
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);
        
        em.persist(member); //객체 등록
        
        member.setAge(20); //update

        Member findMember = em.find(Member.class,id);
        System.out.println("findMemeber="+findMember.getUsername()+", age="+findMember.getAge());

        List<Member> members = em.createQuery("select m from Member m",Member.class).getResultList();
        System.out.println("members.size="+members.size());

        em.remove(member);
    }
}
