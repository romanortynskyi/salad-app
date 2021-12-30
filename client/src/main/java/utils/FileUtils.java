package utils;

import java.io.*;

public class FileUtils {
    public static String readAllText(String path) throws IOException, FileNotFoundException {
        BufferedReader objReader = null;
        StringBuilder sb = new StringBuilder();

        String line;

        objReader = new BufferedReader(new FileReader(path));
        while ((line = objReader.readLine()) != null) {
            sb.append(line);
        }
        try {
            if (objReader != null) objReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }

    public static void writeAllText(String path, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(text);
        writer.close();
    }
}
