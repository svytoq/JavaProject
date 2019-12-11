package laba4.living;

// классы использующие этот интерфейс могут участвовать в движении в качестве Mammal
public interface Moving {
    int getCoordinateX();
    int getCoordinateY();
    void setCoordinateX(int CoordinateY);
    void setCoordinateY(int CoordinateY);
    String getName();
}
