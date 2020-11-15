package com.example.tensecondsserver.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ResponseMessageCountTimeLabel implements Serializable {
    public Map<Integer, List<ResponseMessageCountTime>> map;
    public ResponseMessageCountTimeLabel(Map<Integer,List<ResponseMessageCountTime>> map){
        this.map = map;
    }
}
