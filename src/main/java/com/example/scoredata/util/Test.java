package com.example.scoredata.util;

import com.example.scoredata.repository.ScoreDataRepository;
import io.camunda.zeebe.client.ZeebeClient;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class Test {
    private final ScoreDataRepository repository;
    private ZeebeClient zeebeClient;
    private final WebClient webClient;



}
