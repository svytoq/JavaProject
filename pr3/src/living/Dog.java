package living;

public class Dog extends Mammal {

    private Mammal Friend[] = new Mammal[10000];

    public Dog(Gender gender, String name) {
        super(gender, name);
    }

    public Dog(Gender gender, String name, int x, int y) {
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

    //собака запоминает людей  после того как понюхает
    public final void Sniff(Mammal human) {
        this.AdFriend(human);
        System.out.println("ГАВ-ГАВ-ГАВ");
    }

    @Override
    public String toString() {
        return "Dog[кличка=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

    @Override
    public boolean equals (Object o){
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return this.getCoordinateX() == dog.getCoordinateX() &&
                this.getCoordinateY() == dog.getCoordinateY() &&
                this.getName().equals(dog.getName());
    }

    @Override
    public int hashCode(){
        int result = 7;
        result = this.getName().hashCode() * 13 + result;
        return result;
    }
}
