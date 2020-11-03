package com.example.tensecondsserver.Repository;

import com.example.tensecondsserver.DAO.JustGetMiddleWorldRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustGetMiddleWorldRecordRepository extends CrudRepository<JustGetMiddleWorldRecord,String> {
}
