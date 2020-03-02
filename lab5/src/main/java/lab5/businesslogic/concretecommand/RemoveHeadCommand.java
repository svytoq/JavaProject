package lab5.businesslogic.concretecommand;

import lab5.businesslogic.CollectionManager;
import lab5.businesslogic.Command;
import lab5.businesslogic.Manager;
import lab5.businesslogic.Reciver;

public class RemoveHeadCommand implements Command {
    CollectionManager reciver;

    public RemoveHeadCommand(CollectionManager reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.removeHead(t);
    }
}
