package living;

public class People extends Mammal {

    private final String Smel = "Sweets";

    public People(Gender gender, String name, int age) {
        super(gender, name, age);

    }

    public People(Gender gender, String name, int x, int y) {
        super(gender, name, x, y);

    }

    public void sigh(){
        class sigh{
            {
                System.out.println("ах ох ах");
            }
        }
        new sigh();
    }


    @Override
    public String toString(){
        return "People[име=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

    public void talkAboutDog(){
        System.out.println("ох собака, моя собака, как я хочу собаку");
    }

    @Override
    public int hashCode(){
        int result = 7;
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
        People people = (People) o;
        return this.getCoordinateX() == people.getCoordinateX() &&
                this.getCoordinateY() == people.getCoordinateY() &&
                this.getName().equals(people.getName());
    }
}