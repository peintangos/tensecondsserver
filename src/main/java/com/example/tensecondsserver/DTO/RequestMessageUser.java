package com.example.tensecondsserver.DTO;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RequestMessageUser {
    private String username;
    private String password;
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
}
