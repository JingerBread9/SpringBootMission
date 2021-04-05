package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);      //Null 반환 대신 Optional로 감싸서 반환
    Optional<Member> findByName(String name);
    Optional<Member> findByAddress(String address);
    Optional<Member> findByAge(String age);
    List<Member> findAll();
}
