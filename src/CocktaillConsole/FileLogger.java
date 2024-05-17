package CocktaillConsole;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileLogger implements Logger {
    private String logFilePath;

    public FileLogger(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    @Override
    public void log(String message) {
        try (FileWriter fw = new FileWriter(logFilePath, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void clearLog() {
        try (FileWriter fw = new FileWriter(logFilePath, false); // فتح الملف بوضع الكتابة بدون الإلحاق
             PrintWriter pw = new PrintWriter(fw)) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

