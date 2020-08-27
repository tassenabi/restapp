package com.tassenabi.restapp.data.config.util;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class ApplicationLogger {

    private ApplicationLogger(){

        throw new IllegalStateException("No Instance allowed from ApplicationLogger.class");
    }

    private static Handler formatHandler;
    private static final String FORMAT = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

    public static void loggingQueries(String logInput) {

        Logger jlog = Logger.getLogger("");

        try {

            formatHandler = new FileHandler("info.log", true);

        } catch (IOException e) {

            e.printStackTrace();

        }

        Logger.getLogger("").addHandler(formatHandler);
        SimpleFormatter formatter = new SimpleFormatter() {

            @Override
            public synchronized String format(LogRecord lr) {
                return String.format(FORMAT,
                        new Date(lr.getMillis()),
                        lr.getLevel().getLocalizedName(),
                        lr.getMessage()
                );
            }
        };

        formatHandler.setFormatter(formatter);
        jlog.info(logInput);
        formatHandler.close();
    }
}