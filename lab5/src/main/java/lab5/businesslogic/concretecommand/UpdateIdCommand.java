package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class UpdateIdCommand implements Command {
    Reciver reciver;
    public UpdateIdCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.updateId(t);
    }
}
