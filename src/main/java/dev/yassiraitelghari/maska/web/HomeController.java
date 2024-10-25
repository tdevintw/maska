package dev.yassiraitelghari.maska.web;

import dev.yassiraitelghari.maska.domain.Member;
import dev.yassiraitelghari.maska.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class HomeController {


    private final MemberService memberService;

    // Constructor injection of HomeService
    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/") // Maps the root path to this method
    public String home() {

//        Member member = new Member();
//        member.setFirstName("yasser");
//        member.setLastName("ait");
//        member.setIdentityNumber("22200");
//        member.setNationality("morocco");
//        member.setStartDate(LocalDateTime.now());
//        member.setEndDate(LocalDateTime.now());
//
//        memberService.add(member);
//
//        Member member2 = memberService.find(1).get();
//        member2.setLastName("jjjjjjjjj");
//        memberService.edit(member2);

//        memberService.delete(1);
        return "index";
    }
}
