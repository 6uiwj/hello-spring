package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring"); //"spring"

        repository.save(member);
        //"repository.findById(member.getId())"의 반환 타입이 Optional -> get으로 값을 꺼냄
        //
        Member result = repository.findById(member.getId()).get();

        //member값과 repository의 값이 같은지 확인
        Assertions.assertEquals(member, result);
    }
}
