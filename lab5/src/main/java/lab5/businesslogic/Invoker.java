package lab5.businesslogic;

import lab5.classtosave.UserNotReadException;

import java.io.IOException;
import java.util.Scanner;

public class Invoker {
    Command help;
    Command info;
    Command show;
    Command add;
    Command updateId;
    Command removeById;
    Command clear;
    Command save;
    Command executeScript;
    Command exit;
    Command removeHead;
    Command removeGreater;
    Command history;
    Command maxByChapter;
    Command filterContainsName;
    Command printFieldAscendingChapter;

    public Invoker(Command help, Command info, Command show, Command add, Command updateId, Command removeById,
                   Command clear, Command save, Command executeScript, Command exit, Command removeHead, Command removeGreater,
                   Command history, Command maxByChapter, Command filterContainsName, Command printFieldAscendingChapter) {
        this.help = help;
        this.info = info;
        this.show = show;
        this.add = add;
        this.updateId = updateId;
        this.removeById = removeById;
        this.clear = clear;
        this.save = save;
        this.executeScript = executeScript;
        this.exit = exit;
        this.removeHead = removeHead;
        this.removeGreater = removeGreater;
        this.history = history;
        this.maxByChapter = maxByChapter;
        this.filterContainsName = filterContainsName;
        this.printFieldAscendingChapter = printFieldAscendingChapter;
    }



    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            String[] words = s.split("\\s");
            switch (words[0]){

                case "help":
                    if (words.length == 1){
                        help.execute(words);
                    }else {
                        System.out.println("у команды help не должно быть аргументов");
                    }
                    break;

                case "info":
                    if (words.length == 1){
                        info.execute(words);
                    }else {
                        System.out.println("у команды info не должно быть аргументов");
                    }
                    break;

                case "show":
                    if (words.length == 1){
                        show.execute(words);
                    }else {
                        System.out.println("у команды show не должно быть аргументов");
                    }
                    break;

                case "add":
                    if (words.length == 1){
                        add.execute(words);
                    }else {
                        System.out.println("у команды add не должно быть аргументов");
                    }
                    break;

                case "updateId":
                    if (words.length == 2){
                        updateId.execute(words);
                    }
                    else{
                        System.out.println("аргумент команды updateId должен быть натуральным числом, причем он должен быть только один");
                    }
                    break;

                case "removeById":
                    if (words.length == 2){
                        removeById.execute(words);
                    }
                    else{
                        System.out.println("аргумент команды removeById должен быть натуральным числом, причем он должен быть только один");
                    }
                    break;

                case "clear":
                    if (words.length == 1){
                        clear.execute(words);
                    }else {
                        System.out.println("у команды не должно быть аргументов");
                    }
                    break;

                case "save":
                    if (words.length == 1){
                        save.execute(words);
                    }else {
                        System.out.println("у команды не должно быть аргументов");
                    }
                    break;

                case "executeScript":
                    if (words.length == 2){
                        executeScript.execute(words);
                    }else {
                        System.out.println("у команды должен быть аргумент, причем только один");
                    }
                    break;

                case "exit":
                    if (words.length == 1){
                        exit.execute(words);
                    }else {
                        System.out.println("у команды не должно быть аргументов");
                    }
                    break;

                case "removeHead":
                    if (words.length == 1){
                        removeHead.execute(words);
                    }else {
                        System.out.println("у команды не должно быть аргументов");
                    }
                    break;

                case "removeGreater":
                    if (words.length == 1){
                        removeGreater.execute(words);
                    }else {
                        System.out.println("у команды не должно быть аргументов");
                    }
                    break;

                case "history":
                    if(words.length == 1){
                        history.execute(words);
                    }else {
                        System.out.println("у команды не должно быть аргументов");
                    }
                    break;

                case "maxByChapter":
                    if(words.length == 1){
                        maxByChapter.execute(words);
                    }else {
                        System.out.println("у команды не должно быть аргумента");
                    }
                    break;

                case "filterContainsName":
                    if (words.length == 2){
                        filterContainsName.execute(words);
                    }else {
                        System.out.println("у команды должен быть аргумент, причем только один");
                    }
                    break;

                case "printFieldAscendingChapter":
                    if (words.length == 1){
                        printFieldAscendingChapter.execute(words);

                    }else {
                        System.out.println("у команды не должно быть аргумента");
                    }
                    break;

                default:
                    System.out.println("вы ввели хуйню, для справки введите команду help");
            }
        }
    }
}
