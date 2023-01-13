package com.jscd.boutit.user.service;

import com.jscd.boutit.user.dao.UserDao;
import com.jscd.boutit.user.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //회원가입
    @Override
    public void join(UserDto userDto) throws Exception {
    //비밀번호 암호화해서 저장
    //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //dto.setPwd(passwordEncoder.encode(dto.getPwd()));
        userDao.join(userDto);
    }

    //이메일 중복 체크
    @Override
    public int emailCheck(String email) throws Exception {
        return userDao.emailCheck(email);
    }

    //닉네임 중복 체크
    @Override
    public int nickCheck(String nickname) throws Exception {
        int result = userDao.nickCheck(nickname);
        return result;
    }

}
