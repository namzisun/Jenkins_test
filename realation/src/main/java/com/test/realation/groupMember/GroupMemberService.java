package com.test.realation.groupMember;

import com.test.realation.member.Member;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class GroupMemberService {

    private final GroupMemberRepository groupMemberRepository;
    @Transactional
    public Long save(GroupMember groupMember) {
        groupMemberRepository.save(groupMember);
        return groupMember.getId();
    }

    @Transactional
    public void addGroup(Member member, String groupName) {
        final GroupMember groupMember = GroupMember.create(groupName);
        groupMember.addMember(member);
        member.addGroupMembers(groupMember);
        this.save(groupMember);
    }

}
