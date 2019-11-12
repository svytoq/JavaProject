package living;


public class People extends Mammal {

    private final String Smel = "Sweets";

    private Mammal Friend[] = new Mammal[10000];

    public People(Gender gender, String name) {
        super(gender, name);

    }

    public People(Gender gender, String name, int x, int y) {
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

    public final boolean ChekFriend(Mammal m) {
        int t = 0;
        for (int i = 0; i < Friend.length; i++) {
            if (Friend[i].equals(m)) {
                t++;
                break;
            }
            if (Friend[i] == null) {
                break;
            }
        }
        if (t > 0){
            return true;
        }
        else {
            return false;
        }
    }




    @Override
    public String toString(){
        return "People[име=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

    @Override
    public boolean equals (Object o){
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        People people = (People) o;
        return this.getCoordinateX() == people.getCoordinateX() &&
                this.getCoordinateY() == people.getCoordinateY() &&
                this.getName().equals(people.getName());
    }

    @Override
    public int hashCode(){
        int result = 7;
        result = this.getName().hashCode() * 13 + result;
        return result;
    }
}
