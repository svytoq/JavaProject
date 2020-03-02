package lab5.businesslogic;

import lab5.classtosave.SpaceMarine;

import java.util.*;

/**
 * Класс, отвечающий за работу с коллекцией.
 */
public class CollectionManager implements Manager {

    private PriorityQueue<SpaceMarine> queue = new PriorityQueue<>();

    private ReaderManager readerManager;
    private Reciver reciver;
    private FileManager fileManager;

    public CollectionManager(){

    }

    public void updateId(String[] t) {
        Boolean flag = true;
        Long id = 0l;
        try {
            id = Long.parseLong(t[1]);
        } catch (IllegalArgumentException e) {
            System.out.println("неверный формат команды, для справки введите команду help");
            flag = false;
        }
        if (flag && searchId(id)) {
            remove(searchById(id));
            SpaceMarine spaceMarine = readerManager.readSpaceMarine();
            spaceMarine.setId(id);
            queue.add(spaceMarine);
            SpaceMarine.setClassId(SpaceMarine.getClassId()-1);
            System.out.println("Значения элемента обновлены");
        }else {
            if (flag) {
                System.out.println("элемента с таким айди нету");
            }
        }
        reciver.commandHistoryPush("updateId");
    }

    public void removeById(String[] t){
        Boolean flag = true;
        long id = 0;
        try{
            id = Integer.parseInt(t[1]);
        }catch (IllegalArgumentException e){
            System.out.println("неверный формат команды, для справки введите команду help");
            flag = false;
        }
        if (flag && searchId(id)){
            remove(searchById(id));
            System.out.println("объект удалён из коллекции");
        }else if (flag){
            System.out.println("Обьекта с таким id нет в коллекции");
        }
        reciver.commandHistoryPush("removeById");
    }

    public void clear(String[] t){
        queue.clear();
        System.out.println("Коллекция очищена");
        reciver.commandHistoryPush("clear");
    }


    public void add(String[] t)  {
        queue.add(readerManager.readSpaceMarine());
        System.out.println("Новый обьект добавлен в коллекцию");
        reciver.commandHistoryPush("add");
    }

    public void info(String[] t){
        System.out.println("количество переменных: " + queue.size() + " тип коллекции: " + queue.getClass().toString() );
        reciver.commandHistoryPush("info");
    }

    public void show(String[] t){
        if(!queue.isEmpty()){
            for(SpaceMarine spaceMarine : queue){
                System.out.println(spaceMarine.toString());
            }
        }else{
            System.out.println("в коллекции нет элементов");
        }
        reciver.commandHistoryPush("show");
    }


    /**
     * метод принимает
     * @param id
     *@return true если объект с таким id есть в коллекции, и false если нету
     */
    public boolean searchId(long id){
        boolean flag = false;
        for (SpaceMarine c : queue) {
            if (c.getId() == id) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * метод принимает
     * @param id
     *@return spaceMarine если объект с таким id есть в коллекции, иначе false
     */
    public SpaceMarine searchById(long id){
        SpaceMarine s = null;
        for (SpaceMarine c : queue){
            if (c.getId() == id){
                s = c;
                break;
            }
        }
            return s;
    }
    /**
     * метод принимает
     * @param spaceMarine
     *и удаляет его из коллекции
     */
    public void remove(SpaceMarine spaceMarine){
        queue.remove(spaceMarine);
    }


    /**
     * метод удаляет первый элемент в коллекции
     */
    public void removeHead(String[] t){
        for (SpaceMarine spaceMarine : queue){
            queue.remove(spaceMarine);
            break;
        }
        System.out.println("элементы удалены");
        reciver.commandHistoryPush("removeHead");
    }



    /**
     * метод принимает
     *удаляет из коллекции элементы с большим здоровьем
     */
    public void removeGreater(String[] t){
        SpaceMarine spaceMarine = readerManager.readSpaceMarine();
        queue.removeIf(s -> spaceMarine.getHealth() < s.getHealth());
        System.out.println("элементы удалены");
        reciver.commandHistoryPush("removeGreater");
    }




    /**
     * метод сравнивает объекты коллекции по MarinesCount
     *@return spaceMarine c MarinesCount если объект есть в коллекции, иначе null
     */
    public void maxByChapter(String[] t){
        long max = 0l;
        SpaceMarine maxi = null;
        for (SpaceMarine spaceMarine : queue){
            if (!(spaceMarine.getChapter() == null)){
                if (spaceMarine.getChapter().getMarinesCount() > max){
                    max = spaceMarine.getChapter().getMarinesCount();
                    maxi = spaceMarine;
                }
            }
        }
        try{
            System.out.println(maxi.toString());
        }catch (NullPointerException e){
            System.out.println("в коллекции нет объектов c иницилизированным полем chapter");
        }
        reciver.commandHistoryPush("maxByChapter");
    }



    /**
     * метод принимает
     * @param t String строку
     *@return ArrayList<SpaceMarine> объектов, у которых в имени встречается подсрока t
     */
    public void filterContainsName(String[] t){
        ArrayList<SpaceMarine> list = new ArrayList<>();
        for (SpaceMarine spaceMarine : queue){
            if (spaceMarine.getName().contains(t[1])){
                list.add(spaceMarine);
            }
        }
        for (SpaceMarine spaceMarine : list){
            System.out.println(spaceMarine.toString());
        }
        if (list.isEmpty()){
            System.out.println("В коллекции нет элементов с этой подстрокой");
        }
        reciver.commandHistoryPush("filterContainsName");
    }


    /**
     * метод
     * @return ArrayList<long> объектов, у которых в имени встречается подсрока t
     */
    public void printFieldAscendingChapter(String[] t){
        ArrayList<Long> list = new ArrayList<>();
        for(SpaceMarine spaceMarine : queue){
            if (!(spaceMarine.getChapter() == null))
            list.add(spaceMarine.getChapter().getMarinesCount());
        }
        Collections.sort(list, (o1, o2) -> (int) (o1 - o2));
        if (!list.isEmpty()){
            for (Long l : list){
                System.out.println(l.toString());
            }
        }else {
            System.out.println("в коллекции нет объектов c иницилизированным полем chapter");
        }
        reciver.commandHistoryPush("printFieldAscendingChapter");
    }

    /**
     * метод принимает
     * @param list LinkedList<SpaceMarine>
     * добавляет их в коллекцию
     */
    public void addAll(LinkedList<SpaceMarine> list){
        queue.addAll(list);
    }

    public PriorityQueue<SpaceMarine> getQueue() {
        return queue;
    }


    public void setReaderManager(ReaderManager readerManager) {
        this.readerManager = readerManager;
    }

    public void setReciver(Reciver reciver) {
        this.reciver = reciver;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }
}
