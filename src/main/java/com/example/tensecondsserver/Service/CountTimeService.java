package com.example.tensecondsserver.Service;

import com.example.tensecondsserver.DAO.CountTimeWorldRecord;
import com.example.tensecondsserver.DAO.JustGetMiddleWorldRecord;
import com.example.tensecondsserver.DTO.RequestMessageCountTime;
import com.example.tensecondsserver.DTO.ResponseMessageCountTime;
import com.example.tensecondsserver.Repository.CountTimeWorldRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CountTimeService {
    @Autowired
    private CountTimeWorldRecordRepository countTimeWorldRecordRepository;
    public void save(RequestMessageCountTime requestMessageCountTime){
        countTimeWorldRecordRepository.save(CountTimeWorldRecord.of(requestMessageCountTime));
    }
    public List<ResponseMessageCountTime> all(){
        List<ResponseMessageCountTime> list = new ArrayList<>();
        List<CountTimeWorldRecord> listDao = StreamSupport.stream(countTimeWorldRecordRepository.findAll().spliterator(),false).collect(Collectors.toList());
        return changeToDto(listDao);
    }
    public List<ResponseMessageCountTime> changeToDto(List<CountTimeWorldRecord> list ){
        List<ResponseMessageCountTime> responseMessageCountTimes = new ArrayList<>();
        list.stream().forEach(e -> responseMessageCountTimes.add(ResponseMessageCountTime.of(e)));
        return responseMessageCountTimes;
    }
}
