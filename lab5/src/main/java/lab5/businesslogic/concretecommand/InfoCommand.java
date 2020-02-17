package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class InfoCommand  implements Command {
    Reciver reciver;
    public InfoCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.info(t);
    }
}
