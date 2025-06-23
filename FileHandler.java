import java.io.*;
import java.util.*;

public class FileHandler {
    public static ArrayList<String> loadList(String filename) {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            // file not found is ok for fresh start
        }
        return list;
    }

    public static void saveList(List<String> list, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : list) {
                writer.write(item);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static String[] loadArray(String filename, int maxSize) {
        String[] array = new String[maxSize];
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null && index < maxSize) {
                array[index++] = line;
            }
        } catch (IOException e) {
            // file not found is ok
        }
        return array;
    }

    public static void saveArray(String[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String item : array) {
                if (item != null) {
                    writer.write(item);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving array: " + e.getMessage());
        }
    }
}