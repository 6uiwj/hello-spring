package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

//MemberRepository 구현체
public class MemoryMemberRepository implements MemberRepository{
    //save메서드에 저장공간으로 쓸 것
    private static Map<Long, Member> store = new HashMap<>(); //실무에서는 Concurrent HashMap(공유되는 변수일 때)
    private static long sequence = 0L;

    /**
     * 데이터 저장 메서드, Map(store)에 저장
     * id를 자동증감으로 저장해주고, 인자로 받은 member를 저장해준 id를 키로 해서 store에 저장
     * @param member
     * @return
     */
    @Override
    public Member save(Member member) {
        member.setId(++sequence); //id값을 하나씩 올려준 후 저장
        store.put(member.getId(), member); //id를 키로 member 데이터 저장
        return member;
    }

    //id로 찾기
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//null일 때를 대비해 Optional로 감싸줌
    }

    /**
     * Store의 value의 name중에 인자값name과 같은 value를 찾아 반환
     * @param name
     * @return
     */
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)).findAny(); //이름이 같은 것만 찾음(하나라도)
    }

    /**
     * Store(map)의 value만 필요하므로 반환을 List로 해줌
     * @return
     */
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); //member들 반환
    }

    //리포지토리 비우기
    public void clearStore() {
        store.clear();
    }
}
