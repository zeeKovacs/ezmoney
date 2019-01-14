package com.gambling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler {

    public String[] Read(String file) {
        String[] data = new String[fileLines(file)];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                data = br.readLine().split(",");              
            }
            return data;

        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return null;
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
            return null;
        }
    }

    public void Write(String file,String[] itemsToWrite) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String item : itemsToWrite) {
                if (item != null) {
                    bw.write(item);
                }
            }
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
        }
    }

    public int fileLines(String file) {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                br.readLine();
                i++;
            }
            return i;
        } catch (FileNotFoundException f) {
            System.out.println("File not found!");
            return 0;
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
            return 0;
        }
    }
}