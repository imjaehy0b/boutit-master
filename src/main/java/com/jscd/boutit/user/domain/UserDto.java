package com.jscd.boutit.user.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Objects;

public class UserDto {
    private int id;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$",
            message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotBlank
    //@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String pwd;


    @NotBlank(message = "이름은 필수 입력 값 입니다.")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-z0-9-_]{2,13}$",
            message = "닉네임은 특수문자를 제외한 2~13자리여야 합니다.")
    private String nickname;

    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")//문자열로 들어오는값을 데이터형으로 변환핋요
    private String birth;

    @NotBlank
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})",
            message = "올바른 휴대폰 번호를 입력해주세요.")
    private String phone;




    private Date signup_date;
    private Date login_date;
    private Date pwd_chg_date;
    private int state;
    private Date in_date;
    private String in_user;
    private Date up_date;
    private String up_user;


    public UserDto() {}

    public UserDto(int id, String email, String pwd, String name, String nickname, String birth, String phone, Date signup_date, Date login_date, Date pwd_chg_date, int state, Date in_date, String in_user, Date up_date, String up_user) {

        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.phone = phone;
        this.signup_date = signup_date;
        this.login_date = login_date;
        this.pwd_chg_date = pwd_chg_date;
        this.state = state;
        this.in_date = in_date;
        this.in_user = in_user;
        this.up_date = up_date;
        this.up_user = up_user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getSignup_date() {
        return signup_date;
    }

    public void setSignup_date(Date signup_date) {
        this.signup_date = signup_date;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }

    public Date getPwd_chg_date() {
        return pwd_chg_date;
    }

    public void setPwd_chg_date(Date pwd_chg_date) {
        this.pwd_chg_date = pwd_chg_date;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public String getIn_user() {
        return in_user;
    }

    public void setIn_user(String in_user) {
        this.in_user = in_user;
    }

    public Date getUp_date() {
        return up_date;
    }

    public void setUp_date(Date up_date) {
        this.up_date = up_date;
    }

    public String getUp_user() {
        return up_user;
    }

    public void setUp_user(String up_user) {
        this.up_user = up_user;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birth='" + birth + '\'' +
                ", phone='" + phone + '\'' +
                ", signup_date=" + signup_date +
                ", login_date=" + login_date +
                ", pwd_chg_date=" + pwd_chg_date +
                ", state=" + state +
                ", in_date=" + in_date +
                ", in_user='" + in_user + '\'' +
                ", up_date=" + up_date +
                ", up_user='" + up_user + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id == userDto.id && Objects.equals(email, userDto.email) && Objects.equals(pwd, userDto.pwd) && Objects.equals(name, userDto.name) && Objects.equals(nickname, userDto.nickname) && Objects.equals(birth, userDto.birth) && Objects.equals(phone, userDto.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, pwd, name, nickname, birth, phone);
    }
}
