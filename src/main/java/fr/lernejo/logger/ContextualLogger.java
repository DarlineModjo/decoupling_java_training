package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private ContextualLogger delegateLogger;

    @Override
    public void log(String message) {
        LocalDateTime CurrentDate = LocalDateTime.now();
        System.out.println("Date courante : " + CurrentDate);
        DateTimeFormatter FormatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        DateTimeFormatter formatter = null;
        String callerClass = null;
        this.delegateLogger.log(LocalDateTime.now().format(formatter) + " " + callerClass + " " + message);



        //this.logger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern(yyyy-MM-dd HH:mm:ss.SSS)) + " " + this.name + " " + message);

    }
}
