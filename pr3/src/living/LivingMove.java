package living;

// классы использующие этот интерфейс могут участвовать в движении в качестве Mammal
public interface LivingMove {
    int getCoordinateX();
    int getCoordinateY();
    void setCoordinateX(int CoordinateY);
    void setCoordinateY(int CoordinateY);
    String getName();
}
