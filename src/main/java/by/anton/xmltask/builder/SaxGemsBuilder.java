package by.anton.xmltask.builder;

import by.anton.xmltask.exception.GemEntityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxGemsBuilder extends AbstractGemsBuilder {
    private GemsHandler gemsHandler;
    private XMLReader xmlReader;
    private static final Logger logger = LogManager.getLogger();

    SaxGemsBuilder() throws GemEntityException {
        gemsHandler = new GemsHandler();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(gemsHandler);
            xmlReader.setErrorHandler(new ErrorGemsHandler());
        } catch (ParserConfigurationException | SAXException e) {
            throw new GemEntityException("Configuration parser - fail", e);
        }
    }


    @Override
    public void buildGems(String pathXML) throws GemEntityException {
        logger.info("Method to build gems from " + SaxGemsBuilder.class + " called with path parameters: " + pathXML);
        try {
            xmlReader.parse(pathXML);
        } catch (IOException | SAXException e) {
            throw new GemEntityException("Impossible to parse Xml file", e);
        }
        abstractGems = gemsHandler.getGems();
    }
}
