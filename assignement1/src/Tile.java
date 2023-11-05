package assignment1;
public class Tile {
    private int x;
    private int y;
    private boolean city_built;
    private boolean improvements;
    private assignment1.ListOfUnits units;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.city_built = false;
        this.improvements = false;
        this.units = new assignment1.ListOfUnits();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCity() {
        return city_built;
    }

    public boolean isImproved() {
        return improvements;
    }

    public void buildCity() {
        city_built = true;
    }

    public void buildImprovement() {
        improvements = true;
    }

    public boolean addUnit(assignment1.Unit unit) {
        if (unit instanceof assignment1.MilitaryUnit) {
            for (int i = 0; i < units.getSize(); i++) {
                if (!unit.getFaction().equals(units.getList()[i].getFaction()) && units.getList()[i] instanceof assignment1.MilitaryUnit)
                    return false;
            }
        }
        if (units.indexOf(unit) != -1) {
            return true;
        }
        units.addUnit(unit);

        return true;
    }

    public boolean removeUnit(assignment1.Unit unit) {
        return units.removeUnit(unit);
    }

    public assignment1.Unit selectWeakEnemy(String faction) {
        double lowest_hp = Integer.MAX_VALUE;
        assignment1.Unit lowest_unit = null;
        for (int i = 0; i < units.getSize(); i++) {
            assignment1.Unit curr_unit = units.getUnit(i);
            if (curr_unit.getHP() < lowest_hp && curr_unit.getFaction() != faction) {
                lowest_unit = curr_unit;
                lowest_hp = curr_unit.getHP();
            }
        }
        return lowest_unit;
    }

    public static double getDistance(Tile position1, Tile position2) {
        int x1 = position1.getX();
        int y1 = position1.getY();
        int x2 = position2.getX();
        int y2 = position2.getY();
        double distance = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        return distance;
    }
}
