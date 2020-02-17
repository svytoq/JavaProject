package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class RemoveGreaterCommand implements Command {
    Reciver reciver;

    public RemoveGreaterCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.removeGreater(t);
    }
}
