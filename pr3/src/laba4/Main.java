package laba4;

import laba4.exception.NoLegsException;
import laba4.item.Building;
import laba4.item.MoveItem;
import laba4.item.Place;
import laba4.living.Carlson;
import laba4.living.Dog;
import laba4.living.Mammal;
import laba4.living.Human;



public class Main {

    public static void main(String[] args) throws InterruptedException, IllegalAccessException {

        Building homeForMalish = new Building("Дом для малыша",10,15);
        Place perecrestok = new Place("Перекрёсток",5, 7);
        Building skila = new Building("Школа",12,22);
        Building roadway = new Building("Мостовая",10,15);
        Carlson carlson = new Carlson(Mammal.Gender.MALE,"Карлсон", -100, -100);

        class CompanyForMalish extends Human{
            public CompanyForMalish(Mammal.Gender gender, String name, int x, int y) {
                super(gender, name, x, y);

            }
            //друзья получают удовольствие от совместной прогулки
            public void goTogether(MoveItem place, Mammal... human) {
                while  (this.getCoordinateX() != place.getCoordinateX() || this.getCoordinateY() != place.getCoordinateY()) {
                    this.take2Step(place);
                    this.getMyMood(Mammal.Mood.HAPPY);
                    for (Mammal h : human) {
                        h.take2Step(place);
                        h.getMyMood(Mood.HAPPY);
                    }
                }
                System.out.println("группа подошла к " + place.getName());
            }

        }
        Human malish = new Human(Mammal.Gender.MALE,"Малыш", 8,9);

        MoveItem krisha = new MoveItem() {
            @Override
            public int getCoordinateX() {
                return 10;
            }

            @Override
            public int getCoordinateY() {
                return 15;
            }

            @Override
            public String getName() {
                return "Крыша на которой живёт карлсон";
            }
        };

        Mammal.doitOr42(malish);
        System.out.println(malish.getT());

        carlson.setMyHome(krisha);

        Dog darkPudel = new Dog(Mammal.Gender.FEMAALE, "Черный пудель", 4, 3, Dog.Size.BIG, Dog.Color.BLACK);

        Human mama = new Human(Mammal.Gender.FEMAALE,"Мама Малыша", 32 );
        Thread.sleep(1000);

        System.out.println("...Мама вздохнула...");

        Thread.sleep(1000);
        System.out.println("...Ну вот, опять Малыш заговорил о своей вожделенной собаке! Это было почти так же невыносимо, как и разговоры о Карлсоне, который живет на крыше...");
        Thread.sleep(1000);
        malish.talkAbout(mama, darkPudel, "ох собака, моя собака, как я хочу собаку");
        Thread.sleep(1000);
        System.out.println("...В тот день Малышу было приятно идти в школу, потому что ему многое надо было обсудить с Кристером и Гуниллой.");
        malish.go(skila);

        CompanyForMalish krister = new CompanyForMalish(Mammal.Gender.MALE,"Кристер", 12,22 );
        CompanyForMalish gunila = new CompanyForMalish(Mammal.Gender.FEMAALE,"Гунила", 12,22 );

        malish.adFriend(malish, krister, gunila, carlson);
        krister.adFriend(malish, krister, gunila, carlson);
        gunila.adFriend(malish, krister, gunila, carlson);
        carlson.adFriend(malish, krister, gunila, carlson);

        System.out.println("...Домой они шли, как всегда, вместе. И Малыша это особенно радовало, потому что теперь Кристер и Гунилла тоже были знакомы с Карлсоном...");
        Thread.sleep(1000);
        malish.comeHere(krister, gunila);

        malish.goTogether(perecrestok, krister, gunila);
        Thread.sleep(1000);

        System.out.println("...Тут появилось еще одно существо, которое тоже захотело пойти вместе с ними... ");
        Thread.sleep(1000);


        System.out.println("...Когда ребята собрались перейти улицу, к Малышу подбежал маленький черный пудель. Он обнюхал коленки Малыша и дружески тявкнул...");
        Thread.sleep(1000);

        darkPudel.go(malish);

        Thread.sleep(1000);
        darkPudel.sniff(malish);

        Thread.sleep(1000);
        System.out.println("...Малыш был бы счастлив переводить щенка через все перекрестки города. Должно быть, щенок это почувствовал: он бежал вприпрыжку по мостовой, норовя прижаться к ноге Малыша... ");

        Thread.sleep(1000);
        try{
            darkPudel.hugLeg(malish);
        } catch (NoLegsException e){
            System.out.println("Нельзя прижаться к ногам, которых нет((");
        }

        Thread.sleep(1000);
        malish.goTogether(roadway, krister, gunila, darkPudel);
    }
}
