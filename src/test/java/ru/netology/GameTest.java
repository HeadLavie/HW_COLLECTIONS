package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player player1 = new Player(1, "Alice", 14);
    Player player2 = new Player(2, "Wallice", 11);
    Player player3 = new Player(3, "Ray", 10);
    Player player4 = new Player(4, "Setter", 5);

    @Test
    public void testNotRegisteredException() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1, player4);
        });
    }
}
