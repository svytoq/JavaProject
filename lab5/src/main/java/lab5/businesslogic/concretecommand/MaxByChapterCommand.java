package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class MaxByChapterCommand implements Command {
    Reciver reciver;

    public MaxByChapterCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.maxByChapter(t);
    }
}
