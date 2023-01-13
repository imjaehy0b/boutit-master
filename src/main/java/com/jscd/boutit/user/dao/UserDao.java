package com.jscd.boutit.user.dao;

import com.jscd.boutit.user.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface UserDao {


    //회원가입
    public void join(UserDto userDto) throws Exception;

    //email중복체크
    public int emailCheck(String email) throws Exception;

    //닉네임 중복체크
    public int nickCheck(String nickname) throws Exception;


    UserDto selectUser(UserDto userDto) throws Exception;

    UserDto selectUserByEmail(String userEmail) throws Exception;

    void insertUser(UserDto userDto) throws Exception;

    int deleteUser(String email) throws Exception;

    int deleteAll() throws Exception;

    int userCount() throws Exception;
}
