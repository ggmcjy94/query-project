package com.example.queryproject.team;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TeamService {

    private final TeamQueryRepository teamQueryRepository;



    public List<ResponseTeam> findAll() {
        return teamQueryRepository.findAll().stream().map(ResponseTeam::new).collect(Collectors.toList());
    }
}
