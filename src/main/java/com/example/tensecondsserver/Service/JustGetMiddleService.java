package com.example.tensecondsserver.Service;

import com.example.tensecondsserver.DAO.CountTimeWorldRecord;
import com.example.tensecondsserver.DAO.JustGetMiddleWorldRecord;
import com.example.tensecondsserver.DTO.RequestMessageJustGetMiddle;
import com.example.tensecondsserver.DTO.ResponseMessageCountTime;
import com.example.tensecondsserver.DTO.ResponseMessageJustGetMiddle;
import com.example.tensecondsserver.DTO.ResponseMessageJustGetMiddleLabel;
import com.example.tensecondsserver.Exception.NoKeyWordException;
import com.example.tensecondsserver.Repository.JustGetMiddleWorldRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

@Service
public class JustGetMiddleService {
    @Autowired
    private JustGetMiddleWorldRecordRepository justGetMiddleWorldRecordRepository;
    public void save(RequestMessageJustGetMiddle requestMessageJustGetMiddle){
        justGetMiddleWorldRecordRepository.save(JustGetMiddleWorldRecord.of(requestMessageJustGetMiddle));
    }
    public List<ResponseMessageJustGetMiddle> all(){
        List<JustGetMiddleWorldRecord> justGetMiddleWorldRecords =
                StreamSupport.stream(justGetMiddleWorldRecordRepository.findAll().spliterator(),false)
                .sorted(Comparator.comparing(JustGetMiddleWorldRecord::getTimeDifference))
                .collect(Collectors.toList());
        return changeToDto(justGetMiddleWorldRecords);
    }
    public List<ResponseMessageJustGetMiddle> allLimit(int count){
        List<JustGetMiddleWorldRecord> justGetMiddleWorldRecords =
                StreamSupport.stream(justGetMiddleWorldRecordRepository.findAll().spliterator(),false)
                        .sorted(Comparator.comparing(JustGetMiddleWorldRecord::getTimeDifference))
                        .limit(count)
                        .collect(Collectors.toList());
        return changeToDto(justGetMiddleWorldRecords);
    }
    public List<ResponseMessageJustGetMiddle> changeToDto(List<JustGetMiddleWorldRecord> list){
        List<ResponseMessageJustGetMiddle> responseMessageJustGetMiddles = new ArrayList<>();
        list.stream().forEach(e -> responseMessageJustGetMiddles.add(ResponseMessageJustGetMiddle.of(e)));
        return responseMessageJustGetMiddles;
    }
    public String findByKeyword(String key){
        List<JustGetMiddleWorldRecord> list = StreamSupport.stream(justGetMiddleWorldRecordRepository.findAll().spliterator(),false)
                .sorted(Comparator.comparing(JustGetMiddleWorldRecord::getTimeDifference))
                .collect(Collectors.toList());
        JustGetMiddleWorldRecord justGetMiddleWorldRecord = justGetMiddleWorldRecordRepository.findByName(key)
                .stream()
                .sorted(Comparator.comparing(JustGetMiddleWorldRecord::getTimeDifference))
                .findFirst().orElseThrow(() ->new NoKeyWordException("レコードがありません"));
        int index = list.indexOf(justGetMiddleWorldRecord);
        if (index == -1){
            return "ランキング外";
        }else {
            return String.valueOf(index + 1);
        }
    }
    public int findByKeywordInt(String key){
        List<JustGetMiddleWorldRecord> list = StreamSupport.stream(justGetMiddleWorldRecordRepository.findAll().spliterator(),false)
                .sorted(Comparator.comparing(JustGetMiddleWorldRecord::getTimeDifference))
                .collect(Collectors.toList());
        JustGetMiddleWorldRecord justGetMiddleWorldRecord = justGetMiddleWorldRecordRepository.findByName(key)
                .stream()
                .sorted(Comparator.comparing(JustGetMiddleWorldRecord::getTimeDifference))
                .findFirst().orElseThrow(IllegalArgumentException::new);
        int index = list.indexOf(justGetMiddleWorldRecord);
        return index == -1 ? -1 : index + 1;
    }
    public double allCount(){
        return StreamSupport.stream(justGetMiddleWorldRecordRepository.findAll().spliterator(),false)
                .sorted(Comparator.comparing(JustGetMiddleWorldRecord::getTimeDifference)).count();
    }
    public ResponseMessageJustGetMiddleLabel listByLebel(){
        return new ResponseMessageJustGetMiddleLabel(getMap());
    }
    public Map<Integer,List<ResponseMessageJustGetMiddle>> getMap(){
        Map<Integer,List<ResponseMessageJustGetMiddle>> map = new HashMap<>();
        int countMax = 19;
        int one = 0;
//        クライアントのセクション数と合わせたいため、0スタートの20この配列を作成
        IntStream.rangeClosed(one,countMax).forEach(index ->
                map.put(index,new ArrayList<ResponseMessageJustGetMiddle>())
        );
        all().stream().forEach(responseMessageJustGetMiddle ->{
//            スコアに対し、割合を設定している。
//          冷静にこれダメじゃね。順位を出さないと。
//          double changedIdForCalu = (double)responseMessageJustGetMiddle.getId();
            double changedIdForCalu = findByKeywordInt(responseMessageJustGetMiddle.getName());
            double score = changedIdForCalu / allCount();
            setValue(map,score,responseMessageJustGetMiddle);
        }
        );
        return map;
    }
//    Mapと数字を引数にとり、ランクを返す
    public String getRank(Map<Integer,List<ResponseMessageJustGetMiddle>> map,int index){
        int amount = 0;
        for (int i=0; i<map.values().size();i++){
            amount += map.get(i).size();
            if (index <= amount){
                return String.valueOf(i);
            }
        }
        return String.valueOf(19);
    }
    public void setValue(Map<Integer,List<ResponseMessageJustGetMiddle>> map, double score,ResponseMessageJustGetMiddle responseMessageJustGetMiddle){
        if(hantei(score,0,0.2)){
            map.get(19).add(responseMessageJustGetMiddle);
         return;
        }
        if(hantei(score,0.2,0.3)){
            map.get(18).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.3,0.4)){
            map.get(17).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.4,0.5)){
            map.get(16).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.5,0.55)){
            map.get(15).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.55,0.6)){
            map.get(14).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.6,0.7)){
            map.get(13).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.7,0.8)){
            map.get(12).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.8,0.85)){
            map.get(11).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.85,0.9)){
            map.get(10).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.9,0.91)){
            map.get(9).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.91,0.92)){
            map.get(8).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.92,0.93)){
            map.get(7).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.93,0.94)){
            map.get(6).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.94,0.95)){
            map.get(5).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.95,0.96)){
            map.get(4).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.96,0.97)){
            map.get(3).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.97,0.98)){
            map.get(2).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.98,0.99)){
            map.get(1).add(responseMessageJustGetMiddle);
            return;
        }
        if(hantei(score,0.99,1.00)){
            map.get(0).add(responseMessageJustGetMiddle);
            return;
        }

    }
//    符号の関係上、ランクが一番上の人は存在しないことになる
    public boolean hantei(double score, double min,double max){
        return score >= min && score < max;
    }

}

