package com.example.tensecondsserver.DAO;


import com.example.tensecondsserver.DTO.RequestMessageUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Getter
@Setter
@Table("UserRecord")
public class UserRecord {
    @Id
    private int id;
    private String username;
    private String password;
    public UserRecord(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public static UserRecord of(RequestMessageUser requestMessageUser){
        return new UserRecord(requestMessageUser.getUsername(),requestMessageUser.getPassword());
    }
}
