package task2;

import java.io.Serializable;

public class Hero implements Serializable {
    int intelligence;
    int agility;
    int strength;

    public Hero(int intelligence, int agility, int strength) {
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
    }
}
