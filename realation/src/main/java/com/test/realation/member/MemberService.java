package com.test.realation.member;

import com.test.realation.groupMember.GroupMember;
import com.test.realation.groupMember.GroupMemberService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Transactional
    public Long save(final Member member) {
        this.validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public Member findByName(final String intraId) {
        final Member member = memberRepository.findByIntraId(intraId);
        return member;
    }

    @Transactional
    public void addFriend(final String owner,
                          final String groupName,
                          final String friend) {
        final Member memberOwner = findByName(owner);
        final Member memberFriend = findByName(friend);
//        if (memberFriend.isAgreement() == false) {
//            throw new RuntimeException("동의하지 않은 사용자 입니다");
//        }
        final GroupMember groupMember
                = memberOwner.getGroupList(groupName);
        groupMember.addFriend(memberFriend);
    }

    private void validateDuplicateMember(final Member member) {
        final List<Member> members = memberRepository.findMemberByIntraId(member.getIntraId());
        if (!members.isEmpty()) {
            throw new IllegalStateException("중복된 회원임");
        }
    }
}
