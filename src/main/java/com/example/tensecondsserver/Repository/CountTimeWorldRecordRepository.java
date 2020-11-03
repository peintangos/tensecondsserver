package com.example.tensecondsserver.Repository;

import com.example.tensecondsserver.DAO.CountTimeWorldRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountTimeWorldRecordRepository extends CrudRepository<CountTimeWorldRecord,String> {
}
