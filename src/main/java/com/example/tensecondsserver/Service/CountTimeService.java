package com.example.tensecondsserver.Service;

import com.example.tensecondsserver.Repository.CountTimeWorldRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountTimeService {
    @Autowired
    private CountTimeWorldRecordRepository countTimeWorldRecordRepository;
}
