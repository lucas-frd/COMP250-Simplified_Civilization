package assignment1;
public class Warrior extends assignment1.MilitaryUnit {
    public Warrior(assignment1.Tile position, double hp, String faction) {
        super(position, hp, 1, faction, 20.0, 1, 25);
    }

    public boolean equals(Object input) {
        if (!(input instanceof assignment1.Warrior)) {
            return false;
        }
        if (!super.equals(input)) {
            return false;
        }
        return true;
    }
}
