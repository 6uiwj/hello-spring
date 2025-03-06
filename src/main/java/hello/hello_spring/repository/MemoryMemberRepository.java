package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MemoryMemberRepository implements MemberRepository{
    //save메서드에 저장공간으로 쓸 것
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    /**
     * 데이터 저장 메서드
     * @param member
     * @return
     */
    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id값을 하나씩 올려준 후 저장
        store.put(member.getId(), member); //id를 키로 member 데이터 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
