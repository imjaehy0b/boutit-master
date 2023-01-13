package com.jscd.boutit.user.service;

import com.jscd.boutit.user.domain.UserDto;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    //회원가입
    @Transactional
    public void join(UserDto userDto) throws Exception;

    //이메일 중복 체크
    public int emailCheck(String email) throws Exception;

    //닉네임 중복 체크
    public int nickCheck(String nickname)throws Exception;
}
