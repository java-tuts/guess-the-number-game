package com.vighnesh153.console;

import com.vighnesh153.config.AppConfig;
import com.vighnesh153.MessageGenerator;
import com.vighnesh153.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Guess The Number Game");

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
        int number = numberGenerator.next();
        logger.info("number = {}", number);

        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
        logger.info("getMainMessage = {}", messageGenerator.getMainMessage());
        logger.info("getResultMessage = {}", messageGenerator.getResultMessage());

        context.close();
    }
}
