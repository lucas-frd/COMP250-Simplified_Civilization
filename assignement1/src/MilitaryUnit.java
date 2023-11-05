package assignment1;
public abstract class MilitaryUnit extends assignment1.Unit {
    private double attack_damage;
    private int attack_range;
    private int armor;

    public MilitaryUnit(assignment1.Tile position, double hp, int moving_range, String faction, double attack_damage, int attack_range, int armor) {
        super(position, hp, moving_range, faction);
        this.attack_damage = attack_damage;
        this.attack_range = attack_range;
        this.armor = armor;
    }

    public void takeAction(assignment1.Tile position) {
        assignment1.Unit weakEnemy = position.selectWeakEnemy(this.getFaction());
        if (position.getDistance(position, this.getPosition()) > attack_range) {
            return;
        } else if (this.getPosition().isImproved()) {
            attack_damage = attack_damage * 1.05;
        } else if (weakEnemy == null) {
            return;
        }
        weakEnemy.receiveDamage(attack_damage);
        return;

    }

    public void receiveDamage(double damage) {
        damage = damage * ((double) 100 /(100 + armor));
        super.receiveDamage(damage);
    }
}