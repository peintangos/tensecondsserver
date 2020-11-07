package com.example.tensecondsserver.Repository;

import com.example.tensecondsserver.DAO.CountTimeWorldRecord;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CountTimeWorldRecordRepository extends CrudRepository<CountTimeWorldRecord,String> {
    @Query("select * from CountTimeWorldRecord where name = :name")
    public Optional<List<CountTimeWorldRecord>> findByName(String name);
}
