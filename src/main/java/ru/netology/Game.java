package ru.netology;

import java.util.HashMap;

public class Game {

    HashMap<Integer, Integer> players = new HashMap<>();


    public void register (Player player) {
        players.put(player.id, player.strength);
    }

    public int round (Player playerName1, Player playerName2) {

        if (playerName1.id == null) {
            throw new NotRegisteredException(
                    "Element with id: " + playerName1.getId() + " not found"
            );
        } else if (playerName2.id == null) {
            throw new NotRegisteredException(
                    "Element with id: " + playerName2.getId() + " not found"
            );
        }

        if (playerName1.getStrength() > playerName2.getStrength()) {
            return 1;
        } else if (playerName2.getStrength() > playerName1.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}
