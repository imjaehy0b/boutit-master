package com.jscd.boutit.user.domain;



//발송할 이메일 내용 저장하는 객체
public class MailDto {
    private String address; //메일주소
    private String title;   //메일제목
    private String message; //메일내용;

    public MailDto(){}

    public MailDto(String address, String title, String message) {
        this.address = address;
        this.title = title;
        this.message = message;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
