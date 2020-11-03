package com.example.tensecondsserver.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RequestMessageJustGetMiddle {
    private String deviceNumber;
    private String createdAt;
    private String name;
    private double difference;
    public String getDeviceNumber(){
        return this.deviceNumber;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public String getName(){
        return name;
    }
    public double getDifference(){
        return this.difference;
    }
}
