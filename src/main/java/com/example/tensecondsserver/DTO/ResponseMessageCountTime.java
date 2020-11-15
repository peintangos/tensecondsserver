package com.example.tensecondsserver.DTO;

import com.example.tensecondsserver.DAO.CountTimeWorldRecord;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ResponseMessageCountTime implements Serializable {
    private int id;
    private String deviceNumber;
    private String createdAt;
    private String name;
    private double timeDifference;
    public ResponseMessageCountTime(int id,String deviceNumber,String createdAt,String name,double timeDifference) {
        this.id = id;
        this.deviceNumber = deviceNumber;
        this.createdAt  = createdAt;
        this.name = name;
        this.timeDifference = timeDifference;
    }
    public static ResponseMessageCountTime of(CountTimeWorldRecord countTimeWorldRecord){
        return new ResponseMessageCountTime(countTimeWorldRecord.getId(),countTimeWorldRecord.getDeviceNumber(),countTimeWorldRecord.getCreatedAt(),countTimeWorldRecord.getName(),countTimeWorldRecord.getTimeDifference());
    }

    public String getName() {
        return name;
    }
}
