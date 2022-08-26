package com.soongsil.graduateproject.controller;

import com.soongsil.graduateproject.domain.Member;
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

    @GetMapping("/signup")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "signup";
    }

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


}
