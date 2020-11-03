package com.example.tensecondsserver.DTO;


import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
public class RequestMessageCountTime implements Serializable {
    private String deviceNumber;
    private String createdAt;
    private String name;
    private double timeDifference;

//    Lombokがやってくれるはずなのに、反応しないので、自分で作成
    public String getDeviceNumber(){
        return deviceNumber;
    }
    public String getCreatedAt(){
        return createdAt;
    }
    public String getName(){
        return name;
    }
    public double getTimeDifference(){
        return timeDifference;
    }
}
