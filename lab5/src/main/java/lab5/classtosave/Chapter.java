package lab5.classtosave;

//TODO: equals/hashCode
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long marinesCount; //Значение поля должно быть больше 0, Максимальное значение поля: 1000

    public Chapter (String name, Long marinesCount) {
        this.name = name;
        this.marinesCount = marinesCount;
    }

    public Chapter(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarinesCount(long marinesCount) {
        this.marinesCount = marinesCount;
    }

    public long getMarinesCount() {
        return marinesCount;
    }
}
