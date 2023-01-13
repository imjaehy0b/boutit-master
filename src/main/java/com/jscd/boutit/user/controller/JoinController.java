package com.jscd.boutit.user.controller;


import com.jscd.boutit.user.domain.MailDto;
import com.jscd.boutit.user.domain.UserDto;
import com.jscd.boutit.user.service.MailService;
import com.jscd.boutit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@Controller
public class JoinController {
    private static final Logger Logger = LoggerFactory.getLogger(JoinController.class);

    @Autowired
    private UserService service;

    @Autowired
    private MailService mailService;

    //회원가입 get
    @GetMapping("/join")
    public String  getJoin(Model model) throws Exception{
        Logger.info("get join");
        model.addAttribute("userDto", new UserDto());
        return "join";
    }


    //회원가입 post
    @PostMapping("/join")
    public String  postJoin(@Valid UserDto userDto, BindingResult bindingResult, Model model) throws Exception{
        Logger.info("postJoin.dto"+userDto);


        //유효성 검사
        if (bindingResult.hasErrors()) {
            /* 회원가입 실패시 입력 데이터 값을 유지 */
            model.addAttribute("userDto", userDto);
//
//            //유효성 검사 통과 실패한 필드와 메세지 핸들링
            Map<String, String> errorMap = new HashMap<>();

            for(FieldError error : bindingResult.getFieldErrors()) {
                errorMap.put("valid_"+error.getField(), error.getDefaultMessage());
                Logger.info("error message : "+error.getDefaultMessage());
            }
            //회원가입 실패시 다시 로그인 페이지로
            return "join";
        }

        //성공시 db에 값입력후 홈으로
        service.join(userDto);

        return "redirect:/";
    }


    //이메일 중복 체크 -> rest로?
    @ResponseBody
    @PostMapping("/emailCheck")
    public int emailCheck(@RequestParam("email") String email) throws Exception{
        int result = service.emailCheck(email);
        return result;
    }

    //

    //닉네임 중복 체크
    @ResponseBody
    @PostMapping("/nickCheck")
    public int nickNameCheck(@RequestParam("nickname") String nickname) throws Exception{
        int result = service.nickCheck(nickname);
        return result;
    }


    //네이버 로그인
    @GetMapping("/NaverLogin")
    public String loginGet(){
        return "NaverLogin";
    }

    @GetMapping("/NaverPostLogin")
    public String loginPostNaver(HttpSession session){
        return "NaverPostLogin";
    }


    //이메일 인증
    @GetMapping("/mail")
    public String dispMail() {
        return "mail";
    }

    @PostMapping("/mail")
    public void execMail(MailDto mailDto) {
        mailService.mailSend(mailDto);
    }

}



