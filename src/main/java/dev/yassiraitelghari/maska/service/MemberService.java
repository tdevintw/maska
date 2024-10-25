package dev.yassiraitelghari.maska.service;

import dev.yassiraitelghari.maska.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberService {

    Member add(Member member) ;

    void delete(int id);

    Optional<Member> find(int id) ;

    List<Member> getMembers();

    Member edit(Member member);
}
