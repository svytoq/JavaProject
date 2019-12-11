package laba4.item;

public class Item implements MoveItem {
    private int coordinateX;
    private int coordinateY;
    private String Name;

    public Item(String name, int x, int y) {
        this.coordinateX = x;
        this.coordinateY = y;
        this.Name = name;
    }

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public int getCoordinateY() {
        return this.coordinateY;
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public String toString() {
        return "Item[название=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }


}