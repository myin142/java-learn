package com.java.learn.java11.engine;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class GameEngineTest {

    @InjectMocks
    private GameEngine gameEngine;

    @Mock
    private GameManager gameManager;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() {
        gameEngine.startGame();

        verify(gameManager).start();
        verify(gameManager).process();

        when(gameManager.isGameFinished()).thenReturn(true);
    }

}
