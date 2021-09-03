import com.java.learn.java11.game.cli.Game;
import com.java.learn.java11.textgame.TextDisplay;

module game.cli {
    requires text.game;
    provides TextDisplay with Game.ConsoleDisplay;
}
