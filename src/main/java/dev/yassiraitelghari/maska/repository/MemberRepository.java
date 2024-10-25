package dev.yassiraitelghari.maska.repository;

import dev.yassiraitelghari.maska.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
