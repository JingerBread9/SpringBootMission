package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("Hello");



        //when
        Long saveId = memberService.join(member);



        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");


        //when
        memberService.join(member1);
        assertThrows(NullPointerException.class, () -> memberService.join(member2));

        /*
        try {
            memberService.join(member2);
            fail("예외 처리가 발생하지 않았습니다.");                     //위의 exception 처리가 실행이 안되면 fai() 실행
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */


        //then


    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}