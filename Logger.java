package cpit252_lab2;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Logger {

    private static final DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
    private static final String currentDateTimeString = LocalDateTime.now().format(myFormatter);
    private static final String logFile = currentDateTimeString + ".txt";
    private static Logger instance = null;

    private static PrintWriter writer;

    public static Logger log() {
        try {
            if (instance == null) {
                FileWriter fw = new FileWriter(logFile);
                writer = new PrintWriter(fw, true);
                instance = new Logger();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return instance;
    }

    public void info(String message) {
        writer.println("INFO: " + message);
    }

    public void error(String message) {
        writer.println("Error: " + message);
    }
}
