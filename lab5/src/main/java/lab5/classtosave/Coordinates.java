package lab5.classtosave;

public class Coordinates {
    private Integer x; //Максимальное значение поля: 108, Поле не может быть null
    private Float y; //Поле не может быть null

    public Coordinates(Integer x, Float y)  {
        this.x = x;
        this.y = y;
    }

    public Coordinates(){

    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }
}
