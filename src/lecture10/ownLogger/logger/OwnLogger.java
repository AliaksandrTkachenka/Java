package lecture10.ownLogger.logger;

import java.io.FileWriter;
import java.io.IOException;

public class OwnLogger {
    private static final int DEBUG = 1;
    private static final int INFO = 2;
    private static final int WARNING = 3;
    private static final int ERROR = 4;
    private static final int FATAl = 5;
    private static final String DEFAULT_PATH = "logger.txt";

    private int level;
    private Class c;
    private String path;

    public OwnLogger(Class c, String path) {
        this.path = path;
        this.c = c;
    }

    public OwnLogger() {
        this.path = DEFAULT_PATH;
    }

    public void setClass(Class c) {
        this.c = c;
    }

    public OwnLogger debug(String message) {
        checkAndLog(DEBUG, message);
        return this;
    }

    public OwnLogger info(String message) {
        checkAndLog(INFO, message);
        return this;
    }

    public OwnLogger warning(String message) {
        checkAndLog(WARNING, message);
        return this;
    }

    public OwnLogger error(String message) {
        checkAndLog(ERROR, message);
        return this;
    }

    public OwnLogger fatal(String message) {
        checkAndLog(FATAl, message);
        return this;
    }

    private void checkAndLog(int levelOut, String message) {
        if(checkAnnotation()) {
            if (level <= levelOut) {
                log(message);
            }
        }
    }

    private void log(String message) {
        try (FileWriter out = new FileWriter(path, true)) {
            out.append(message).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkAnnotation() {
        if(c.isAnnotationPresent(Debug.class)) {
            level = DEBUG;
        } else if(c.isAnnotationPresent(Info.class)) {
            level = INFO;
        } else if(c.isAnnotationPresent(Warning.class)) {
            level = WARNING;
        } else if(c.isAnnotationPresent(Error.class)) {
            level = ERROR;
        } else if(c.isAnnotationPresent(Fatal.class)) {
            level = FATAl;
        }
        if(level > 0) {
            return true;
        }
        return false;
    }
}
