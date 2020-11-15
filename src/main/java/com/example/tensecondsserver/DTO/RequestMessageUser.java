package com.example.tensecondsserver.DTO;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RequestMessageUser {
    private String username;
    private String password;
    private String uuid;
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }

    public String getUuid() {
        return uuid;
    }
}
