package by.anton.xmltask.builder;

import by.anton.xmltask.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.YearMonth;
import java.util.ArrayList;

public class GemsHandler extends DefaultHandler {

    private String currentElement;
    private ArrayList<AbstractGem> abstractGems;
    private AbstractGem currentGem;
    private static final Logger logger = LogManager.getLogger();

    public GemsHandler() {
        abstractGems = new ArrayList<>();
    }

    public ArrayList<AbstractGem> getGems() {
        return abstractGems;
    }

    @Override
    public void startDocument() throws SAXException {
        logger.info("Gems handler starts work");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        final String DEFAULT_UNIQUENESS = "rare";
        switch (GemXMLTag.valueOf(currentElement.toUpperCase())) {
            case PRECIOUS: {
                currentGem = new PreciousGem();
                currentGem.setId(attributes.getValue(GemXMLAttribute.ID.getValue()));
                String uniqueness = attributes.getValue(GemXMLAttribute.UNIQUENESS.getValue());
                if (uniqueness != null) {
                    currentGem.setUniqueness(uniqueness);
                } else {
                    currentGem.setUniqueness(DEFAULT_UNIQUENESS);
                }
                break;
            }
            case SEMIPRECIOUS: {
                currentGem = new SemipreciousGem();
                currentGem.setId(attributes.getValue(GemXMLAttribute.ID.getValue()));
                String uniqueness = attributes.getValue(GemXMLAttribute.UNIQUENESS.getValue());
                if (uniqueness != null) {
                    currentGem.setUniqueness(uniqueness);
                } else {
                    currentGem.setUniqueness(DEFAULT_UNIQUENESS);
                }
                break;
            }
            default: {
                // do nothing;
            }
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        if (text.contains("<") || currentElement == null) {
            return;
        }

        switch (GemXMLTag.valueOf(currentElement.toUpperCase())) {
            case NAME -> currentGem.setName(text);
            case ORIGIN -> currentGem.setGemOrigin(GemOrigin.valueOf(text.toUpperCase()));
            case VALUE -> currentGem.setValue(Integer.parseInt(text));
            case TIMEOFEXTRACTION -> currentGem.setTimeOfExtraction(YearMonth.parse(text));
            case HARDNESS -> currentGem.setHardness(Integer.parseInt(text));
            case COLOR -> {
                if (currentGem instanceof PreciousGem) {
                    PreciousGem gem = (PreciousGem) currentGem;
                    gem.setGemColor(GemColor.valueOf(text.toUpperCase()));
                } else {
                    SemipreciousGem gem = (SemipreciousGem) currentGem;
                    gem.setGemColor(GemColor.valueOf(text.toUpperCase()));
                }
            }
            case TRANSPARENCY -> {
                if (currentGem instanceof PreciousGem) {
                    PreciousGem gem = (PreciousGem) currentGem;
                    gem.setTransparency(Integer.parseInt(text));
                } else {
                    SemipreciousGem gem = (SemipreciousGem) currentGem;
                    gem.setTransparency(Integer.parseInt(text));
                }
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (GemXMLTag.valueOf(qName.toUpperCase())) {
            case PRECIOUS -> {
                abstractGems.add(currentGem);
                currentGem = null;
            }
            case SEMIPRECIOUS -> {
                abstractGems.add(currentGem);
                currentGem = null;
            }
        }
        currentElement = null;
    }

    @Override
    public void endDocument() throws SAXException {
        logger.info("GemsHandler finish work");
    }

}
