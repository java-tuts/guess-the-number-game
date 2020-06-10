package com.vighnesh153.config;

import com.vighnesh153.GuessCount;
import com.vighnesh153.MaxNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    private int maxNumber = 50;
    private int guessCount = 8;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
