package com.example.tensecondsserver.Repository;


import com.example.tensecondsserver.DAO.UserRecord;
import org.springframework.data.repository.CrudRepository;

public interface UserRecordRepository extends CrudRepository<UserRecord,String> {
}
