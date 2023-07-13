package com.example.scoredata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/score-data")
public class ScoreDataController {

    @GetMapping
    public void StartProcess(){

    }
}
