package dev.yassiraitelghari.maska.service.implementations;

import dev.yassiraitelghari.maska.domain.Member;
import dev.yassiraitelghari.maska.repository.MemberRepository;
import dev.yassiraitelghari.maska.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository ;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository ;
    }

    public Member add(Member member) {
        return memberRepository.save(member);
    }

    public void delete(int id) {
         memberRepository.deleteById(id);
    }

    public Optional<Member> find(int id) {
        return memberRepository.findById(id);
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }
   public  Member edit(Member member){
        return memberRepository.save(member);
   };



}
