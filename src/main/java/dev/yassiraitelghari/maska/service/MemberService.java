package dev.yassiraitelghari.maska.service;

import dev.yassiraitelghari.maska.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member add(Member member) ;

    void delete(Member member);

    Optional<Member> find(int id) ;

    List<Member> getMembers();
}
