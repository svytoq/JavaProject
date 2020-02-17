package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class FilterContainsNameCommand implements Command {
    Reciver reciver;

    public FilterContainsNameCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.filterContainsName(t);
    }
}
