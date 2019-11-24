package living;

import exception.NegativeAgeException;
import item.Building;
import item.Item;
import item.MoveItem;
import item.Place;

import java.util.Arrays;

public abstract class Mammal implements LivingMove, MoveItem {

    private Mammal Friend[] = new Mammal[10000];
    public enum Gender {MALE, FEMAALE};
    public enum Mood {HAPPY, ANGRY, TIRED, NORMAL};

    private Mood myMood = Mood.NORMAL;
    private Mammal.Leg leftLeg;
    private Mammal.Leg rightLeg;
    private Gender MyGender;
    private String Name;
    private int CoordinateX;
    private int CoordinateY;
    private int age;
    private MoveItem myHome;


    public Mammal(Gender gender, String name, int age)  {
        this.MyGender = gender;
        this.Name = name;
        this.CoordinateX = 0;
        this.CoordinateY = 0;
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
        this.MyGender = gender;
        this.Name = name;
        this.CoordinateX = x;
        this.CoordinateY = y;
        this.leftLeg = this.new Leg();
        this.rightLeg = this.new Leg();
    }


    public class Leg {
        public Leg() {

        }
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
            if (Friend[i] == m) {
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


    //human делает шаг в сторону объекта с координатами x,y
    public final void Take2Step(MoveItem place){
        if (this.CoordinateX > place.getCoordinateX()) {
            this.setCoordinateX(this.CoordinateX - 1);
        }
        else if (this.CoordinateX < place.getCoordinateX() ) {
            this.setCoordinateX(this.CoordinateX + 1);
        }

        if (this.CoordinateY > place.getCoordinateY()) {
            this.setCoordinateY(this.CoordinateY - 1);
        }
        else if (this.CoordinateY < place.getCoordinateY() ) {
            this.setCoordinateY(this.CoordinateY + 1);
        }
    }

//human идёт к place
    public final void Go (MoveItem place)  {
        while  (this.CoordinateX != place.getCoordinateX() || this.CoordinateY != place.getCoordinateY()){
            this.Take2Step(place);
        }
        System.out.println(this.getName() + " подошел к " + place.getName());
    }

//все люди идут к place в т.ч. человек от которого вызван метод
    public final void ComeHereToPlace(MoveItem place, Mammal... human) throws InterruptedException {
        this.Go(place);
        Thread.sleep(1000);
        for(Mammal h: human){
            h.Go(place);
            Thread.sleep(1000);
        }
    }

//все люди идут к place(человек) от которого вызывается метод
    public final void ComeHere(Mammal... human) throws InterruptedException {
        for(Mammal h: human){
            h.Go(this);
            Thread.sleep(1000);
        }
    }

//все human вместе идут к place (изначально должны иметь одинаковые координаты) рекомендутся сначала вызвать метод ComeHere, так как идут вместе - становятся счастливыми
    public final void GoTogether(MoveItem place, Mammal... human) {
        while  (this.CoordinateX != place.getCoordinateX() || this.CoordinateY != place.getCoordinateY()) {
            this.Take2Step(place);
            this.setMyMood(Mood.HAPPY);
            for (Mammal h : human) {
                h.Take2Step(place);
                h.setMyMood(Mood.HAPPY);
            }
        }
        System.out.println("группа подошла к " + place.getName());
    }

    public final int getCoordinateX() {
        return this.CoordinateX;
    }

    public final void setCoordinateX(int coordinateX) {
        this.CoordinateX = coordinateX;
    }

    public final int getCoordinateY() {
        return this.CoordinateY;
    }

    public final void setCoordinateY(int coordinateY) {
        this.CoordinateY = coordinateY;
    }

    public String getName() {
        return this.Name;
    }

    public Leg getLeftLeg() {
        return this.leftLeg;
    }

    public Leg getRightLeg() {
        return this.rightLeg;
    }

    public Mood getMyMood() {
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
}
