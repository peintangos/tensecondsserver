package com.example.tensecondsserver.DTO;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class ResponseMessageJustGetMiddleLabel implements Serializable {
    private Map<Integer, List<ResponseMessageJustGetMiddle>> map;
    public ResponseMessageJustGetMiddleLabel(Map<Integer, List<ResponseMessageJustGetMiddle>> map){
        this.map = map;
    }
}
