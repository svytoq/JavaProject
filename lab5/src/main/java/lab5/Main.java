package lab5;


import lab5.businesslogic.*;
import lab5.businesslogic.concretecommand.*;

import java.util.NoSuchElementException;


public class Main {
    public static void main(String[] args)  {
        try {
            //SpaceMarine testObject = new SpaceMarine("submarine", new Coordinates(5, 5f), 5, AstartesCategory.AGGRESSOR, Weapon.BOLTGUN, MeleeWeapon.CHAIN_AXE, new Chapter("sub", 10l));
            ReaderManager readerManager = new ReaderManager();
            CollectionManager collectionManager = new CollectionManager();
            FileManager fileManager = new FileManager();

            readerManager.setCollectionManager(collectionManager);
            readerManager.setFileManager(fileManager);

            collectionManager.setReaderManager(readerManager);
            collectionManager.setFileManager(fileManager);

            fileManager.setReaderManager(readerManager);
            fileManager.setCollectionManager(collectionManager);

            Reciver reciver = new Reciver(readerManager, fileManager, collectionManager);

            readerManager.setReciver(reciver);
            collectionManager.setReciver(reciver);
            fileManager.setReciver(reciver);


            fileManager.load(args[0]);

            Invoker user = new Invoker(readerManager, new HelpCommand(reciver), new InfoCommand(collectionManager), new ShowCommand(collectionManager),
                    new AddCommand(collectionManager), new UpdateIdCommand(collectionManager), new RemoveByIdCommand(collectionManager), new ClearCommand(collectionManager),
                    new SaveCommand(fileManager), new ExecuteScriptCommand(readerManager), new ExitCommand(reciver), new RemoveHeadCommand(collectionManager),
                    new RemoveGreaterCommand(collectionManager), new HistoryCommand(reciver), new MaxByChapterCommand(collectionManager),
                    new FilterContainsNameCommand(collectionManager), new PrintFieldAscendingChapterCommand(collectionManager));
            user.start();
        }catch (NoSuchElementException e){
        }
    }
}



