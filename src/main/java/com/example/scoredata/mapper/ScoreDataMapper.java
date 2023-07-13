package com.example.scoredata.mapper;

import com.example.scoredata.dto.ScoreDataDto;
import com.example.scoredata.entity.ScoreData;
import org.springframework.stereotype.Component;

@Component
public class ScoreDataMapper {
    public ScoreDataDto toDto(ScoreData data){
        ScoreDataDto dataDto=new ScoreDataDto();
        dataDto.setName(data.getName());
        dataDto.setValue(data.getValue());

        return dataDto;
    }

    public ScoreData toEntity(ScoreDataDto dto){
        ScoreData data=new ScoreData();
        data.setName(dto.getName());
        data.setValue(dto.getValue());
        return data;
    }
}
