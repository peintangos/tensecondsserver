package com.example.tensecondsserver.Repository;

import com.example.tensecondsserver.DAO.JustGetMiddleWorldRecord;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JustGetMiddleWorldRecordRepository extends CrudRepository<JustGetMiddleWorldRecord,String> {
    @Query("select * from JustGetMiddleWorldRecord where name = :name")
    public List<JustGetMiddleWorldRecord> findByName(String name);
}
