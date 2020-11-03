package com.example.tensecondsserver.Service;

import com.example.tensecondsserver.DAO.CountTimeWorldRecord;
import com.example.tensecondsserver.DAO.JustGetMiddleWorldRecord;
import com.example.tensecondsserver.DTO.RequestMessageJustGetMiddle;
import com.example.tensecondsserver.DTO.ResponseMessageCountTime;
import com.example.tensecondsserver.DTO.ResponseMessageJustGetMiddle;
import com.example.tensecondsserver.Repository.JustGetMiddleWorldRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class JustGetMiddleService {
    @Autowired
    private JustGetMiddleWorldRecordRepository justGetMiddleWorldRecordRepository;
    public void save(RequestMessageJustGetMiddle requestMessageJustGetMiddle){
        justGetMiddleWorldRecordRepository.save(JustGetMiddleWorldRecord.of(requestMessageJustGetMiddle));
    }
    public List<ResponseMessageJustGetMiddle> all(){
        List<JustGetMiddleWorldRecord> justGetMiddleWorldRecords = StreamSupport.stream(justGetMiddleWorldRecordRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return changeToDto(justGetMiddleWorldRecords);
    }
    public List<ResponseMessageJustGetMiddle> changeToDto(List<JustGetMiddleWorldRecord> list){
        List<ResponseMessageJustGetMiddle> responseMessageJustGetMiddles = new ArrayList<>();
        list.stream().forEach(e -> responseMessageJustGetMiddles.add(ResponseMessageJustGetMiddle.of(e)));
        return responseMessageJustGetMiddles;
    }
}
