import item.Building;
import item.MoveItem;
import item.Place;
import living.Carlson;
import living.Dog;
import living.Mammal;
import living.People;



public class Main {
    public static void main(String[] args) throws InterruptedException{

        Building HomeForMalish = new Building("Дом для малыша",10,15);

        Place Perecrestok = new Place("Перекрёсток",5, 7);
        Building Skila = new Building("Школа",12,22);
        Building Roadway = new Building("Мостовая",10,15);

        MoveItem Krisha = new MoveItem() {
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

        People Malish = new People(Mammal.Gender.MALE,"Малыш", 8);
        People Mama = new People(Mammal.Gender.FEMAALE,"Мама Малыша", 32 );
        Thread.sleep(1000);
        System.out.println("...Мама вздохнула...");
        Mama.sigh();
        Thread.sleep(1000);
        System.out.println("...Ну вот, опять Малыш заговорил о своей вожделенной собаке! Это было почти так же невыносимо, как и разговоры о Карлсоне, который живет на крыше...");
        Thread.sleep(1000);
        Malish.talkAboutDog();
        Thread.sleep(1000);
        System.out.println("...В тот день Малышу было приятно идти в школу, потому что ему многое надо было обсудить с Кристером и Гуниллой.");
        Malish.Go(Skila);

        Carlson Carlson = new Carlson(Mammal.Gender.MALE,"Карлсон", -100, -100, Krisha);
        People Krister = new People(Mammal.Gender.MALE,"Кристер", 12,22 );
        People Gunila = new People(Mammal.Gender.FEMAALE,"Гунила", 12,22 );

        Malish.AdFriend(Malish, Krister, Gunila, Carlson);
        Krister.AdFriend(Malish, Krister, Gunila, Carlson);
        Gunila.AdFriend(Malish, Krister, Gunila, Carlson);
        Carlson.AdFriend(Malish, Krister, Gunila, Carlson);

        System.out.println("...Домой они шли, как всегда, вместе. И Малыша это особенно радовало, потому что теперь Кристер и Гунилла тоже были знакомы с Карлсоном...");
        Thread.sleep(1000);
        Malish.ComeHere(Krister, Gunila);

        Malish.GoTogether(Perecrestok, Krister, Gunila);
        Thread.sleep(1000);

        System.out.println("...Тут появилось еще одно существо, которое тоже захотело пойти вместе с ними... ");
        Thread.sleep(1000);

        Dog DarkPudel = new Dog(Mammal.Gender.FEMAALE, "Черный пудель", 4, 3, Dog.Size.BIG, Dog.Color.BLACK);

        System.out.println("...Когда ребята собрались перейти улицу, к Малышу подбежал маленький черный пудель. Он обнюхал коленки Малыша и дружески тявкнул...");
        Thread.sleep(1000);

        DarkPudel.Go(Malish);

        Thread.sleep(1000);
        DarkPudel.Sniff(Malish);

        Thread.sleep(1000);
        System.out.println("...Малыш был бы счастлив переводить щенка через все перекрестки города. Должно быть, щенок это почувствовал: он бежал вприпрыжку по мостовой, норовя прижаться к ноге Малыша... ");
        People.Leg LegForMalish = Malish.new Leg(5, "правая нога малыша");

        Thread.sleep(1000);
        DarkPudel.HugLeg(LegForMalish);

        Thread.sleep(1000);
        Malish.GoTogether(Roadway, Krister, Gunila, DarkPudel);
    }
}
