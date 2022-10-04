package com.example.queryproject.team;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.queryproject.member.QMember.member;
import static com.example.queryproject.team.QTeam.team;

@Service
public class TeamQueryRepository extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public TeamQueryRepository(JPAQueryFactory jpaQueryFactory) {
        super(Team.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }


    public List<Team> findAll() {
        return jpaQueryFactory
                .selectFrom(team)
                .orderBy(team.id.asc())
                .fetch();
    }


    public Optional<Team> findById(Long id) {
        return Optional.ofNullable(jpaQueryFactory
                .selectFrom(team)
                .fetchOne());
    }
}
