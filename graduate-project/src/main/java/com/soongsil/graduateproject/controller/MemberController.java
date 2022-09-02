package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.domain.Member;
import com.soongsil.graduateproject.dto.MemberLoginDto;
import com.soongsil.graduateproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입 폼으로 이동
    @GetMapping("/signup")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "signup";
    }

    //회원가입
    @PostMapping("/signup")
    public String saveMember(@ModelAttribute @Valid MemberForm memberForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "signup";
        }

        Member member = new Member(
                memberForm.getLoginId(),
                memberForm.getPassword(),
                memberForm.getName(),
                memberForm.getEMail(),
                memberForm.getPhoneNumber()
        );
        memberService.join(member);
        return "signup";
    }

    //로그인 폼
    @GetMapping("/login")
    public String loginForm(@ModelAttribute("loginForm") MemberLoginDto loginForm){
        return "login/loginForm";
    }

    //로그인
    @PostMapping("/login")
    public String login(@ModelAttribute("loginForm") MemberLoginDto loginForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }

        Member loginMember = memberService.login(loginForm.getLoginId(), loginForm.getPassword());

        if(loginMember == null){
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 틀렸습니다");
            return "login/loginForm";
        }
        //TODO: 로그인 성공 처리 로직 구현 -> 세션 이용
        return "redirect:/";
    }

}
