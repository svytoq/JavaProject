package lab5.businesslogic;


import lab5.classtosave.*;

import java.io.*;
import java.util.Scanner;

public class ReaderManager implements Manager{
    Scanner scanner = new Scanner(System.in);
    private Reciver reciver;
    private FileManager fileManager;
    private CollectionManager collectionManager;

    public ReaderManager() {
    }


    //TODO: файл не закрывается
    public void executeScript(String[] t) {
        File file = null;
        OutputStreamWriter ops = null;
        FileReader fileReader = null;
        try {
            file = new File(t[1]);
            fileReader = new FileReader(file);
            scanner = new Scanner(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        }
        reciver.commandHistoryPush("executeScript");
    }

    public String readLine() {
        String s = scanner.nextLine();
        return s;
    }

    public String[] readCommand() {
        String s = scanner.nextLine();
        String[] words = s.split("\\s");
        return words;
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public SpaceMarine readSpaceMarine() {

        boolean flag;
        String line;
        String name = null;
        while ((name == null) || (name.equals(""))) {
            System.out.println("Введите имя объекта, оно должно содержать хотя бы 1 знак");
            name = scanner.nextLine();
        }
        ;

        Integer coordinateX = 109;
        while (true) {
            flag = true;
            System.out.println("Введите координату X, она должна быть целым числом меньшим 109");
            try {
                line = scanner.nextLine();
                coordinateX = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                flag = false;
            }
            if (flag && coordinateX <= 108) {
                break;
            }
        }


        Float coordinateY = null;
        while (true) {
            flag = true;
            System.out.println("Введите координату Y, она должна быть вещественным числом, дробную часть записывайте через запятую");
            try {
                line = scanner.nextLine();
                coordinateY = Float.parseFloat(line);
            } catch (NumberFormatException e) {
                flag = false;
            }
            if (flag) {
                break;
            }
        }

        int health = 0;
        while (true) {
            flag = true;
            System.out.println("Введите очки здоровья, они должни быть натуральным числом");
            try {
                line = scanner.nextLine();
                health = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                flag = false;
            }
            if (flag && health >= 1) {
                break;
            }
        }

        AstartesCategory category = null;
        do {
            flag = false;
            System.out.println("Введите AstartesCategory, варианты для ввода:AGGRESSOR, TACTICAL, TERMINATOR, LIBRARIAN, APOTHECARY, обратите внимание, что нужно использовать заглавные буквы, если не хотите инициализировать поле - нажмите Enter");
            try {
                String t = scanner.nextLine();
                if (t.equals("")) {
                    flag = true;
                } else {
                    category = AstartesCategory.valueOf(t);
                    flag = true;
                }
            } catch (IllegalArgumentException e) {

            }
            if (flag) {
                break;
            }
        } while (true);

        Weapon weaponType = null;
        do {
            System.out.println("Введите тип оружия, варианты для ввода:BOLTGUN, MELTAGUN, HEAVY_FLAMER, обратите внимание, что нужно использовать заглавные буквы");
            try {
                weaponType = Weapon.valueOf(scanner.nextLine());
            } catch (IllegalArgumentException e) {

            }
        } while (weaponType == null);

        MeleeWeapon meleeWeapon = null;
        do {
            flag = false;
            System.out.println("Введите meleeWeapon, варианты для ввода:CHAIN_AXE, MANREAPER, POWER_BLADE, обратите внимание, что нужно использовать заглавные буквы, если не хотите инициализировать поле - нажмите Enter");
            try {
                String t = scanner.nextLine();
                if (t.equals("")) {
                    flag = true;
                } else {
                    meleeWeapon = MeleeWeapon.valueOf(t);
                    flag = true;
                }
            } catch (IllegalArgumentException e) {

            }
            if (flag) {
                break;
            }
        } while (true);

        System.out.println("нажмите Enter, усли хотите инициализировать поле Chapter, иначе введите любую последовательность символов");
        String t = scanner.nextLine();
        String chapterName = null;
        Long marinesCount = null;
        Chapter chapter = null;
        if (!t.equals("")) {

        } else {
            do {
                System.out.println("Введите chapterName, оно должно содержать хотя бы 1 знак");
                chapterName = scanner.nextLine();
            } while (chapterName == null || chapterName.equals(" "));

            while (true) {
                flag = true;
                System.out.println("Введите marinesCount, оно должно быть натуральным числом меньшим 1001");
                try {
                    line = scanner.nextLine();
                    marinesCount = Long.parseLong(line);
                } catch (NumberFormatException e) {
                    flag = false;
                }
                if (flag && marinesCount > 0 && marinesCount < 1001) {
                    break;
                }
            }
            chapter = new Chapter(chapterName, marinesCount);
        }

        return new SpaceMarine(name, new Coordinates(coordinateX, coordinateY), health, category, weaponType, meleeWeapon, chapter);
    }

    public void setReciver(Reciver reciver) {
        this.reciver = reciver;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
