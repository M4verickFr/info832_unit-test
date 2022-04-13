package test.discrete_behavior_simulator;

import main.discrete_behavior_simulator.LogFormatter;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LogFormatterTest {

    private final LogFormatter logFormatter = new LogFormatter();

    /*
    Entrée : format(rec)
    Description : Test de format
    Résultat Attendu : Message du buffer
     */
    @Test
    void LF1_format() {
        LogRecord logRecord = new LogRecord(Level.INFO, "This is a test message");


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SS");
        String resultDate = dateFormat.format(new Date(logRecord.getMillis()));

        assertEquals(resultDate + ": INFO\nThis is a test message\n", logFormatter.format(logRecord));
    }

    /*
    Entrée : getHead(h)
    Description : Test de getHead
    Résultat Attendu : ""
     */
    @Test
    void LF3_getHead() {
        assertEquals("", logFormatter.getHead(new ConsoleHandler()));
    }

    /*
    Entrée : getTail(h)
    Description : Test de getTail
    Résultat Attendu : ""
     */
    @Test
    void LF4_getTail() {
        assertEquals("", logFormatter.getTail(new ConsoleHandler()));
    }
}