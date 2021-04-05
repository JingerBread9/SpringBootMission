package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")                    //데이터값 입력 및 전송시 사용
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("이름 : " +member.getName());
        System.out.println("나이 : " +member.getAge());
        System.out.println("주소 : " +member.getAddress());

        memberService.join(member);

        return "redirect:/"; //회원가입 끝난 후 홈url로 redirect

    }

    @GetMapping("/members")
    public String List(Model model) {
        List<Member> members  =memberService.findMembers();
        model.addAttribute("members", members);
        return "members/member_list";
    }

}
