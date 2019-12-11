package laba4.living;

public class Carlson extends Mammal {

    private final String smel = "jam";


    public Carlson(Gender gender, String name, int age)  {
        super(gender, name, age);
    }

    public Carlson(Gender gender, String name, int x, int y) {
        super(gender, name, x, y);
    }

    @Override
    public String toString() {
        return "Carlson[единственный и неповтороримый, име=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

    @Override
    public int hashCode(){
        int result = 5;
        result = this.getName().hashCode() * 13 + result;
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
        Carlson carlson = (Carlson) o;
        return this.getCoordinateX() == carlson.getCoordinateX() &&
                this.getCoordinateY() == carlson.getCoordinateY() &&
                this.getName().equals(carlson.getName());
    }

}
