package com.gambling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler {

    public String[] Read(String file) {
        String[] data = new String[8];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()) {
                String[] data = br.readLine().split(",");              
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

    public void Write(String file,String[] itemToWrite) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String item : itemToWrite) {
                if (record != null) {
                    bw.write(record.toWrite());
                }
            }
        } catch (IOException e) {
            System.out.println("IO Exception occured!");
        }
    }
}