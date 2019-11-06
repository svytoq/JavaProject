package living;

public class Carlson extends Mammal {

// отношение знаком/не знаком определенно этим массивом, в котором номер в масиве соответствует hash объекта
    private boolean Friend[] = new boolean[10000];
    private final String Smel = "jam";
    private final int hash = 0;

    public Carlson(Gender gender, String name){
        super(gender, name);
    }

    public Carlson(Gender gender, String name, int x, int y){
        super(gender, name, x, y);
    }

    public final void AdFriend(Mammal... h){
        for (Mammal o: h) {
            Friend[o.hashCode()] = true;
        }
    }

    public final boolean CheckFriend (Mammal h){
        if (Friend[h.hashCode()] = true){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "Carlson[единственный и неповтороримый, име=" + this.getName() + ", координата x=" + this.getCoordinateX() + ", координата y=" + this.getCoordinateY() + "]";
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
    public int hashCode(){
        return this.hash;
    }

}
