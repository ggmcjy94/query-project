package com.example.queryproject.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/all")
    public List<ResponseMember> getMembersController() {
        return memberService.findAll();
    }

    @GetMapping("/find-username/{username}")
    public List<ResponseMember> getMemberUsernamesController(@PathVariable("username") String username) {
        return memberService.findAllByUserName(username);
    }

    @GetMapping("/find-age/{age}")
    public List<ResponseMember> getMemberAgeController(@PathVariable("age") Integer age) {
        return memberService.findAllByAge(age);
    }
}
