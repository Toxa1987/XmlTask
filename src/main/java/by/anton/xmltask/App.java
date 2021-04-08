package by.anton.xmltask;

import by.anton.xmltask.builder.DomGemsBuilder;
import by.anton.xmltask.builder.GemsBuilder;
import by.anton.xmltask.builder.GemsHandler;
import by.anton.xmltask.builder.SaxGemsBuilder;
import by.anton.xmltask.entity.*;
import by.anton.xmltask.exception.GemEntityException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App {
    public static ArrayList<AbstractGem> arrayList = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, GemEntityException {
        String path="./src/main/resources/gems.xml";
        SaxGemsBuilder saxGemsBuilder = (SaxGemsBuilder) GemsBuilder.createGemsBuilder("Sax");
        saxGemsBuilder.buildGems(path);
        arrayList=saxGemsBuilder.getAbstractGems();
        arrayList.forEach(System.out::println);
    }
}