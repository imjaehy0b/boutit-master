//package com.jscd.boutit.user.dao;
//
//import com.jscd.boutit.user.domain.UserDto;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class UserDaoImpl implements UserDao {
//
//    //회원가입 쿼리
//    @Override
//    public void join(UserDto userDto) throws Exception {
//        userDao.join(userDto);
//    }
//
//    //이메일 중복 체크 쿼리
//    @Override
//    public int emailCheck(String email) throws Exception {
//        return userDao.emailCheck(email);
//    }
//
//    //닉네임 중복 체크
//    @Override
//    public int nickCheck(String nickname) throws Exception {
//
//        return userDao.nickCheck(nickname);
//    }
//
//
//    @Autowired
//    private UserDao userDao;
//
//    @Override
//    public UserDto selectUser(UserDto userDto) throws Exception {
//
//        return userDao.selectUser(userDto);
//    }
//
//    @Override
//    public UserDto selectUserByEmail(String userEmail) throws Exception {
//
//        return userDao.selectUserByEmail(userEmail);
//    }
//
//    @Override
//    public int deleteUser(String email) throws Exception {
//        return userDao.deleteUser(email);
//    }
//
//    @Override
//    public int deleteAll() throws Exception {
//        return userDao.deleteAll();
//    }
//
//    @Override
//    public void insertUser(UserDto userDto) throws Exception {
//        userDao.insertUser(userDto);
//    }
//
//    @Override
//    public int userCount() throws Exception {
//        return userDao.userCount();
//    }
//}
