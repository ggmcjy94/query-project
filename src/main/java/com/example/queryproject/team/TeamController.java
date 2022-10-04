package com.example.queryproject.team;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/all")
    public List<ResponseTeam> getTeamsController() {
        return teamService.findAll();
    }

    @GetMapping("{id}")
    public ResponseTeam getTeamController(@PathVariable Long id) {
        return teamService.findById(id);
    }

}
