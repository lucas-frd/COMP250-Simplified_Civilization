package assignment1;
public class Worker extends assignment1.Unit {
    private int num_jobs;
    public Worker(assignment1.Tile position, double hp, String faction) {
        super(position, hp, 2, faction);
        this.num_jobs = 0;
    }

    public void takeAction(assignment1.Tile position) {
        if (position == this.getPosition() && position.isImproved() == false) {
            position.buildImprovement();
            this.num_jobs += 1;
            if (num_jobs >= 10) {
                position.removeUnit(this);
            }
            return;
        }
        return;
    }

    public boolean equals(Object input) {
        if (!(input instanceof Worker)) {
            return false;
        }
        if (!super.equals(input)) {
            return false;
        }
        if (this.num_jobs != ((Worker) input).num_jobs) {
            return false;
        }
        return true;
    }
}
