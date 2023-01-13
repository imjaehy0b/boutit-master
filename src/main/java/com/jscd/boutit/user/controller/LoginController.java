package com.jscd.boutit.user.controller;

import com.jscd.boutit.user.dao.UserDao;
import com.jscd.boutit.user.domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;



@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    // login_date 로그인 할때마다 업데이트

    @Autowired
    UserDao userDao;

    @GetMapping("/login")
    public UserDto loginForm(@CookieValue(name="user", required = false) String userEmail) throws Exception {

        UserDto userDto = userDao.selectUserByEmail(userEmail);

        return userDto;
    }

    @PostMapping("/login")
    public UserDto login(@RequestBody final UserDto userDto, boolean rememberEmail, String toURL, HttpServletRequest request, HttpServletResponse response) throws Exception {

        if (!loginCheck(userDto)) {
            System.out.println("이메일 비밀번호가 일치하지 않습니다");
            return null;
        }

        System.out.println(rememberEmail);

        HttpSession session = request.getSession();
        session.setAttribute("user", userDao.selectUser(userDto));

        Cookie c;
        if (rememberEmail) {
            c = new Cookie("userDto", userDto.getEmail());
            c.setMaxAge(60 * 60 * 24 * 7);

        } else {
            c = new Cookie("userDto", null);
            c.setMaxAge(0);
        }
        response.addCookie(c);

        UserDto userDto2 = userDao.selectUser(userDto);

        return userDto2;
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
        System.out.println("session.invalidate()");

    }

    @GetMapping("/userInfo")
    public String userInfo() {
        return "userInfo";
    }

    private boolean loginCheck(UserDto userDto){
        UserDto userDto2 = null;

        try {
            userDto2 = userDao.selectUser(userDto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return userDto2 !=null && userDto.getPwd().equals(userDto2.getPwd());
    }
}