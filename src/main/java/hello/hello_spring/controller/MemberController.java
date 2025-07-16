package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

public class MemberController {

    //private final MemberService memberService;
    private final MemberService memberService;

    //스프링 컨테이너가 MemberController를 만들 때 생성자가 호출 됨
    //@Autowired //Autowired를 붙이면 스프링 컨테이너에서 memberService를 가져옴
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
