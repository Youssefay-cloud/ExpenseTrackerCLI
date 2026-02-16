package Storage;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import Model.Expense;

public class ExpenseStorage {
   
    private static final String fileName = "Expenses.txt";

    public void saveToFile(List<Expense> list){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for(Expense e : list){
                writer.write(e.getId()+","+e.getDesc() + ","+ e.getAmount());
                writer.newLine();
            }
            // Try-with-resources close it automatically we shouldn't put this here.
            // writer.close();
        } catch (Exception e) {
            System.out.println("We couldn't save the list : " + e.getMessage());
        }
    }

    public List<Expense> loadFromFile(String filename){
        List<Expense> loaded = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line ;
            while((line = reader.readLine()) != null){
              // System.out.println(line); // It Just print the lines not parsing it
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String desc = parts[1];
                int amount = Integer.parseInt(parts[2]);
                Expense e = new Expense(id, desc, amount);
                loaded.add(e);
            }
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
        return loaded ;
    }
}
