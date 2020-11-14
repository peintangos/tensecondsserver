package com.example.tensecondsserver.Repository;


import com.example.tensecondsserver.DAO.UserRecord;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRecordRepository extends CrudRepository<UserRecord,String> {
    @Query("select * from UserRecord where username = :username")
    public Optional<UserRecord> findByUsername(String username);
}
