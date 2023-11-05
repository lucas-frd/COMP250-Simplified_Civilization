package assignment1;
public class Settler extends assignment1.Unit {
    public Settler(assignment1.Tile position, double hp, String faction) {
        super(position, hp, 2, faction);
    }

    public void takeAction(assignment1.Tile position) {
        if ((position == this.getPosition()) && (position.isCity() == false)) {
            position.buildCity();
            position.removeUnit(this);
            return;
        }
        return;
    }

    public boolean equals(Object input) {
        if (!(input instanceof Settler)) {
            return false;
        }
        if (!super.equals(input)) {
            return false;
        }
        return true;

    }

}
