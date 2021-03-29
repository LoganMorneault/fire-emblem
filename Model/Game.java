package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Model.Characters.IHero;
import Model.Characters.Swordsman;
import Model.Characters.Mage;
import Model.Characters.Rogue;

/**
 * The model representing the game itself.
 */

public class Game {
    List<IHero> blueTeamChars;  // player characters
    List<IHero> redTeamChars;   // enemy characters
    List<IHero> greenTeamChars; // neutral characters

    int maxX;
    int maxY;

    int turnNum;

    String gameState;

    IHero current;

    /**
     * Constructor for Game
     */
    public Game(int maxX, int maxY) {
        this.maxX = Math.max(0, maxX);
        this.maxY = Math.max(0, maxY);
        this.turnNum = 0;
        this.blueTeamChars = new ArrayList<IHero>();
        this.redTeamChars = new ArrayList<IHero>();
        this.greenTeamChars = new ArrayList<IHero>();

        this.current = null;
        
        this.gameState = "blueTurn";
    }

    /**
     * Adds a character to the game.
     * @param name the character's name.
     * @param x the character's x position.
     * @param y the character's y position.
     * @param type the type of character (Swordsman, Mage, Rogue).
     * @param team the team of the character (blue, red, green).
     */
    public void addCharacter(String name, int x, int y, String type, String team) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        Objects.requireNonNull(team);

        if (x < 0 || x > this.maxX || y < 0 || y > this.maxY)  {
            throw new IllegalArgumentException(String.format("Coordinate (%s, %s) is out of bounds", x, y));
        }

        IHero hero;

        for (IHero h : this.blueTeamChars) {
            if (h.getStat("X") == x && h.getStat("Y") == y) {
                throw new IllegalArgumentException(String.format("Space (%s, %s) is already occupied by %s.", x, y, h.getName()));

            }
        }

        for (IHero h : this.redTeamChars) {
            if (h.getStat("X") == x && h.getStat("Y") == y) {
                throw new IllegalArgumentException(String.format("Space (%s, %s) is already occupied by %s.", x, y, h.getName()));
            }
        }

        for (IHero h : this.greenTeamChars) {
            if (h.getStat("X") == x && h.getStat("Y") == y) {
                throw new IllegalArgumentException(String.format("Space (%s, %s) is already occupied by %s.", x, y, h.getName()));
            }
        }


        switch (type) {
            case "Swordsman":
                hero = new Swordsman(name, x, y);
                break;
            case "Mage":
                hero = new Mage(name, x, y);
                break;
            case "Rogue":
                hero = new Rogue(name, x, y);
                break;
            default:
                throw new IllegalArgumentException("Requested character type is not allowed");
        }

        switch (team) {
            case "red":
                this.redTeamChars.add(hero);
                break;
            case "blue":
                this.blueTeamChars.add(hero);
                break;
            case "green":
                this.greenTeamChars.add(hero);
                break;
            default:    
                throw new IllegalArgumentException("Requested team is not allowed");
        }
    }
}
