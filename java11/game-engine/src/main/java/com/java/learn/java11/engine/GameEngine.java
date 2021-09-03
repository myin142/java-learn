package com.java.learn.java11.engine;

import java.util.ServiceLoader;

public class GameEngine {
    private static final int DELAY = 1000;

    private final GameManager gameManager;

    public GameEngine() {
        this(ServiceLoader.load(GameManager.class)
                .findFirst()
                .orElseThrow(NoGameManagerException::new));
    }

    public GameEngine(final GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public void startGame() {
        boolean started = true;
        gameManager.start();

        while(started) {
            gameManager.process();

            if (gameManager.isGameFinished()) {
                started = false;
            }

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.interrupted());
            }
        }

        gameManager.exit();
    }

}
