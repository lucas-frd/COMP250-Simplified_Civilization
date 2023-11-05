package assignment1;
public class ListOfUnits {
    private assignment1.Unit[] units;
    private int size;

    public ListOfUnits() {
        units = new assignment1.Unit[0];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public assignment1.Unit[] getList() {
        return units;
    }

    public assignment1.Unit getUnit(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return units[i];
        }
    }

    public void addUnit(assignment1.Unit unit) {
        if (unit == null) {
            return;
        }
        if (size >= units.length) {
            resize();
        }
        units[size] = unit;
        size += 1;
    }

    private void resize() {
        assignment1.Unit[] bigger = new assignment1.Unit[units.length + 1];
        for (int i = 0; i < size; i++) {
            bigger[i] = units[i];
        }
        units = bigger;
    }

    public int indexOf(assignment1.Unit unit) {
        for (int i = 0; i < size; i++){
            if (units[i].equals(unit))
                return i;
        }
        return -1;
    }

    public boolean removeUnit(assignment1.Unit unit) {
        if (units.length == 0) {
            return false;
        }
        assignment1.Unit[] smaller = new assignment1.Unit[units.length - 1];
        int index = indexOf(unit);

        if (index == -1) {
            return false;
        } else {
            for (int i = 0; i < index; i++) {
                smaller[i] = units[i];
            }
            for (int i = index; i < size - 1; i++) {
                smaller[i] = units[i + 1];
            }
            units = smaller;
            size -= 1;
            return true;
        }
    }

    public assignment1.MilitaryUnit[] getArmy() {
        ListOfUnits militaryUnits = new ListOfUnits();
        for (int i = 0; i < size; i++) {
            if (units[i] instanceof assignment1.MilitaryUnit)
                militaryUnits.addUnit(units[i]);
        }
        assignment1.MilitaryUnit[] militaryUnitArray = new assignment1.MilitaryUnit[militaryUnits.getSize()];
        for (int i = 0; i < militaryUnits.getSize(); i++) {
            militaryUnitArray[i] = (assignment1.MilitaryUnit) militaryUnits.getUnit(i);
        }
        return militaryUnitArray;
    }
}
