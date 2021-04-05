package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;          //sequence는 0,1,2 등의 값을 순차적으로 생성한다.

    @Override
    public Member save(Member member) {
        member.setId(++sequence);           //id += 1
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {

        return Optional.ofNullable(store.get(id)); //Optional을 통해 Null도 반환할 수 있도록 함
    }

    @Override
    public Optional<Member> findByName(String name) {

        return store.values().stream()                              //탐색 후 반환
                .filter(member -> member.getName().equals(name)) //입력한 name과 같은 name이 있는지 탐색
                .findAny();                                         //하나라도 있는지 탐색

    }

    @Override
    public Optional<Member> findByAddress(String address) {

        return Optional.ofNullable(store.get(address));
    }

    @Override
    public Optional<Member> findByAge(String age) {

        return Optional.ofNullable(store.get(age));

    }


    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}

