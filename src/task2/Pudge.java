package task2;

import java.io.Serializable;

public class Pudge extends Hero implements Serializable {
    String ultimate;

    public Pudge(int intelligence, int agility, int strength, String ultimate) {
        super(intelligence, agility, strength);
        this.ultimate = ultimate;
    }

    @Override
    public String toString() {
        return "Pudge{" + "ultimate='" + ultimate + '\'' + ", intelligence=" + intelligence + ", agility=" + agility + ", strength=" + strength + '}';
    }
}
