package com.example.queryproject.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberQueryRepository memberQueryRepository;

    public List<ResponseMember> findAll() {
        return memberQueryRepository.findAll().stream().map(ResponseMember::new).collect(Collectors.toList());
    }

    public List<ResponseMember> findAllByUserName(String username) {
        return memberQueryRepository.findAllByUserName(username).stream().map(ResponseMember::new).collect(Collectors.toList());
    }

    public List<ResponseMember> findAllByAge(Integer age) {
        return memberQueryRepository.findAllByAge(age).stream().map(ResponseMember::new).collect(Collectors.toList());
    }

    public List<ResponseMember> findAllByTeamName(String teamName) {
        return memberQueryRepository.findAllByTeamName(teamName).stream().map(ResponseMember::new).collect(Collectors.toList());
    }
}
