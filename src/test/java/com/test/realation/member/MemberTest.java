//package com.test.realation.member;
//
//import com.test.realation.groupMember.GroupMember;
//import com.test.realation.groupMember.GroupMemberService;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//@RunWith(SpringRunner.class)
//public class MemberTest {
//
//    @Autowired
//    MemberService memberService;
//    @Autowired
//    GroupMemberService groupMemberService;
//    @Autowired
//    MemberRepository memberRepository;
//
//    @Test
//    public void memberEntityTest() throws Exception{
//        Member owner = Member.create("..", "suhwpark", "개포 안",
//                true, "c4r5s5", null, 0,
//                false, true, new Date(), new Date(), new Date());
//        Long ownerId = memberService.save(owner);
//        Member jonHan = Member.create("..", "jonhan", "4층 클러스터",
//                true, "c1r1s1", null, 0,
//                false, true, new Date(), new Date(), new Date());
//        Long jonhanId = memberService.save(jonHan);
//
//        Member jnam = Member.create("..", "jnam", "2층 클러스터",
//                true, "c5r2s1", null, 0,
//                false, true, new Date(), new Date(), new Date());
//        Long jnamId = memberService.save(jnam);
//        Member hjeong = Member.create("..", "hjeong", "4층 클러스터",
//                true, "c1r1s1", null, 0,
//                false, true, new Date(), new Date(), new Date());
//        Long hjeingId = memberService.save(hjeong);
//
//        groupMemberService.addGroup(owner, "어디있니");
//        memberService.addFriend(owner.getIntraId(), "어디있니", jonHan.getIntraId());
//        memberService.addFriend(owner.getIntraId(), "어디있니", jnam.getIntraId());
//        memberService.addFriend(owner.getIntraId(), "어디있니", hjeong.getIntraId());
//
//        final GroupMember where = owner.getGroupList("어디있니");
//        assertEquals(3, where.getFriends().size());
//
//        assertEquals(owner, memberRepository.findById(ownerId).orElseThrow());
//        assertEquals(jonHan, memberRepository.findById(jonhanId).orElseThrow());
//
//        final List<GroupMember> groupMemberList = owner.getGroupMembers();
//        assertEquals(groupMemberList.get(0).getGroupName(), "어디있니");
//
//        final List<Member> friendList = owner.getGroupFriendsList("어디있니");
//        assertEquals(friendList.get(0).getIntraId(), jonHan.getIntraId());
//
//        jonHan.changeClusterSit("cx2r4s6");
//        assertEquals(friendList.get(0).getIMacLocation(), "cx2r4s6");
//    }
//}
