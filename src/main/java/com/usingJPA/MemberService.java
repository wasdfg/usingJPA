package com.usingJPA;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public Member getmember(String username){
        Member member = this.memberRepository.findByUsername(username);
        return member;
    }

    public void saveMember(String username,Integer age){

    }
}
