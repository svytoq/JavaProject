package laba4.living;

import laba4.exception.NegativeAgeException;
import laba4.item.MoveItem;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public abstract class Mammal implements Moving, MoveItem {

    private Mammal friend[] = new Mammal[10000];
    public enum Gender {MALE, FEMAALE};
    public enum Mood {HAPPY, ANGRY, TIRED, NORMAL, FURIOS};

    private Mood myMood = Mood.NORMAL;
    private Mammal.Leg leftLeg;
    private Mammal.Leg rightLeg;
    private Gender myGender;
    private String name;
    private int coordinateX;
    private int coordinateY;
    private int age;
    private MoveItem myHome;


    public Mammal(Gender gender, String name, int age)  {
        this.myGender = gender;
        this.name = name;
        this.coordinateX = 0;
        this.coordinateY = 0;
        this.leftLeg = this.new Leg();
        this.rightLeg = this.new Leg();
        if (age > -1){
            this.age = age;
        }
        else {
            throw new NegativeAgeException("возраст не может быть меньше 0");
        }
    }


    public Mammal(Gender gender, String name, int x, int y){
        this.myGender = gender;
        this.name = name;
        this.coordinateX = x;
        this.coordinateY = y;
        this.leftLeg = this.new Leg();
        this.rightLeg = this.new Leg();
    }


    public class Leg {
        public Leg() {

        }
    }

    public final void adFriend(Mammal... m) {
        for (Mammal human : m) {
            for (int i = 0; i < friend.length; i++) {
                if (friend[i] == null) {
                    friend[i] = human;
                    break;
                }
            }
        }
    }

    public final boolean chekFriend(Mammal m) {
        int t = 0;
        for (int i = 0; i < friend.length; i++) {
            if (friend[i] == m) {
                t++;
                break;
            }
            if (friend[i] == null) {
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


    //human делает шаг в сторону объекта с координатами x,y
    public final void take2Step(MoveItem place){
        if (this.coordinateX > place.getCoordinateX()) {
            this.setCoordinateX(this.coordinateX - 1);
        }
        else if (this.coordinateX < place.getCoordinateX() ) {
            this.setCoordinateX(this.coordinateX + 1);
        }

        if (this.coordinateY > place.getCoordinateY()) {
            this.setCoordinateY(this.coordinateY - 1);
        }
        else if (this.coordinateY < place.getCoordinateY() ) {
            this.setCoordinateY(this.coordinateY + 1);
        }
    }

//human идёт к place
    public final void go (MoveItem place)  {
        while  (this.coordinateX != place.getCoordinateX() || this.coordinateY != place.getCoordinateY()){
            this.take2Step(place);
        }
        System.out.println(this.getName() + " подошел к " + place.getName());
    }

//все люди идут к place в т.ч. человек от которого вызван метод
    public final void comeHereToPlace(MoveItem place, Mammal... human) throws InterruptedException {
        this.go(place);
        Thread.sleep(1000);
        for(Mammal h: human){
            h.go(place);
            Thread.sleep(1000);
        }
    }

//все люди идут к place(человек) от которого вызывается метод
    public final void comeHere(Mammal... human) throws InterruptedException {
        for(Mammal h: human){
            h.go(this);
            Thread.sleep(1000);
        }
    }

//все human вместе идут к place (изначально должны иметь одинаковые координаты) рекомендутся сначала вызвать метод ComeHere
    public void goTogether(MoveItem place, Mammal... human) {
        while  (this.coordinateX != place.getCoordinateX() || this.coordinateY != place.getCoordinateY()) {
            this.take2Step(place);
            for (Mammal h : human) {
                h.take2Step(place);
            }
        }
        System.out.println("группа подошла к " + place.getName());
    }

    public final int getCoordinateX() {
        return this.coordinateX;
    }

    public final void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public final int getCoordinateY() {
        return this.coordinateY;
    }

    public final void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public String getName() {
        return this.name;
    }

    public Leg getLeftLeg() {
        return this.leftLeg;
    }

    public Leg getRightLeg() {
        return this.rightLeg;
    }

    public Mood getMyMood(Mood happy) {
        return this.myMood;
    }

    public void setMyMood(Mood myMood) {
        this.myMood = myMood;
    }

    public int getAge() {
        return this.age;
    }

    public MoveItem getMyHome() {
        return myHome;
    }

    public void setMyHome(MoveItem myHome) {
        this.myHome = myHome;
    }

    public static void doitOr42(Object obj) throws IllegalAccessException {
        Class objClass = obj.getClass();
        Field[] declaredFields = objClass.getDeclaredFields();
        for(Field field : declaredFields) {
            MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
            if(annotation != null) {

                if(annotation.value() != null) {
                    field.setAccessible(true);
                    if (field.getType().getName().equals("int")) {
                        field.set(obj, Integer.parseInt(annotation.value()));
                    }
                    else if(field.getType().getName().equals("double")){
                        field.set(obj, Double.parseDouble(annotation.value()));
                    }
                    //else if......
                    else {
                        field.set(obj, annotation.value());
                    }
                }
                else if (field.getType().getName().equals("double")){
                    field.setAccessible(true);
                    field.set(obj, 42);
                }

            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MyAnnotation {
     String value();
}


