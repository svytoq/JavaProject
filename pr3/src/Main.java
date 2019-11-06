import item.Building;
import item.Place;
import living.Carlson;
import living.Dog;
import living.Mammal;
import living.People;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        Building HomeForMalish = new Building("Дом для малыша",10,15);
        Place Perecrestok = new Place("Перекрёсток",5, 7);

        Carlson Carlson = new Carlson(Mammal.Gender.MALE,"Карлсон", -100, -100);
        People Malish = new People(Mammal.Gender.MALE,"Малыш" );
        People Krister = new People(Mammal.Gender.MALE,"Кристер" );
        People Gunila = new People(Mammal.Gender.FEMAALE,"Гунила" );

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

        Dog DarkPudel = new Dog(Mammal.Gender.FEMAALE, "Черный пудель", 4, 3);

        System.out.println("...Когда ребята собрались перейти улицу, к Малышу подбежал маленький черный пудель. Он обнюхал коленки Малыша и дружески тявкнул...");
        Thread.sleep(1000);

        DarkPudel.Go(Malish);

        Thread.sleep(1000);
        DarkPudel.Sniff(Malish);

        Thread.sleep(1000);
        Malish.GoTogether(HomeForMalish, Krister, Gunila, DarkPudel);
    }
}
