package com.example.tensecondsserver.DTO;

import com.example.tensecondsserver.DAO.CountTimeWorldRecord;
import com.example.tensecondsserver.DAO.JustGetMiddleWorldRecord;
import com.example.tensecondsserver.Service.JustGetMiddleService;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseMessageJustGetMiddle implements Serializable {
    private int id;
    private String deviceNumber;
    private String createdAt;
    private String name;
    private double difference;


    public ResponseMessageJustGetMiddle(int id,String deviceNumber,String createdAt,String name,double difference) {
        this.id = id;
        this.deviceNumber = deviceNumber;
        this.createdAt  = createdAt;
        this.name = name;
        this.difference = difference;
    }
    public static ResponseMessageJustGetMiddle of(JustGetMiddleWorldRecord justGetMiddleWorldRecord){
        return new ResponseMessageJustGetMiddle(justGetMiddleWorldRecord.getId(),justGetMiddleWorldRecord.getDeviceNumber(),justGetMiddleWorldRecord.getCreatedAt(),justGetMiddleWorldRecord.getName(),justGetMiddleWorldRecord.getTimeDifference());
    }
}
