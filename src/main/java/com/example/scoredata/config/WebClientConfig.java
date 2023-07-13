package com.example.scoredata.config;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebClientConfig {


    public static final int TIMEOUT = 20000;
    @Value("${score-data.url}")
    private String url;


    @Bean
    public WebClient webclientConfiguration() {
        return WebClient.builder()
                .baseUrl(url)
                .clientConnector(new ReactorClientHttpConnector(HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, TIMEOUT)
                        .doOnConnected(connection -> {
                            connection.addHandlerLast(new ReadTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                            connection.addHandlerLast(new WriteTimeoutHandler(TIMEOUT, TimeUnit.MILLISECONDS));
                        }))).build();
    }
}
