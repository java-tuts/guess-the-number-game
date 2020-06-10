package com.vighnesh153.config;

import com.vighnesh153.GuessCount;
import com.vighnesh153.MaxNumber;
import com.vighnesh153.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // after color is the default value, which will
    // be taken if no matching property is found
    @Value("${game.maxNumber:100}")
    private int maxNumber;

    // after color is the default value, which will
    // be taken if no matching property is found
    @Value("${game.minNumber:0}")
    private int minNumber;

    // after color is the default value, which will
    // be taken if no matching property is found
    @Value("${game.guessCount:10}")
    private int guessCount;

    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
