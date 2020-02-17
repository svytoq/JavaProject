package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class RemoveByIdCommand implements Command {
    Reciver reciver;

    public RemoveByIdCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.removeById(t);
    }
}
