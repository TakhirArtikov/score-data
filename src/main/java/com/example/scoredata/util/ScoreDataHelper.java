package com.example.scoredata.util;

import com.example.scoredata.entity.ScoreData;
import com.example.scoredata.repository.ScoreDataRepository;
import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.ZeebeWorker;
import io.grpc.StatusRuntimeException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Component
public class ScoreDataHelper {

    private final ScoreDataRepository repository;
    private ZeebeClient zeebeClient;


    public Map<String,String> getScoreData() throws Exception {
        List<ScoreData> scoreData = repository.findAll();
        Map<String, String> map = new HashMap<>();
        for (ScoreData data:scoreData) {
            map.put(data.getName(), data.getValue());
        }
        return map;
    }
    @ZeebeWorker(type = "score_data")
    public void getScoreData(final JobClient client, final ActivatedJob activatedJob) throws Exception{
        zeebeClient.newCompleteCommand(activatedJob.getKey())
                .variables(getScoreData())
                .send()
                .whenCompleteAsync((object, throwable) ->{
                            if(throwable==null){

                            }
                            else if(throwable instanceof StatusRuntimeException){
                                log.error("Camunda: {}", ((StatusRuntimeException) throwable).getStatus());
                            }
                        }
                );
    }
}