package com.usingJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByUsername(String username);
}
