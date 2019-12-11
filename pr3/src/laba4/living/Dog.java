package laba4.living;

import laba4.exception.NoLegsException;

public class Dog extends Mammal {

    public enum Color{RED, BLUE, BLACK, WHITE, YELLOW, GRAY, PINK};
    public enum Size {SMALL, MEDIUM, BIG};
    private Size mySize;
    private Color myColor;

    public Dog(Gender gender, String name, Size size, Color color, int age)  {
        super(gender, name, age);
        this.mySize = size;
        this.myColor = color;
    }

    public Dog(Gender gender, String name, int x, int y, Size size, Color color) {
        super(gender, name, x, y);
        this.mySize = size;
        this.myColor = color;
    }

//собака запоминает людей  после того как понюхает
    public final void sniff(Mammal human) {
        this.adFriend(human);
        System.out.println("ГАВ-ГАВ-ГАВ");
    }

    public void hugLeg(Mammal m) throws NoLegsException {
            if (m.getLeftLeg() == null && m.getRightLeg() == null) {
                throw new NoLegsException("Нельзя прижаться к ногам, которых нет((");
            }

            System.out.println(this.getName() + " прижался к ноге " + m.getName());
            this.setMyMood(Mood.HAPPY);
            if (m.chekFriend(this)){
            m.setMyMood(Mood.HAPPY);
            }
            else {
                m.setMyMood(Mood.ANGRY);
            }
    }

    @Override
    public String toString() {
        return "Dog[кличка=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

    public Size getMySize() {
        return mySize;
    }

    public Color getMyColor() {
        return myColor;
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
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Dog dog = (Dog) o;
        return this.getCoordinateX() == dog.getCoordinateX() &&
                this.getCoordinateY() == dog.getCoordinateY() &&
                this.getName().equals(dog.getName()) &&
                this.mySize == dog.getMySize() &&
                this.myColor == dog.getMyColor();
    }

}
