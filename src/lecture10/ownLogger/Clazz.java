package lecture10.ownLogger;

import lecture10.ownLogger.logger.Error;
import lecture10.ownLogger.logger.OwnLogger;

@Error
public class Clazz {
    OwnLogger ownLogger = new OwnLogger(this.getClass(), "logger.txt");

    public void doSmth() {
        ownLogger.debug("Debug msg");
        ownLogger.info("Info msg");
        ownLogger.warning("Warning msg");
        ownLogger.error("Error msg");
        ownLogger.fatal("Fatal msg");
    }

}
