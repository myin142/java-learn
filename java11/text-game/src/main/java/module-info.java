import com.java.learn.java11.engine.GameManager;
import com.java.learn.java11.textgame.TextDisplay;
import com.java.learn.java11.textgame.TextGameManager;

module text.game {
    exports com.java.learn.java11.textgame;
    requires transitive game.engine;
    provides GameManager with TextGameManager;
    uses TextDisplay;
}
