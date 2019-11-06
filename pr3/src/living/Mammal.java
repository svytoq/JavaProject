package living;

import item.Building;
import item.Item;
import item.Place;

public abstract class Mammal implements LivingMove{

    public enum Gender {MALE, FEMAALE};

    private Gender MyGender;
    private String Name;
    private int CoordinateX;
    private int CoordinateY;
    private static int Indeficator = 0;

    public Mammal(Gender gender, String name){
        this.MyGender = gender;
        this.Name = name;
        this.CoordinateX = 0;
        this.CoordinateY = 0;
    }

    public Mammal(Gender gender, String name, int x, int y){
        this.MyGender = gender;
        this.Name = name;
        this.CoordinateX = x;
        this.CoordinateY = y;
    }

//human делает шаг в сторону объекта с координатами x,y
    public final void Take2Step(Item place){
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

//human делает шаг в сторону place(человека) с координатами x,y
    public final void Take2Step(Mammal place){
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
    public final void Go (Place place)  {
        while  (this.CoordinateX != place.getCoordinateX() || this.CoordinateY != place.getCoordinateY()){
            this.Take2Step(place);
        }
        System.out.println(this.getName() + " прошел через " + place.getName());
    }

//human идёт к building
    public final void Go (Building place)  {
        while  (this.CoordinateX != place.getCoordinateX() || this.CoordinateY != place.getCoordinateY()){
            this.Take2Step(place);
        }
        System.out.println(this.getName() + " подошел к " + place.getName());
    }

//human идёт к place(человек)
    public final void Go (Mammal place)  {
        while  (this.CoordinateX != place.getCoordinateX() || this.CoordinateY != place.getCoordinateY()){
            this.Take2Step(place);
        }
        System.out.println(this.getName() + " подошел к " + place.getName());
    }

//все люди идут к place в т.ч. человек от которого вызван метод
    public final void ComeHereToPlace(Place place, Mammal... human) throws InterruptedException {
        this.Go(place);
        Thread.sleep(1000);
        for(Mammal h: human){
            h.Go(place);
            Thread.sleep(1000);
        }
    }


//все люди идут к building в т.ч. человек от которого вызван метод
    public final void ComeHereToPlace(Building place, Mammal... human) throws InterruptedException {
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

//все human вместе идут к place (изначально должны иметь одинаковые координаты) рекомендутся сначала вызвать метод ComeHere
    public final void GoTogether(Place place, Mammal... human) {
        while  (this.CoordinateX != place.getCoordinateX() || this.CoordinateY != place.getCoordinateY()) {
            this.Take2Step(place);
            for (Mammal h : human) {
                h.Take2Step(place);
            }
        }
        System.out.println("группа прошла через " + place.getName());
    }

//все human вместе идут к place (изначально должны иметь одинаковые координаты) рекомендутся сначала вызвать метод ComeHere
    public final void GoTogether(Building place, Mammal... human) {
        while  (this.CoordinateX != place.getCoordinateX() || this.CoordinateY != place.getCoordinateY()) {
            this.Take2Step(place);
            for (Mammal h : human) {
                h.Take2Step(place);
            }
        }
        System.out.println("группа подошла к " + place.getName());
    }

//все human вместе идут к place(человек) (изначально должны иметь одинаковые координаты) рекомендутся сначала вызвать метод ComeHere
   public final void GoTogether(Mammal place, Mammal... human) {
        while  (this.CoordinateX != place.getCoordinateX() || this.CoordinateY != place.getCoordinateY()) {
             this.Take2Step(place);
             for (Mammal h : human) {
                  h.Take2Step(place);
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

    public static int getIndeficator() {
        return Indeficator;
    }

    public static void setIndeficator(int indeficatjr) {
        Indeficator = indeficatjr;
    }

}
