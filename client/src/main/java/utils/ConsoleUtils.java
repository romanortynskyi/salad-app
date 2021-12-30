package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleUtils {
    public static void write(Object o) {
        System.out.print(o);
    }

    public static void writeLine(Object o) {
        System.out.println(o);
    }

    public static String readLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        return line;
    }
}
