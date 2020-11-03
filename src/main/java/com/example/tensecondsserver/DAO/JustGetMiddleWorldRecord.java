package com.example.tensecondsserver.DAO;

import com.example.tensecondsserver.DTO.RequestMessageJustGetMiddle;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("JustGetMiddleWorldRecord")
public class JustGetMiddleWorldRecord {
    @Id
    private int id;
    private String deviceNumber;
    private String createdAt;
    private String name;
    private double difference;
    public JustGetMiddleWorldRecord(String deviceNumber,String createdAt,String name,double difference){
        this.deviceNumber = deviceNumber;
        this.createdAt = createdAt;
        this.name = name;
        this.difference = difference;
    }
    public static JustGetMiddleWorldRecord of(RequestMessageJustGetMiddle requestMessageJustGetMiddle){
        return new JustGetMiddleWorldRecord(requestMessageJustGetMiddle.getDeviceNumber(),requestMessageJustGetMiddle.getCreatedAt(),requestMessageJustGetMiddle.getName(),requestMessageJustGetMiddle.getDifference());
    }
    public int getId(){
        return this.id;
    }
    public String getDeviceNumber(){
        return this.deviceNumber;
    }
    public String getCreatedAt(){
        return this.createdAt;
    }
    public String getName(){
        return this.name;
    }
    public double getTimeDifference(){
        return this.difference;
    }
}
