package lab5.businesslogic.concretecommand;

import lab5.businesslogic.Command;
import lab5.businesslogic.ReaderManager;


public class ExecuteScriptCommand implements Command {
    ReaderManager reciver;

    public ExecuteScriptCommand(ReaderManager reciver){
        this.reciver = reciver;
    }
    @Override
    public void execute(String[] t){
        reciver.executeScript(t);
    }
}
