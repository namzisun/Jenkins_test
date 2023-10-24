package com.test.realation.groupMember;

import com.test.realation.member.Member;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class GroupMember {

    @Id @GeneratedValue
    private Long id;

    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(mappedBy = "groupMember", cascade = CascadeType.ALL)
    private List<Member> friends = new ArrayList<>();

    public void addMember(final Member member) {
        this.member = member;
    }

    public void addFriend(final Member member) {
        this.friends.add(member);
    }

    public static GroupMember create(String groupName) {
        GroupMember groupMember = new GroupMember();
        groupMember.groupName = groupName;

        return groupMember;
    }
}
