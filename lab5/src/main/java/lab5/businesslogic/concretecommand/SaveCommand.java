package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.FileManager;
import lab5.businesslogic.Manager;
import lab5.businesslogic.Reciver;

public class SaveCommand implements Command {
    FileManager reciver;

    public SaveCommand(FileManager reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t)  {
        reciver.save(t);
    }
}
