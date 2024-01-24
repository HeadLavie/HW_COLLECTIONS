package ru.netology;

import java.util.ArrayList;

public class Game {


    ArrayList<Player> players = new ArrayList<>();

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void register (Player player) {
        players.add(player);
    }

    public int round (Player playerName1, Player playerName2) {

        if (findById(playerName1.getId()) == null) {
            throw new NotRegisteredException(
                    "Element with id: " + playerName1.getId() + " not found"
            );
        } else if (findById(playerName2.getId()) == null) {
            throw new NotRegisteredException(
                    "Element with id: " + playerName2.getId() + " not found"
            );
        }

        if (playerName1.getStrength() > playerName2.getStrength())
            return 1;
        else if (playerName2.getStrength() > playerName1.getStrength())
            return 2;
        else
        return 0;
    }

    public Player findById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }
}
