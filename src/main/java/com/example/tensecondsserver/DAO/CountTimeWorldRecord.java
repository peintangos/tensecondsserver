package com.example.tensecondsserver.DAO;


import com.example.tensecondsserver.DTO.RequestMessageCountTime;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("CountTimeWorldRecord")
@Getter
@Setter
public class CountTimeWorldRecord {
    @Id
    private int id;
    private String deviceNumber;
    private String createdAt;
    private String name;
    private double timeDifference;

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
        return this.timeDifference;
    }

    public CountTimeWorldRecord(String deviceNumber,String createdAt,String name,double timeDifference) {
        this.deviceNumber = deviceNumber;
        this.createdAt  = createdAt;
        this.name = name;
        this.timeDifference = timeDifference;
    }

    public static CountTimeWorldRecord of(RequestMessageCountTime requestMessageCountTime){
        return new CountTimeWorldRecord(requestMessageCountTime.getDeviceNumber()
                ,requestMessageCountTime.getCreatedAt(),requestMessageCountTime.getName()
                ,requestMessageCountTime.getTimeDifference());
    }
}

