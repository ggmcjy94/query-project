package com.example.queryproject.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.queryproject.member.QMember.member;
import static com.example.queryproject.team.QTeam.team;

@Repository
public class MemberQueryRepository extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public MemberQueryRepository(JPAQueryFactory queryFactory) {
        super(Member.class);
        this.queryFactory = queryFactory;
    }

    public List<Member> findAll() {
        return queryFactory
                .selectFrom(member).fetch();
    }

    public List<Member> findAllByUserName(String userName) {
        return queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .fetchJoin()
                .where(member.username.eq(userName))
                .fetch();
    }

    public List<Member> findAllByAge(Integer age) {
        return queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .fetchJoin()
                .where(member.age.eq(age))
                .fetch();
    }

    public List<Member> findAllByTeamName(String teamName) {
        return queryFactory
                .selectFrom(member)
                .join(member.team, team)
                .fetchJoin()
                .where(member.team.name.eq(teamName))
                .fetch();
    }
}
