package tech.codingclub.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileUtility {
    public static boolean createFile(String fileNameWithPath) {
        File file = new File(fileNameWithPath);
        boolean fileCreated = false;
        try {
            fileCreated = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileCreated;
    }

    public static ArrayList<String> readFileAsList(String fileName) {
        Scanner scanner = null;
        ArrayList<String> strings = new ArrayList<String>();
        try {
            File file = new File(fileName);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                strings.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return strings;
    }
    public static boolean writeToFile(String fileNameWithPath, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileNameWithPath);
            fileWriter.append(content);
            fileWriter.close();
        } catch (Exception e) {

        }
        return true;
    }

    public static boolean appendToFile(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.append(content);
            fileWriter.append("\n");
            fileWriter.close();
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("This is Shuchita Singh");
        System.out.println("Running FileUtility at " + new Date().toString());
        String nameOfNewFile = "D:\\SHUCHITA SINGH\\CodingClubJavaProject\\TechCodingMafia\\data\\practice\\file\\create-file.txt";
        Boolean created = createFile(nameOfNewFile);
        System.out.println("File Created : " + created);
        ArrayList<String> stringArrayList = readFileAsList(nameOfNewFile);
        for (String row : stringArrayList) {
            System.out.println("Line : " + row);
        }
        System.out.println("No. of lines in file : " + stringArrayList.size());
        String nameOfWriteFile = "D:\\SHUCHITA SINGH\\CodingClubJavaProject\\TechCodingMafia\\data\\practice\\file\\write-file.txt";
        boolean wroteToFile = writeToFile(nameOfWriteFile, "This file is generated on Shuchita's System automatically.");
        System.out.println(wroteToFile);

        for(int i=1; i<=100; i++) {
            String data = i+"";
            appendToFile(nameOfWriteFile, data);
        }
        System.out.println("Appended file length : " + readFileAsList(nameOfWriteFile).size());
    }
}
