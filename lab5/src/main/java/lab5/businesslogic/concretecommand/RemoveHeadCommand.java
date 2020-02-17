package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class RemoveHeadCommand implements Command {
    Reciver reciver;

    public RemoveHeadCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.removeHead(t);
    }
}
