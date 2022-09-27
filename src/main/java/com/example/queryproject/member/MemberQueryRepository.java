package com.example.queryproject.member;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.queryproject.member.QMember.member;

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
                .where(member.username.eq(userName))
                .fetch();
    }

    public List<Member> findAllByAge(Integer age) {
        return queryFactory
                .selectFrom(member)
                .where(member.age.eq(age))
                .fetch();
    }
}
