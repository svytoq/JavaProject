package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.Reciver;

public class ExecuteScriptCommand implements Command {
    Reciver reciver;

    public ExecuteScriptCommand(Reciver reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.executeScript(t);
    }
}
