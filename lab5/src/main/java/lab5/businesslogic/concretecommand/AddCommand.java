package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;
import lab5.classtosave.UserNotReadException;

public class AddCommand implements Command {
    Reciver reciver;
    public AddCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.add(t);
    }
}
