package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class PrintFieldAscendingChapterCommand implements Command {
    Reciver reciver;

    public PrintFieldAscendingChapterCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.printFieldAscendingChapter(t);
    }
}
