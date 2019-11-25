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
        System.out.println("ах ох ах");
    }


    @Override
    public String toString(){
        return "People[име=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

//взрослые не любят говроить о всяких глупостях
    public void talkAbout(Mammal m, Object mammal, String s){
        if (m.getAge() > 17 &&  mammal.getClass() == Dog.class){
            m.setMyMood(Mood.ANGRY);
        }
        else if (m.getAge() > 17 && mammal.getClass() == Carlson.class){
            m.setMyMood(Mood.FURIOS);
        }
        System.out.println(s);
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