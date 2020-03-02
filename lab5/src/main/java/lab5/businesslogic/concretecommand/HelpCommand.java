package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Manager;
import lab5.businesslogic.Reciver;

public class HelpCommand implements Command {
    Reciver reciver;
    public HelpCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.help(t);
    }

}
