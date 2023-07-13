package com.example.scoredata.repository;

import com.example.scoredata.entity.ScoreData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreDataRepository extends JpaRepository<ScoreData,String> {
}
