package living;

import exception.NegativeAgeException;
import exception.NoLegsException;

public class Dog extends Mammal {

    public enum Color{RED, BLUE, BLACK, WHITE, YELLOW, GRAY, PINK};
    public enum Size {SMALL, MEDIUM, BIG};
    private Size MySize;
    private Color MyColor;

    public Dog(Gender gender, String name, Size size, Color color, int age)  {
        super(gender, name, age);
        this.MySize = size;
        this.MyColor = color;
    }

    public Dog(Gender gender, String name, int x, int y, Size size, Color color) {
        super(gender, name, x, y);
        this.MySize = size;
        this.MyColor = color;
    }

//собака запоминает людей  после того как понюхает
    public final void Sniff(Mammal human) {
        this.AdFriend(human);
        System.out.println("ГАВ-ГАВ-ГАВ");
    }

    public void HugLeg(Mammal m){
        try {
            if (m.getLeftLeg() == null && m.getRightLeg() == null) {
                throw new NoLegsException("Нельзя прижаться к ногам, которых нет((");
            }
            System.out.println(this.getName() + " прижался к ноге " + m.getName());
        } catch (NoLegsException e) {
            System.out.println("Нельзя прижаться к ногам, которых нет((");
        }
    }

    @Override
    public String toString() {
        return "Dog[кличка=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

    public Size getMySize() {
        return MySize;
    }

    public Color getMyColor() {
        return MyColor;
    }

    @Override
    public int hashCode(){
        int result = 3;
        result = this.getName().hashCode() * 13 + result;
        return result;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) {
            return true;
        }
        if  (this.getClass() != o.getClass())
            return false;
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return this.getCoordinateX() == dog.getCoordinateX() &&
                this.getCoordinateY() == dog.getCoordinateY() &&
                this.getName().equals(dog.getName()) &&
                this.MySize == dog.getMySize() &&
                this.MyColor == dog.getMyColor();
    }

}
