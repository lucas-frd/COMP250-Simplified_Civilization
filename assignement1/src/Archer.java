package assignment1;
public class Archer extends assignment1.MilitaryUnit {
    private int num_arrows;

    public Archer(assignment1.Tile position, double hp, String faction) {
        super(position, hp, 2, faction, 15.0, 2, 0);
        this.num_arrows = 5;
    }

    public void takeAction(assignment1.Tile position) {
        if (num_arrows == 0) {
            num_arrows = 5;
            return;
        } else {
            num_arrows -= 1;
            super.takeAction(position);
            return;
        }
    }

    public boolean equals(Object input) {
        if (!(input instanceof assignment1.Archer)) {
            return false;
        }
        if (!super.equals(input)) {
            return false;
        }
        if (this.num_arrows != ((Archer) input).num_arrows) {
            return false;
        }
        return true;
    }
}
