package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class SaveCommand implements Command {
    Reciver reciver;

    public SaveCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t)  {
        reciver.save(t);
    }
}
