package com.test.realation.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/create")
    public ResponseEntity<String> createMember() {

        Member newMember = Member.create("..", "jonhan", "4층 클러스터",
                true, "c1r1s1", null, 0,
                false, true, new Date(), new Date(), new Date());

        memberService.save(newMember);
        return ResponseEntity.ok("created");
    }
}
