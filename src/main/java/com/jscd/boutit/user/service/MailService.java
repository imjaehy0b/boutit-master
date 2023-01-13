package com.jscd.boutit.user.service;

import com.jscd.boutit.user.domain.MailDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender mailSender;







    //원하는 메일정보 입력
    public void mailSend(MailDto mailDto){
        String str = getTempPassword();
        SimpleMailMessage message = new SimpleMailMessage();

        mailDto.setTitle("안녕하세요. 13outit 인증 안내 관련 이메일 입니다 ");
        mailDto.setMessage("인증번호는" + str + " 입니다.");

        message.setTo(mailDto.getAddress());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());

        System.out.println("message = " + message);
        mailSender.send(message);
    }

//    public void mailSend(MailDto mailDto){
//        SimpleMailMessage message = new SimpleMailMessage(); //메세지 정보 객체
//
//        message.setTo(mailDto.getAddress()); //받는사람 주소
//        message.setFrom(MailService.FROM_ADDRESS); //보내는사람 주소 위에있음
//        message.setSubject(mailDto.getTitle()); //제목
//        message.setText(mailDto.getMessage()); //메세지내용
//
//        mailSender.send(message); //메세지 객체를 메일샌더에 담아서 전송
//    }


    public String getTempPassword(){
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
    }

}
