package com.example.tensecondsserver.Service;

import com.example.tensecondsserver.DAO.UserRecord;
import com.example.tensecondsserver.DTO.RequestMessageUser;
import com.example.tensecondsserver.Repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRecordRepository userRecordRepository;
    public void save(RequestMessageUser requestMessageUser){
        userRecordRepository.save(changeDao(requestMessageUser));
    }
    public UserRecord changeDao(RequestMessageUser requestMessageUser){
        return UserRecord.of(requestMessageUser);
    }
}
