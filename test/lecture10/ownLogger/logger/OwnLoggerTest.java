package lecture10.ownLogger.logger;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OwnLoggerTest {
    private OwnLogger logger = new OwnLogger();
    private String path = "logger.txt";
    private List<String> expectedStringArray = new ArrayList<>();
    private List<String> actualStringArray = new ArrayList<>();
    private String string;

    @After
    public void clean() {
        expectedStringArray = new ArrayList<>();
        actualStringArray = new ArrayList<>();
        try (FileWriter out = new FileWriter(path, false)) {
            out.append("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void debug() throws Exception {
        //given
        expectedStringArray.add("Debug");
        expectedStringArray.add("Info");
        expectedStringArray.add("Warning");
        expectedStringArray.add("Error");
        expectedStringArray.add("Fatal");
        ClassToLog c = new DebugLoggerClass();
        //when
        c.log();
        try (BufferedReader in = new BufferedReader(new FileReader(path)))
        {
            while ((string = in.readLine()) != null) {
                actualStringArray.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        Assert.assertEquals("Incorrect log on debug",
                expectedStringArray,
                actualStringArray);
    }

    @Test
    public void infoTest() throws Exception {
        //given
        expectedStringArray.add("Info");
        expectedStringArray.add("Warning");
        expectedStringArray.add("Error");
        expectedStringArray.add("Fatal");
        ClassToLog c = new InfoLoggerClass();
        //when
        c.log();
        try (BufferedReader in = new BufferedReader(new FileReader(path)))
        {
            while ((string = in.readLine()) != null) {
                actualStringArray.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        Assert.assertEquals("Incorrect log on info",
                expectedStringArray,
                actualStringArray);
    }

    @Test
    public void warningTest() throws Exception {
        //given
        expectedStringArray.add("Warning");
        expectedStringArray.add("Error");
        expectedStringArray.add("Fatal");
        ClassToLog c = new WarningLoggerClass();
        //when
        c.log();
        try (BufferedReader in = new BufferedReader(new FileReader(path)))
        {
            while ((string = in.readLine()) != null) {
                actualStringArray.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        Assert.assertEquals("Incorrect log on warning",
                expectedStringArray,
                actualStringArray);
    }

    @Test
    public void errorTest() throws Exception {
        //given
        expectedStringArray.add("Error");
        expectedStringArray.add("Fatal");
        ClassToLog c = new ErrorLoggerClass();
        //when
        c.log();
        try (BufferedReader in = new BufferedReader(new FileReader(path)))
        {
            while ((string = in.readLine()) != null) {
                actualStringArray.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        Assert.assertEquals("Incorrect log on error",
                expectedStringArray,
                actualStringArray);
    }

    @Test
    public void fatal() throws Exception {
        //given
        expectedStringArray.add("Fatal");
        ClassToLog c = new FatalLoggerClass();
        //when
        c.log();
        try (BufferedReader in = new BufferedReader(new FileReader(path)))
        {
            while ((string = in.readLine()) != null) {
                actualStringArray.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //then
        Assert.assertEquals("Incorrect log on fatal",
                expectedStringArray,
                actualStringArray);
    }
}

abstract class ClassToLog {
    OwnLogger logger = new OwnLogger();
    public abstract void log();
    protected void logAll() {
        logger.debug("Debug");
        logger.info("Info");
        logger.warning("Warning");
        logger.error("Error");
        logger.fatal("Fatal");
    }
}

@Info
class InfoLoggerClass extends ClassToLog{
    @Override
    public void log() {
        logger.setClass(this.getClass());
        super.logAll();
    }
}

@Debug
class DebugLoggerClass extends ClassToLog{
    @Override
    public void log() {
        logger.setClass(this.getClass());
        super.logAll();
    }
}

@Warning
class WarningLoggerClass extends ClassToLog {
    @Override
    public void log() {
        logger.setClass(this.getClass());
        super.logAll();
    }
}

@Error
class ErrorLoggerClass extends ClassToLog {
    @Override
    public void log() {
        logger.setClass(this.getClass());
        super.logAll();
    }
}

@Fatal
class FatalLoggerClass extends ClassToLog {
    @Override
    public void log() {
        logger.setClass(this.getClass());
        super.logAll();
    }
}