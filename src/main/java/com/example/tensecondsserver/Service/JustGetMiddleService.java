package com.example.tensecondsserver.Service;

import com.example.tensecondsserver.Repository.JustGetMiddleWorldRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JustGetMiddleService {
    @Autowired
    private JustGetMiddleWorldRecordRepository justGetMiddleWorldRecordRepository;
}
