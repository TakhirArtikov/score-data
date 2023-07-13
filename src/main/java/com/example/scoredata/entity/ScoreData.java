package com.example.scoredata.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "score_data")
@Data
public class ScoreData {
    @Id
    private String name;

    private String value;
}
