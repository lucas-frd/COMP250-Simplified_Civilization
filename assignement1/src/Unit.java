package assignment1;
public abstract class Unit {
    private assignment1.Tile position;
    private double hp;
    private int moving_range;
    private String faction;

    public Unit(assignment1.Tile position, double hp, int moving_range, String faction) {
        this.position = position;
        this.hp = hp;
        this.moving_range = moving_range;
        this.faction = faction;
        if (position.addUnit(this) == false) {
            throw new IllegalArgumentException();
        }
    }

    public final assignment1.Tile getPosition() {
        return position;
    }

    public final double getHP() {
        return hp;
    }

    public final String getFaction() {
        return faction;
    }

    public boolean moveTo(assignment1.Tile deployment) {
        if (deployment == null || assignment1.Tile.getDistance(this.position, deployment) > this.moving_range || deployment.addUnit(this) == false)
            return false;
        this.position.removeUnit(this);
        deployment.addUnit(this);
        this.position = deployment;
        return true;
    }

    public void receiveDamage(double damage) {
        if (damage < 0)
            return;
        if (damage >= 0)
            if (this.position.isCity())
                damage = damage * 0.9;
        hp -= damage;
        if (hp <= 0)
            this.position.removeUnit(this);
    }

    public abstract void takeAction(assignment1.Tile position);

    public boolean equals(Object input) {
        if (! (input instanceof Unit)) {
            return false;
        }
        Unit otherUnit = (Unit) input;
        if (! (otherUnit.position.equals(this.position))) {
            return false;
        }
        if (Math.pow(otherUnit.hp - this.hp, 2) >= 0.001) {
            return false;
        }
        if (! (otherUnit.faction.equals(this.faction))) {
            return false;
        }
        return true;
    }
}