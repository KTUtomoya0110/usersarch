package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private String id;
    private String username;

    public String getUsername() {// DBからusername取得
        return username;
    }

    public void setUsername(String username) {// usernamaをセット
        this.username = username;
    }
}
