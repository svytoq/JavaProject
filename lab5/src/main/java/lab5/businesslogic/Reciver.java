package lab5.businesslogic;

import lab5.classtosave.*;
import sun.misc.Queue;

import java.io.*;
import java.util.*;

public class Reciver {

    ReaderManager readerManager;
    FileManager fileManager;
    CollectionManager collectionManager;
    private int historyNumber = 0;
    private ArrayList<String> commandHistory = new ArrayList<>();

    public Reciver(ReaderManager readerManager, FileManager fileManager, CollectionManager collectionManager){
        this.readerManager = readerManager;
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }

    public void help(String[] t){
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add : добавить новый элемент в коллекцию\n" +
                "update id  : обновить значение элемента коллекции, id которого равен заданному\n" +
                "removeById id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "executeScript file: считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "removeHead : вывести первый элемент коллекции и удалить его\n" +
                "removeGreater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "history : вывести последние 15 команд (без их аргументов)\n" +
                "maxByChapter : вывести любой объект из коллекции, значение поля chapter которого является максимальным\n" +
                "filterContainsName name : вывести элементы, значение поля name которых содержит заданную подстроку\n" +
                "printFieldAscendingChapter chapter : вывести значения поля chapter в порядке возрастания");
        commandHistory.add("help");
    }



    public void exit(String[] t){
        System.exit(1);
    }

    public void history(String[] t){
        int score = 0;
        System.out.println("История команд:");
        Collections.reverse(commandHistory);
        for (String e : commandHistory){
            System.out.println(e);
            score++;
            if (score == 15){
                break;
            }
        }
        Collections.reverse(commandHistory);
        commandHistory.add("history");
    }

    public void commandHistoryPush(String t){
        commandHistory.add(t);
        historyNumber++;
    }
}

