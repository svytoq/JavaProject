package lab5.businesslogic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab5.classtosave.*;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class Reciver {
    Scanner scanner = new Scanner(System.in);
    Queue<SpaceMarine> queue = new PriorityQueue<>();
    private Stack<String> commandHistory = new Stack<>();

    public void load(String nameFile) throws IOException {
        File file = new File(nameFile);
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String result = "";
        String line;

        while ((line = fileReader.readLine())!= null) {
            result = result+line;
        }

        TypeReference<LinkedList<SpaceMarine>> typeSpaceMarine = new TypeReference<LinkedList<SpaceMarine>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        };

        LinkedList<SpaceMarine> fromXML = parse().readValue(result.toString(), typeSpaceMarine);

        queue.addAll(fromXML);

        fileReader.close();
    }

    private XmlMapper parse(){
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        return mapper;
    }

    public SpaceMarine createSpaceMarine(){
        boolean flag;
        String line;
        String name = null;
        while ((name == null) || (name.equals(""))) {
            System.out.println("Введите имя объекта, оно должно содержать хотя бы 1 знак");
            name = scanner.nextLine();
        };

        Integer coordinateX = 109;
        while (true){
            flag = true;
            System.out.println("Введите координату X, она должна быть целым числом меньшим 109");
            try {line = scanner.nextLine();
                coordinateX = Integer.parseInt(line);
            }catch (NumberFormatException e){
                flag = false;
            }
            if (flag && coordinateX <= 108 ){
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
        while (true){
            flag = true;
            System.out.println("Введите очки здоровья, они должни быть натуральным числом");
            try {line = scanner.nextLine();
                health = Integer.parseInt(line);
            }catch (NumberFormatException e){
                flag = false;
            }
            if (flag && health >= 1){
                break;
            }
        }

        AstartesCategory category = null;
        do{
            System.out.println("Введите AstartesCategory, варианты для ввода:AGGRESSOR, TACTICAL, TERMINATOR, LIBRARIAN, APOTHECARY, обратите внимание, что нужно использовать заглавные буквы");
            try {
                category = AstartesCategory.valueOf(scanner.nextLine());
            }catch ( IllegalArgumentException e){

            }
        }while (category == null);

        Weapon weaponType = null;
        do{
            System.out.println("Введите тип оружия, варианты для ввода:BOLTGUN, MELTAGUN, HEAVY_FLAMER, обратите внимание, что нужно использовать заглавные буквы");
            try {
                weaponType = Weapon.valueOf(scanner.nextLine());
            }catch ( IllegalArgumentException e){

            }
        }while (weaponType == null);

        MeleeWeapon meleeWeapon = null;
        do{
            System.out.println("Введите meleeWeapon, варианты для ввода:CHAIN_AXE, MANREAPER, POWER_BLADE, обратите внимание, что нужно использовать заглавные буквы");
            try {
                meleeWeapon = MeleeWeapon.valueOf(scanner.nextLine());
            }catch ( IllegalArgumentException e){

            }
        }while (meleeWeapon == null);

        String chapterName;
        do {
            System.out.println("Введите chapterName, оно должно содержать хотя бы 1 знак");
            chapterName = scanner.nextLine();
        }while (chapterName == null || chapterName.equals("") );

        Long marinesCount = null;
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
        return new SpaceMarine(name, new Coordinates(coordinateX, coordinateY), health, category, weaponType, meleeWeapon, new Chapter(chapterName, marinesCount));
    }
    public boolean searchId(int i){
        boolean flag = false;
        for (SpaceMarine c : queue) {
            if (c.getId() == i) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public SpaceMarine searchById(int i) throws UserNotReadException {
        boolean flag = false;
        SpaceMarine s = null;
        for (SpaceMarine c : queue){
            if (c.getId() == i){
                s = c;
                flag = true;
                break;
            }
        }
        if(flag){
            return s;
        }
        else {
            throw new UserNotReadException();
        }
    }

    public void help(String[] t){
        System.out.println("help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_head : вывести первый элемент коллекции и удалить его\n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\n" +
                "history : вывести последние 15 команд (без их аргументов)\n" +
                "max_by_chapter : вывести любой объект из коллекции, значение поля chapter которого является максимальным\n" +
                "filter_contains_name name : вывести элементы, значение поля name которых содержит заданную подстроку\n" +
                "print_field_ascending_chapter chapter : вывести значения поля chapter в порядке возрастания");
        commandHistory.push("help");
    };

    public void info(String[] t){
        System.out.println("размер коллекции: " + queue.size() + ", тип коллекции:" + queue.getClass());
        commandHistory.push("info");
    };

    public void show(String[] t){
        for (SpaceMarine c : queue){
            System.out.println(c.toString());
        }
        commandHistory.push("show");
    };


    public void add(String[] t)  {
        queue.add(createSpaceMarine());
        System.out.println("Новый обьект добавлен в коллекцию");
        commandHistory.push("add");
    };

    public void updateId(String[] t) {
        Boolean flag1 = true;
        int id = 0;
        try {
            id = Integer.parseInt(t[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("аргумент команды updateId должен быть натуральным числом");
            flag1 = false;
        }
        if (flag1 && searchId(id)) {
            boolean flag;
            String line;
            String name = null;
            while ((name == null) || (name.equals(""))) {
                System.out.println("Введите имя объекта, оно должно содержать хотя бы 1 знак");
                name = scanner.nextLine();
            }

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
                System.out.println("Введите AstartesCategory, варианты для ввода:AGGRESSOR, TACTICAL, TERMINATOR, LIBRARIAN, APOTHECARY, обратите внимание, что нужно использовать заглавные буквы");
                try {
                    category = AstartesCategory.valueOf(scanner.nextLine());
                } catch (IllegalArgumentException e) {

                }
            } while (category == null);

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
                System.out.println("Введите meleeWeapon, варианты для ввода:CHAIN_AXE, MANREAPER, POWER_BLADE, обратите внимание, что нужно использовать заглавные буквы");
                try {
                    meleeWeapon = MeleeWeapon.valueOf(scanner.nextLine());
                } catch (IllegalArgumentException e) {

                }
            } while (meleeWeapon == null);

            String chapterName;
            do {
                System.out.println("Введите chapterName, оно должно содержать хотя бы 1 знак");
                chapterName = scanner.nextLine();
            } while (chapterName == null || chapterName.equals(""));

            Long marinesCount = null;
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
            try {
                searchById(id).update(name, new Coordinates(coordinateX, coordinateY), health, category, weaponType, meleeWeapon, new Chapter(chapterName, marinesCount));
                System.out.println("Значения элемента обновлены");
            } catch (UserNotReadException e) {
                System.out.println("Нету элемента с таким id");
            }

        } else {
            if (flag1) {
                System.out.println("Нету элемента с таким id");
            }
        }
        commandHistory.push("updateId");
    }
    public void removeById(String[] t){
        Boolean flag = true;
        int id = 0;
        try{
            id = Integer.parseInt(t[1]);
        }catch (IllegalArgumentException e){
            System.out.println("аргумент команды removeById должен быть натуральным числом");
            flag = false;
        }
        if (flag){
            metca: for (SpaceMarine c: queue) {
                if (c.getId() == id) {
                    queue.remove(c);
                    System.out.println("Обьект удалён");
                    flag = false;
                    break metca;
                }
            }if(flag) {
                System.out.println("Обьекта с таким id нет в коллекции");
            }

        }
        commandHistory.push("removeById");
    }

    public void clear(String[] t){
        queue.clear();
        System.out.println("Коллекция очищена");
        commandHistory.push("clear");
    }

    public void save(String[] t) throws IOException {
        File file = new File("src/main/java/lab5/file");

        try {
            if (!file.exists()) throw new FileNotFoundException();
        } catch (FileNotFoundException ex){
            System.out.println("Такого файла не сушествует");
        }
        try {
            if (!file.canRead() || !file.canWrite()) throw new SecurityException();
        } catch (SecurityException ex){
            System.out.println("Файл не доступен для чтения или записи");
        }
        try {
            if (file.isDirectory()) throw new SecurityException();
        } catch (SecurityException ex){
            System.out.println("Это директория, укажите файл");
        }

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
        fileWriter.write(parse().writeValueAsString(queue));
        fileWriter.close();
    }

    public void executeScript(String[] t) {
        try {
            File file = new File(t[1]);
            FileReader fileReader = new FileReader(file);
            OutputStreamWriter ops = new OutputStreamWriter(System.out);
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] words = line.split("\\s");
                switch (words[0]){
                    case "help":
                        if (words.length == 1){
                            help(words);
                        }else {
                            System.out.println("у команды help не должно быть аргументов");
                        }
                        break;

                    case "info":
                        if (words.length == 1){
                            info(words);
                        }else {
                            System.out.println("у команды info не должно быть аргументов");
                        }
                        break;

                    case "show":
                        if (words.length == 1){
                            show(words);
                        }else {
                            System.out.println("у команды show не должно быть аргументов");
                        }
                        break;

                    case "add":
                        if (words.length == 1){
                            add(words);
                        }else {
                            System.out.println("у команды add не должно быть аргументов");
                        }
                        break;

                    case "updateId":
                        if (words.length == 2){
                            updateId(words);
                        }
                        else{
                            System.out.println("аргумент команды updateId должен быть натуральным числом, причем он должен быть только один");
                        }
                        break;

                    case "removeById":
                        if (words.length == 2){
                            removeById(words);
                        }
                        else{
                            System.out.println("аргумент команды removeById должен быть натуральным числом, причем он должен быть только один");
                        }
                        break;

                    case "clear":
                        if (words.length == 1){
                            clear(words);
                        }else {
                            System.out.println("у команды не должно быть аргументов");
                        }
                        break;

                    case "save":
                        if (words.length == 1){
                            save(words);
                        }else {
                            System.out.println("у команды не должно быть аргументов");
                        }
                        break;

                    case "executeScript":
                        if (words.length == 2){
                            executeScript(words);
                        }else {
                            System.out.println("у команды должен быть аргумент, причем только один");
                        }
                        break;

                    case "exit":
                        if (words.length == 1){
                            exit(words);
                        }else {
                            System.out.println("у команды не должно быть аргументов");
                        }
                        break;

                    case "removeHead":
                        if (words.length == 1){
                            removeHead(words);
                        }else {
                            System.out.println("у команды не должно быть аргументов");
                        }
                        break;

                    case "removeGreater":
                        if (words.length == 1){
                            removeGreater(words);
                        }else {
                            System.out.println("у команды не должно быть аргументов");
                        }
                        break;

                    case "history":
                        if(words.length == 1){
                            history(words);
                        }else {
                            System.out.println("у команды не должно быть аргументов");
                        }
                        break;

                    case "maxByChapter":
                        if(words.length == 1){
                            maxByChapter(words);
                        }else {
                            System.out.println("у команды не должно быть аргумента");
                        }
                        break;

                    case "filterContainsName":
                        if (words.length == 2){
                            filterContainsName(words);
                        }else {
                            System.out.println("у команды должен быть аргумент, причем только один");
                        }
                        break;

                    case "printFieldAscendingChapter":
                        if (words.length == 1){
                            printFieldAscendingChapter(words);

                        }else {
                            System.out.println("у команды не должно быть аргумента");
                        }
                        break;

                    default:
                        System.out.println("вы ввели хуйню, для справки введите команду help");
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("файл не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(String[] t){
        System.out.println("Программа заверщилась корректно");
        System.exit(0);
    }

    public void removeHead(String[] t){
        for (SpaceMarine spaceMarine : queue){
            System.out.println(spaceMarine.toString());
            queue.remove(spaceMarine);
            System.out.println("объект удалён из очереди");
            break;
        }
        commandHistory.push("removeHead");
    }

    public void removeGreater(String[] t){
        SpaceMarine spaceMarine = createSpaceMarine();
        for (SpaceMarine s : queue){
            if (spaceMarine.getHealth() < s.getHealth()){
                System.out.println(s.toString() + "удалён из коллекции");
                queue.remove(s);
            }
        }
        commandHistory.push("removeGreater");
    }

    public void history(String[] t){
        int score = 0;
        System.out.println("История команд:");
        for (String s : commandHistory){
            System.out.println(s);
            score++;
            if (score == 15){
                break;
            }
        }
        commandHistory.push("history");

    }

    public void maxByChapter(String[] t){
        long max = 0l;
        SpaceMarine maxi = null;
        for (SpaceMarine spaceMarine : queue){
            if (spaceMarine.getChapter().getMarinesCount() > max){
                max = spaceMarine.getChapter().getMarinesCount();
                maxi = spaceMarine;
            }

        }
        if (max == 0){
            System.out.println("в коллекции нет объектов");
        }else {
            System.out.println(maxi.toString());
        }
        commandHistory.push("maxByChapter");

    }

    public void filterContainsName(String[] t){
        boolean flag = false;
        for (SpaceMarine spaceMarine : queue){
            if (spaceMarine.getName().contains(t[1])){
                System.out.println(spaceMarine.toString());
                flag = true;
            }
        }
        if (!flag){
            System.out.println("нет элемента с такой подстрокой");
        }
        commandHistory.push("filterContainsName");
    }
    public void printFieldAscendingChapter(String[] t){
        ArrayList<Long> list = new ArrayList<>();
        for(SpaceMarine spaceMarine : queue){
            list.add(spaceMarine.getChapter().getMarinesCount());
        }
        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return(int) (o1 -o2);
            }
        });
        for (Long l : list){
            System.out.println(l);
        }
        commandHistory.push("printFieldAscendingChapter");
    }

}

