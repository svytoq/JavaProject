package lab5.businesslogic;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Invoker {
    private ReaderManager readerManager;
    private Command help;
    private Command info;
    private Command show;
    private Command add;
    private Command updateId;
    private Command removeById;
    private Command clear;
    private Command save;
    private Command executeScript;
    private Command exit;
    private Command removeHead;
    private Command removeGreater;
    private Command history;
    private Command maxByChapter;
    private Command filterContainsName;
    private Command printFieldAscendingChapter;


    public Invoker(ReaderManager readerManager, Command help, Command info, Command show, Command add, Command updateId, Command removeById,
                   Command clear, Command save, Command executeScript, Command exit, Command removeHead, Command removeGreater,
                   Command history, Command maxByChapter, Command filterContainsName, Command printFieldAscendingChapter) {
        this.readerManager = readerManager;
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
        System.out.println("вводите команды");
        while (true) {
            try {
                String[] words = readerManager.readCommand();
                if (!(words.length == 0)) {
                    switch (words[0]) {

                        case "help":
                            if (words.length == 1) {
                                help.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "info":
                            if (words.length == 1) {
                                info.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "show":
                            if (words.length == 1) {
                                show.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "add":
                            if (words.length == 1) {
                                add.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "updateId":
                            if (words.length == 2) {
                                updateId.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "removeById":
                            if (words.length == 2) {
                                removeById.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "clear":
                            if (words.length == 1) {
                                clear.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "save":
                            if (words.length == 1) {
                                save.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "executeScript":
                            if (words.length == 2) {
                                executeScript.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "exit":
                            if (words.length == 1) {
                                exit.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "removeHead":
                            if (words.length == 1) {
                                removeHead.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "removeGreater":
                            if (words.length == 1) {
                                removeGreater.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "history":
                            if (words.length == 1) {
                                history.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "maxByChapter":
                            if (words.length == 1) {
                                maxByChapter.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "filterContainsName":
                            if (words.length == 2) {
                                filterContainsName.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        case "printFieldAscendingChapter":
                            if (words.length == 1) {
                                printFieldAscendingChapter.execute(words);
                            } else {
                                System.out.println("неверный формат команды, для справки введите команду help");
                            }
                            break;

                        default:
                            System.out.println("неверный формат команды, для справки введите команду help");
                    }
                } else {
                    System.out.println("неверный формат команды, для справки введите команду help");
                }
            } catch (NoSuchElementException e) {
                readerManager.setScanner(new Scanner(System.in));
            }

        }
    }


}