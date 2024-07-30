package com.example.crud.Dto;

//Dto에는 전달하고자 하는 필드 객체를 선언하고 getter/setter 메서드를 구현한다
public class MemberDto {

    private String name;
    private String email;
    private String organization;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "name=" + name + "\n" +
                ", email=" + email + "\n" +
                ", organization=" + organization + "\n" +
                '}';
    }
}
