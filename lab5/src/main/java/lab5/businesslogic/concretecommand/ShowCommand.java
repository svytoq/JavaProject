package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class ShowCommand implements Command {
    Reciver reciver;
    public ShowCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.show(t);
    }
}
