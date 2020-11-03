package com.example.tensecondsserver.DAO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("JustGetMiddleWorldRecord")
public class JustGetMiddleWorldRecord {
    @Id
    private int id;
    private int deviceNumber;
    private LocalDate createdAt;
    private String name;
    private double difference;
}
