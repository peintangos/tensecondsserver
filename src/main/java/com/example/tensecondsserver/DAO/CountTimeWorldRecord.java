package com.example.tensecondsserver.DAO;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@Table("CountTimeWorldRecord")
public class CountTimeWorldRecord {
    @Id
    private int id;
    private int deviceNumber;
    private LocalDate createdAt;
    private String name;
    private double timeDifference;
}

