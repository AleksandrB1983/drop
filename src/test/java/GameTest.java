import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testWhenSecondPlayerWin() {
        Player sergey = new Player(1, "Сергей", 100);
        Player misha = new Player(2, "Миша", 120);

        Game game = new Game();

        game.register(sergey);
        game.register(misha);

        int expected = 2;
        int actual = game.round("Сергей", "Миша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerWin() {
        Player roma = new Player(1, "Рома", 140);
        Player misha = new Player(2, "Миша", 120);

        Game game = new Game();

        game.register(roma);
        game.register(misha);

        int expected = 1;
        int actual = game.round("Рома", "Миша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenThereNoWinnerBetweenTwoPlayers() {
        Player alexandr = new Player(1, "Александр", 120);
        Player misha = new Player(2, "Миша", 120);

        Game game = new Game();

        game.register(alexandr);
        game.register(misha);

        int expected = 0;
        int actual = game.round("Александр", "Миша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player sergey = new Player(1, "Сергей", 100);
        Player misha = new Player(2, "Миша", 120);

        Game game = new Game();

        game.register(sergey);
        game.register(misha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Гриша", "Сергей")
        );
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player sergey = new Player(1, "Сергей", 100);
        Player misha = new Player(2, "Миша", 120);

        Game game = new Game();

        game.register(sergey);
        game.register(misha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Миша", "Евгений")
        );
    }

}