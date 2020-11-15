package com.example.tensecondsserver.Service;

import com.example.tensecondsserver.DAO.UserRecord;
import com.example.tensecondsserver.DTO.RequestMessageUser;
import com.example.tensecondsserver.Exception.WrongUserNamePasswordException;
import com.example.tensecondsserver.Repository.UserRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRecordRepository userRecordRepository;
    public void save(RequestMessageUser requestMessageUser){
        if (validate(changeDao(requestMessageUser))){
            userRecordRepository.save(changeDao(requestMessageUser));
        }
    }
    public UserRecord changeDao(RequestMessageUser requestMessageUser){
        return UserRecord.of(requestMessageUser);
    }
    public boolean validate(UserRecord userRecord){
//        既に同じ名前のユーザーがいる場合、パスワードが同じならログインする
        if (userRecordRepository.findByUsername(userRecord.getUsername()).isPresent()){
//            パスワードが間違っている場合
            if (!userRecord.getPassword().equals(userRecordRepository.findByUsername(userRecord.getUsername()).get().getPassword())){
                System.out.println("ミス");
                throw new WrongUserNamePasswordException("パスワードまたは、ユーザーネームが間違っています");
            }else{
//                パスワードがあっている場合は、trueを返す
                return false;
            }
        }
//        初回登録の場合は、falseを返す
        return true;
    }
}
