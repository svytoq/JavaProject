package lab5.businesslogic.concretecommand;

import lab5.businesslogic.CollectionManager;
import lab5.businesslogic.Command;
import lab5.businesslogic.Manager;
import lab5.businesslogic.Reciver;
import lab5.classtosave.UserNotReadException;

public class AddCommand implements Command {
    CollectionManager reciver;
    public AddCommand(CollectionManager reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.add(t);
    }
}
