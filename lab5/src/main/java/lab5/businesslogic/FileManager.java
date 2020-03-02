package lab5.businesslogic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab5.classtosave.SpaceMarine;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class FileManager implements Manager {

    private CollectionManager collectionManager;
    private ReaderManager readerManager;
    private Reciver reciver;
    String nameFile;
    public FileManager() {
    }


    public void load(String nameFile) {
        this.nameFile = nameFile;
        try {
            File file = new File(nameFile);
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String result = "";
            String line;
            try {
                while ((line = fileReader.readLine()) != null) {
                    result = result + line;
                }
            }catch (IOException e){
                System.out.println("файл пуст?");
            }

            TypeReference<LinkedList<SpaceMarine>> typeSpaceMarine = new TypeReference<LinkedList<SpaceMarine>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            };
            try {
                LinkedList<SpaceMarine> fromXML = parse().readValue(result.toString(), typeSpaceMarine);
                collectionManager.addAll(fromXML);
            }catch ( JsonProcessingException e ){
                System.out.println("данные в файле невозможно преобразовать к нашей коллекции");
            }
            try {
                fileReader.close();
            } catch (IOException e){
                System.out.println("поток уже закрыт?");
            }

            long t = 1;
            for (SpaceMarine spaceMarine : collectionManager.getQueue()) {
                t = Math.max(t, spaceMarine.getId());
            }
            SpaceMarine.setClassId(t + 1);
        }catch (FileNotFoundException e) {
            System.out.println("файла не существует или к нему отсутсвует доступ");
        }
    }

    public XmlMapper parse(){
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        return mapper;
    }

    public void save(String[] t)  {
         File file = new File(nameFile);
            if (!file.exists()){
            System.out.println("файл указанный для сохранения/загрузки не существует");
        }else if (!file.canRead() || !file.canWrite()) {
                System.out.println("Файл не доступен для чтения или записи");
        }else if (file.isDirectory()){
            System.out.println("Это директория, укажите файл");
        }else {
                try {
                    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file));
                    fileWriter.write(parse().writeValueAsString(collectionManager.getQueue()));
                    fileWriter.close();
                    System.out.println("коллекция успешно сохранена");
                }catch ( IOException e){
                    System.out.println("поток закрыт?");
                }
            }
        reciver.commandHistoryPush("save");
    }

    public void setCollectionManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void setReaderManager(ReaderManager readerManager) {
        this.readerManager = readerManager;
    }

    public void setReciver(Reciver reciver) {
        this.reciver = reciver;
    }
}