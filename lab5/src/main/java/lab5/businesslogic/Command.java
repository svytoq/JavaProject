package lab5.businesslogic;

import lab5.classtosave.UserNotReadException;

import java.io.IOException;

public interface Command {
    public void execute(String[] t) throws IOException;
}
