package living;

public class Carlson extends Mammal {

    private Mammal Friend[] = new Mammal[10000];
    private final String Smel = "jam";
    private final int hash = 0;

    public Carlson(Gender gender, String name) {
        super(gender, name);
    }

    public Carlson(Gender gender, String name, int x, int y) {
        super(gender, name, x, y);
    }

    public final void AdFriend(Mammal... m) {
        for (Mammal human : m) {
            for (int i = 0; i < Friend.length; i++) {
                if (Friend[i] == null) {
                    Friend[i] = human;
                    break;
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Carlson[единственный и неповтороримый, име=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Carlson carlson= (Carlson) o;
        return this.getCoordinateX() == carlson.getCoordinateX() &&
                this.getCoordinateY() == carlson.getCoordinateY() &&
                this.getName().equals(carlson.getName());
    }

    @Override
    public int hashCode() {
        int result = 7;
        result = this.getName().hashCode() * 13 + result;
        return result;
    }
}
