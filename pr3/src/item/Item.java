package item;
public class Item implements MoveItem {
    private int CoordinateX;
    private int CoordinateY;
    private String Name;

    public Item(String name, int x, int y) {
        this.CoordinateX = x;
        this.CoordinateY = y;
        this.Name = name;
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
    public String toString() {
        return "Item[название=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
    }


}