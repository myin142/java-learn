package com.java.learn.java11.game.cli;

import com.java.learn.java11.engine.GameEngine;
import com.java.learn.java11.textgame.TextDisplay;

public class Game {
    public static void main(String[] args) {
        final var engine = new GameEngine();
        engine.startGame();
    }

    public static class ConsoleDisplay implements TextDisplay {
        @Override
        public void show(String text) {
            System.out.println(text);
        }
    }
}
