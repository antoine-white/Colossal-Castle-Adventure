package game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({game.CommandIT.class,
    game.GameIT.class,
    game.InterpreterIT.class})
public class GameTestSuite {

}

