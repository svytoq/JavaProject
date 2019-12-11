package laba4.living;

public class Human extends Mammal {

    @MyAnnotation("pressf")
    private String smel = "Sweets";
    @MyAnnotation("3")
    private double t = 5;

    public Human(Gender gender, String name, int age) {
        super(gender, name, age);

    }

    public Human(Gender gender, String name, int x, int y) {
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
            this.sigh();
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
        Human people = (Human) o;
        return this.getCoordinateX() == people.getCoordinateX() &&
                this.getCoordinateY() == people.getCoordinateY() &&
                this.getName().equals(people.getName());
    }

    public String getSmel() {
        return smel;
    }

    public double getT() {
        return t;
    }
}

