package com.test.realation.member;

import com.test.realation.groupMember.GroupMember;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;
    private String image;
    private String intraId;
    private String comment;
    private boolean inCluster;
    private String iMacLocation;
    private String customLocation;
    private int clusterLocation;
    private boolean blackHole;
    private boolean agreement;
    private Date grade;
    private Date updatedAt;
    private Date createdAt;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<GroupMember> groupMembers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private GroupMember groupMember;

    public static Member create(String image, String intraId, String comment, boolean inCluster, String iMacLocation,
                                String customLocation, int clusterLocation, boolean blackHole, boolean agreement, Date grade, Date updatedAt,
                                Date createdAt) {
        Member member = new Member();
        member.image = image;
        member.intraId = intraId;
        member.inCluster = inCluster;
        member.comment = comment;
        member.iMacLocation = iMacLocation;
        member.customLocation = customLocation;
        member.clusterLocation = clusterLocation;
        member.blackHole = blackHole;
        member.agreement = agreement;
        member.grade = grade;
        member.updatedAt = updatedAt;
        member.createdAt = createdAt;

        return member;
    }

    public void addGroupMembers(final GroupMember groupMember) {
        this.groupMembers.add(groupMember);
    }
    public GroupMember getGroupList(final String groupName) {
        final List<GroupMember> groupMemberList = this.getGroupMembers();
        GroupMember groupMember = null;
        for (GroupMember g : groupMemberList) {
            if (g.getGroupName().equals(groupName)) {
                groupMember = g;
                break;
            }
        }
        return groupMember;
    }

    public List<Member> getGroupFriendsList(final String groupName) {
        final List<GroupMember> groupMembers = this.getGroupMembers();
        final List<Member> result = groupMembers.stream()
                .filter(g -> g.getGroupName().equals(groupName)).findFirst()
                .map(GroupMember::getFriends)
                .orElse(new ArrayList<>());
        return result;
    }

    public void changeClusterSit(String iMacLocation) {
        this.iMacLocation = iMacLocation;
    }
}
