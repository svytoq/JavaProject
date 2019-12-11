package laba4.item;

public class Place extends Item {
    public Place(String name, int x, int y) {
        super(name, x, y);
    }


    @Override
    public int hashCode(){
        int result = 7;
        result = this.getName().hashCode() * 11 + result;
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
        Place place = (Place) o;
        return this.getCoordinateX() == place.getCoordinateX() &&
                this.getCoordinateY() == place.getCoordinateY() &&
                this.getName().equals(place.getName());
    }
}
