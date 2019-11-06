package item;

import living.Mammal;

public class Item implements MoveItem{
    private int CoordinateX;
    private int CoordinateY;
    private String Name;
    private final int hash;

    public Item(String name, int x, int y){
        this.CoordinateX = x;
        this.CoordinateY = y;
        this.Name = name;
        hash = Mammal.getIndeficator() + 1;
        Mammal.setIndeficator(hash);
    }

    public int getCoordinateX() {
        return this.CoordinateX;
    }

    public int getCoordinateY() {
        return this.CoordinateY;
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public String toString(){
        return "Item[название=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }

//так как каждому объекту в нашей модели соответствует свой hash
    @Override
    public boolean equals (Object o){
        if (this.hashCode() == o.hashCode()){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public final int hashCode(){
        return this.hash;
    }
}
