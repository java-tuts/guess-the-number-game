package com.vighnesh153;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
    private static final String MAIN_MESSAGE = "game.main.message";

    private final Game game;
    private final MessageSource messageSource;

    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void init() {
        log.info("game = {}", game);
    }

    @Override
    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
//        return "Number is between " +
//                game.getSmallest() +
//                " and " +
//                game.getBiggest() +
//                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "You guessed it. The number was " + game.getNumber();
        }
        if (game.isGameLost()) {
            return "You lost. The number was " + game.getNumber();
        }
        if (!game.isValidNumberRange()) {
            return "Invalid number range!";
        }
        if (game.getRemainingGuesses() == game.getGuessCount()) {
            return "What is your first guess?";
        }
        String direction = "Lower";
        if (game.getGuess() < game.getNumber()) {
            direction = "Higher";
        }
        return direction + "! You have " + game.getRemainingGuesses() + " guesses left.";
    }

    private String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
