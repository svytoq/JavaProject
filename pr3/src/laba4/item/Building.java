package laba4.item;

public class Building extends Item {

    public Building(String name, int x, int y) {
        super(name, x, y);
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = this.getName().hashCode() * 7 + result;
        return result;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Building building = (Building) o;
        return this.getCoordinateX() == building.getCoordinateX() &&
                this.getCoordinateY() == building.getCoordinateY() &&
                this.getName().equals(building.getName());
        }
    }
