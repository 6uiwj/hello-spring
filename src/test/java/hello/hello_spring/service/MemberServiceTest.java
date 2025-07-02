package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    //테스트는 메서드 이름을 한글로 해도됨..
    @Test
    void 회원가입() {
        //given (상황)
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then (결과)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}