package by.anton.xmltask.builder;

import by.anton.xmltask.exception.GemEntityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GemsBuilder {
    private static final Logger logger = LogManager.getLogger();

    private enum ParserType {
        DOM, SAX, STAX
    }

    public static AbstractGemsBuilder createGemsBuilder(String parserType) throws GemEntityException {
        logger.info("Method to create Gems Builder called with parser type parameters: " + parserType);
        try {
            ParserType type = ParserType.valueOf(parserType.toUpperCase());
            AbstractGemsBuilder abstractGemsBuilder = null;
            if (type.equals(ParserType.DOM)) {
                abstractGemsBuilder = new DomGemsBuilder();
            }
            if (type.equals(ParserType.SAX)) {
                abstractGemsBuilder = new SaxGemsBuilder();
            }
            if (type.equals(ParserType.STAX)) {
                abstractGemsBuilder = new StaxGemsBuilder();
            }
            return abstractGemsBuilder;
        } catch (IllegalArgumentException e) {
            logger.error("Parser " + parserType + ": not found");
            throw new GemEntityException("Parser " + parserType + ": not found", e);
        }
    }


}
