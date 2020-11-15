package com.example.tensecondsserver.Service;

import com.example.tensecondsserver.DAO.CountTimeWorldRecord;
import com.example.tensecondsserver.DAO.JustGetMiddleWorldRecord;
import com.example.tensecondsserver.DTO.RequestMessageCountTime;
import com.example.tensecondsserver.DTO.ResponseMessageCountTime;
import com.example.tensecondsserver.DTO.ResponseMessageCountTimeLabel;
import com.example.tensecondsserver.Exception.NoKeyWordException;
import com.example.tensecondsserver.Repository.CountTimeWorldRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        List<CountTimeWorldRecord> listDao = StreamSupport
                .stream(countTimeWorldRecordRepository.findAll().spliterator(),false)
                .sorted(Comparator.comparing(CountTimeWorldRecord::getTimeDifference))
                .collect(Collectors.toList());
        return changeToDto(listDao);
    }
    public List<ResponseMessageCountTime> changeToDto(List<CountTimeWorldRecord> list ){
        List<ResponseMessageCountTime> responseMessageCountTimes = new ArrayList<>();
        list.stream().forEach(e -> responseMessageCountTimes.add(ResponseMessageCountTime.of(e)));
        return responseMessageCountTimes;
    }
    public String getByKeyword(String keyword){
        List<CountTimeWorldRecord> listDao = StreamSupport
                .stream(countTimeWorldRecordRepository.findAll().spliterator(),false)
                .sorted(Comparator.comparing(CountTimeWorldRecord::getTimeDifference))
                .collect(Collectors.toList());
        CountTimeWorldRecord countTimeWorldRecord = countTimeWorldRecordRepository.findByName(keyword)
                .orElseThrow(IllegalArgumentException::new)
                .stream().sorted(Comparator.comparing(CountTimeWorldRecord::getTimeDifference)).findFirst().orElseThrow(() -> new NoKeyWordException("レコードがありません"));
        int index = listDao.indexOf(countTimeWorldRecord);
        if (index == -1){
            return "ランキング外です";
        }else {
            return String.valueOf(index + 1);
        }
    }
    public int getByKeywordInt(String keyword){
        List<CountTimeWorldRecord> listDao = StreamSupport
                .stream(countTimeWorldRecordRepository.findAll().spliterator(),false)
                .sorted(Comparator.comparing(CountTimeWorldRecord::getTimeDifference))
                .collect(Collectors.toList());
        CountTimeWorldRecord countTimeWorldRecord = countTimeWorldRecordRepository.findByName(keyword)
                .orElseThrow(IllegalArgumentException::new)
                .stream().sorted(Comparator.comparing(CountTimeWorldRecord::getTimeDifference)).findFirst().orElseThrow(() -> new NoKeyWordException("レコードがありません"));
        int index = listDao.indexOf(countTimeWorldRecord);
        return index == -1 ? -1 :index + 1;
    }
    public ResponseMessageCountTimeLabel listByLabel(){
        return new ResponseMessageCountTimeLabel(getMap());
    }
    public double allCount(){
        return (double)all().stream().count();
    }
    public Map<Integer,List<ResponseMessageCountTime>> getMap(){
        Map<Integer,List<ResponseMessageCountTime>> map = new HashMap<>();
        IntStream.rangeClosed(0,19).forEach(index -> map.put(index,new ArrayList<>()));
        all().forEach(responseMessageCountTime -> {
            double score = (double)this.getByKeywordInt(responseMessageCountTime.getName());
            double rank = score / allCount();
            setValue(map,responseMessageCountTime,rank);
        });
        return map;
    }
    public String getRank(Map<Integer,List<ResponseMessageCountTime>> map,String keyword){
        int amount = 0;
        int yourScore = this.getByKeywordInt(keyword);
        for (int index = 0;index <map.values().size();index++){
            amount += map.get(index).size();
            if (yourScore <= amount){
                return String.valueOf(index);
            }
        }
        return "19";
    }

    public void setValue(Map<Integer,List<ResponseMessageCountTime>> map,ResponseMessageCountTime responseMessageCountTime,double score){
        if(hantei(score,0,0.2)){
            map.get(19).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.2,0.3)){
            map.get(18).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.3,0.4)){
            map.get(17).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.4,0.5)){
            map.get(16).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.5,0.55)){
            map.get(15).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.55,0.6)){
            map.get(14).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.6,0.7)){
            map.get(13).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.7,0.8)){
            map.get(12).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.8,0.85)){
            map.get(11).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.85,0.9)){
            map.get(10).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.9,0.91)){
            map.get(9).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.91,0.92)){
            map.get(8).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.92,0.93)){
            map.get(7).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.93,0.94)){
            map.get(6).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.94,0.95)){
            map.get(5).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.95,0.96)){
            map.get(4).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.96,0.97)){
            map.get(3).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.97,0.98)){
            map.get(2).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.98,0.99)){
            map.get(1).add(responseMessageCountTime);
            return;
        }
        if(hantei(score,0.99,1.00)){
            map.get(0).add(responseMessageCountTime);
            return;
        }

    }
    public boolean hantei(double score, double min,double max){
        return score >= min && score < max;
    }
}
