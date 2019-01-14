package com.gambling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler {

    public String[][] Read(String file) { 

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[][] data = new String[0][0];
            while (br.ready()) {
                int numOfLines = fileLines(file);
                int numOfFields = fileCols(file);
                
                data = new String[numOfLines][numOfFields];
                for (int i = 0; i < numOfLines; i++) {
                    data[i] = br.readLine().split(",");
                }
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

    public int fileCols(String file) {
        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String countFieldString = br.readLine();
            i = countFieldString.length() - countFieldString.replace(",", "").length() + 1;
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