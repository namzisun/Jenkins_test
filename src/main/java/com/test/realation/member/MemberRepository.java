package com.test.realation.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByIntraId(String intraId);

    List<Member> findMemberByIntraId(String intraId);
}
