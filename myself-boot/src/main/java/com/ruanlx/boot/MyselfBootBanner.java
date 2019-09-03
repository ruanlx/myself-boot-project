package com.ruanlx.boot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @author ruanlx
 * @ClassName MyselfBootBanner
 * @DateTime 2019/9/1 3:50
 * @Version 1.0
 */
public class MyselfBootBanner implements Banner {

    private static final String[] BANNER = {"  __  __                        _    __           ____                    _             ____                            _        \n" +
            " |  \\/  |  _   _   ___    ___  | |  / _|         | __ )    ___     ___   | |_          |  _ \\   _   _    __ _   _ __   | | __  __\n" +
            " | |\\/| | | | | | / __|  / _ \\ | | | |_   _____  |  _ \\   / _ \\   / _ \\  | __|  _____  | |_) | | | | |  / _` | | '_ \\  | | \\ \\/ /\n" +
            " | |  | | | |_| | \\__ \\ |  __/ | | |  _| |_____| | |_) | | (_) | | (_) | | |_  |_____| |  _ <  | |_| | | (_| | | | | | | |  >  < \n" +
            " |_|  |_|  \\__, | |___/  \\___| |_| |_|           |____/   \\___/   \\___/   \\__|         |_| \\_\\  \\__,_|  \\__,_| |_| |_| |_| /_/\\_\\\n" +
            "           |___/                                                                                                                 "};

    private static final String SPRING_BOOT = " :: Spring Boot :: ";

    private static final int STRAP_LINE_SIZE = 42;

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {
        for (String line : BANNER) {
            printStream.println(line);
        }
        String version = SpringBootVersion.getVersion();
        version = (version != null) ? " (v" + version + ")" : "";
        StringBuilder padding = new StringBuilder();
        while (padding.length() < STRAP_LINE_SIZE - (version.length() + SPRING_BOOT.length())) {
            padding.append(" ");
        }

        printStream.println(AnsiOutput.toString(AnsiColor.GREEN, SPRING_BOOT, AnsiColor.DEFAULT, padding.toString(), AnsiStyle.FAINT, version));
        printStream.println();
    }
}
