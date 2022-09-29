package com.example.queryproject.team;

import com.example.queryproject.member.Member;
import com.example.queryproject.member.ResponseMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTeam {
    private Long id;
    private String name;
    private List<ResponseMember> members = new ArrayList<>();

    public ResponseTeam(Team t) {
        this.id = t.getId();
        this.name = t.getName();
        this.members = t.getMembers().stream().map(ResponseMember::new).collect(Collectors.toList());
    }
}
