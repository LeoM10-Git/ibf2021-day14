package com.example.ibf2021d13.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("User")
public class User implements Serializable {
    // add Serializable serialVersionUID
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;
    private String phoneNumber;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "UserId: " + id + '\n' +
                "name: " + name + '\n' +
                "email: " + email + '\n' +
                "phoneNumber: " + phoneNumber + '\n';
    }
}
