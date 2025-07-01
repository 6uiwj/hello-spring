package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

//클래스 안의 모든 테스트는 순서를 보장하지 않음(순서 의존적으로 설계하면 안됨)
// -> 따라서 테스트 후엔 데이터를 clear 해줘야함 (리포지토리 지우기)
 class MemoryMemberRepositoryTest {
     MemoryMemberRepository repository = new MemoryMemberRepository();

    //각각 테스트 끝난 후 리포지토리 지우기
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring"); //"spring"

        repository.save(member);
        //"repository.findById(member.getId())"의 반환 타입이 Optional -> get으로 값을 꺼냄
        //
        Member result = repository.findById(member.getId()).get();

        //member값과 repository의 값이 같은지 확인 - junit 이용
        //System.out.println("result = " + (result == member));
        //Assertions.assertEquals(member, result); //(기댓값, 결과값)
       // Assertions.assertEquals(member,null);
        assertThat(member).isEqualTo(result); //assertj 이용

    }

    //이름으로 찾기
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);


        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
