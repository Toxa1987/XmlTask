package by.anton.xmltask.builder;

import by.anton.xmltask.entity.*;
import by.anton.xmltask.exception.GemEntityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.YearMonth;

public class DomGemsBuilder extends AbstractGemsBuilder {
    private DocumentBuilder documentBuilder;
    private static final Logger logger = LogManager.getLogger();

    public DomGemsBuilder() throws GemEntityException {
        super();
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new GemEntityException("Configuration parser - fail", e);
        }
    }

    @Override
    public void buildGems(String pathXML) throws GemEntityException {
        logger.info("Method to build gems from " + DomGemsBuilder.class + " called with path parameters: " + pathXML);
        Document document;
        final String DEFAULT_UNIQUENESS = "rare";

        try {
            document = documentBuilder.parse(pathXML);
            Element root = document.getDocumentElement();

            String preciousXmlTag = GemXMLTag.PRECIOUS.getValue();
            String semiPreciousXmlTag = GemXMLTag.SEMIPRECIOUS.getValue();

            NodeList preciousGems = root.getElementsByTagName(preciousXmlTag);
            NodeList semiPreciousGems = root.getElementsByTagName(semiPreciousXmlTag);

            for (int i = 0; i < preciousGems.getLength(); i++) {
                Node node = preciousGems.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    AbstractGem gem = new PreciousGem();
                    Element element = (Element) node;
                    gem.setId(element.getAttribute(GemXMLAttribute.ID.getValue()));
                    String uniqueness = element.getAttribute(GemXMLAttribute.UNIQUENESS.getValue());
                    if (!uniqueness.isEmpty()) {
                        gem.setUniqueness(uniqueness);
                    } else {
                        gem.setUniqueness(DEFAULT_UNIQUENESS);
                    }
                    gem.setName(element.getElementsByTagName(GemXMLTag.NAME.getValue()).item(0).getTextContent());
                    gem.setGemOrigin(GemOrigin.valueOf(element.getElementsByTagName(GemXMLTag.ORIGIN.getValue()).item(0).getTextContent().toUpperCase()));
                    gem.setHardness(Integer.parseInt(element.getElementsByTagName(GemXMLTag.HARDNESS.getValue()).item(0).getTextContent()));
                    gem.setValue(Integer.parseInt(element.getElementsByTagName(GemXMLTag.VALUE.getValue()).item(0).getTextContent()));
                    gem.setTimeOfExtraction(YearMonth.parse(element.getElementsByTagName(GemXMLTag.TIMEOFEXTRACTION.getValue()).item(0).getTextContent()));
                    NodeList visualElements = element.getElementsByTagName(GemXMLTag.VISUALPARAMETERS.getValue());
                    for (int j = 0; j < visualElements.getLength(); j++) {
                        Element innerElement = (Element) visualElements.item(j);
                        PreciousGem preciousGem = (PreciousGem) gem;
                        preciousGem.setGemColor(GemColor.valueOf(innerElement.getElementsByTagName(GemXMLTag.COLOR.getValue()).item(0).getTextContent().toUpperCase()));
                        preciousGem.setTransparency(Integer.parseInt(innerElement.getElementsByTagName(GemXMLTag.TRANSPARENCY.getValue()).item(0).getTextContent()));
                    }
                    abstractGems.add(gem);
                }
            }
            for (int i = 0; i < semiPreciousGems.getLength(); i++) {
                Node node = semiPreciousGems.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    AbstractGem gem = new SemipreciousGem();
                    Element element = (Element) node;
                    gem.setId(element.getAttribute(GemXMLAttribute.ID.getValue()));
                    String uniqueness = element.getAttribute(GemXMLAttribute.UNIQUENESS.getValue());
                    if (!uniqueness.isEmpty()) {
                        gem.setUniqueness(uniqueness);
                    } else {
                        gem.setUniqueness(DEFAULT_UNIQUENESS);
                    }
                    gem.setName(element.getElementsByTagName(GemXMLTag.NAME.getValue()).item(0).getTextContent());
                    gem.setGemOrigin(GemOrigin.valueOf(element.getElementsByTagName(GemXMLTag.ORIGIN.getValue()).item(0).getTextContent().toUpperCase()));
                    gem.setHardness(Integer.parseInt(element.getElementsByTagName(GemXMLTag.HARDNESS.getValue()).item(0).getTextContent()));
                    gem.setValue(Integer.parseInt(element.getElementsByTagName(GemXMLTag.VALUE.getValue()).item(0).getTextContent()));
                    gem.setTimeOfExtraction(YearMonth.parse(element.getElementsByTagName(GemXMLTag.TIMEOFEXTRACTION.getValue()).item(0).getTextContent()));
                    NodeList visualElements = element.getElementsByTagName(GemXMLTag.VISUALPARAMETERS.getValue());
                    for (int j = 0; j < visualElements.getLength(); j++) {
                        Element innerElement = (Element) visualElements.item(j);
                        SemipreciousGem semipreciousGem = (SemipreciousGem) gem;
                        semipreciousGem.setGemColor(GemColor.valueOf(innerElement.getElementsByTagName(GemXMLTag.COLOR.getValue()).item(0).getTextContent().toUpperCase()));
                        semipreciousGem.setTransparency(Integer.parseInt(innerElement.getElementsByTagName(GemXMLTag.TRANSPARENCY.getValue()).item(0).getTextContent()));
                    }
                    abstractGems.add(gem);
                }
            }
        } catch (SAXException | IOException e) {
            throw new GemEntityException("Impossible to parse Xml file", e);
        }
    }
}
