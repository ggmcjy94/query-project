package com.example.queryproject.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMember {

    private Long id;
    private String username;
    private int age;
    private String teamName;

    public ResponseMember(Member m) {
        this.id = m.getId();
        this.username = m.getUsername();
        this.age = m.getAge();
        this.teamName = m.getTeam().getName();
    }
}
