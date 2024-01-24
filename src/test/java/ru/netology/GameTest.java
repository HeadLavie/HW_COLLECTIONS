package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GameTest {

    Player player1 = new Player(1, "Alice", 14);
    Player player2 = new Player(2, "Wallice", 11);
    Player player3 = new Player(3, "Ray", 14);
    Player player4 = new Player(4, "Setter", 50);

    @Test
    public void shouldTestNotRegisteredException() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1, player4);
        });
    }

    @Test
    public void shouldTestNotRegisteredException2() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player4, player2);
        });
    }

    @Test
    public void shouldTestRoundFirstPlayerStronger() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round(player1, player2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestRoundSecondPlayerStronger() {
        Game game = new Game();

        game.register(player1);
        game.register(player4);

        int expected = 2;
        int actual = game.round(player1, player4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestRoundDraw() {
        Game game = new Game();

        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round(player1, player3);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldRegisterPlayers() {
        Game game = new Game();

        game.register(player1);
        game.register(player2);
        game.register(player3);

        HashMap<Integer, Integer> expected = new HashMap<>();
        expected.put(player1.id, player1.strength);
        expected.put(player2.id, player2.strength);
        expected.put(player3.id, player3.strength);

        HashMap<Integer, Integer> actual = game.getPlayers();

        Assertions.assertEquals(expected, actual);
    }
}
