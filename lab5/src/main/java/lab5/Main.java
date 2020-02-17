package lab5;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lab5.businesslogic.*;
import lab5.businesslogic.concretecommand.*;
import lab5.classtosave.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        //SpaceMarine testObject = new SpaceMarine("submarine", new Coordinates(5, 5f), 5, AstartesCategory.AGGRESSOR, Weapon.BOLTGUN, MeleeWeapon.CHAIN_AXE, new Chapter("sub", 10l));
        Reciver server = new Reciver();
        server.load("src/main/java/lab5/file");
        Invoker user = new Invoker(new HelpCommand(server), new InfoCommand(server), new ShowCommand(server),
                new AddCommand(server), new UpdateIdCommand(server), new RemoveByIdCommand(server), new ClearCommand(server),
                new SaveCommand(server), new ExecuteScriptCommand(server), new ExitCommand(server), new RemoveHeadCommand(server),
                new RemoveGreaterCommand(server), new HistoryCommand(server), new MaxByChapterCommand(server),
                new FilterContainsNameCommand(server), new PrintFieldAscendingChapterCommand(server));
        user.start();

    }
    private static void jacksonXmlExample(SpaceMarine testClass) throws IOException {
        System.out.println("Test XML serialization with jackson");
        XmlMapper mapper = new XmlMapper();
        mapper.registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).disable(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE);
        String serialized = mapper.writeValueAsString(testClass);
        System.out.println("XML value: " + serialized);
        SpaceMarine deserialized = mapper.readValue(serialized, SpaceMarine.class);
        System.out.println("Deserialized value: " + deserialized);
    }
}



