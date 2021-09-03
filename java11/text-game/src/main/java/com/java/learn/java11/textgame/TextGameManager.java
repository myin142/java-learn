package com.java.learn.java11.textgame;

import com.java.learn.java11.engine.GameManager;

import java.util.ServiceLoader;

public class TextGameManager implements GameManager {

    private final TextDisplay textDisplay;

    public TextGameManager() {
        this(ServiceLoader.load(TextDisplay.class)
                .findFirst()
                .orElseThrow(NoTextDisplayException::new));
    }

    public TextGameManager(TextDisplay textDisplay) {
        this.textDisplay = textDisplay;
    }

    @Override
    public void start() {
        textDisplay.show("Game Started");
    }

    @Override
    public void process() {
        textDisplay.show("Game is being processed");
    }

    @Override
    public void exit() {
        textDisplay.show("Game Ended");
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

}
