package Storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Model.Expense;

public class JsonStorage {

    private static final String jsonname = "Expens.json";
    Gson gson;

    public List<Expense> loadFromJson(String json) {

        Gson gson = new GsonBuilder().create();

        try (BufferedReader reader = new BufferedReader(new FileReader(jsonname))) {

            Type typelist = new TypeToken<List<Expense>>(){}.getType();

            List<Expense> expenses = gson.fromJson(reader, typelist);

            if (expenses != null) {
                return expenses;
            } else {
                return new ArrayList<>();
            }

        } catch (Exception e) {
            System.out.println("Couldn't load the list : " + e.getMessage());
            return new ArrayList<>();
        }

    }

    public void saveToJson(List<Expense> list) {

        Gson gson = new GsonBuilder().create();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jsonname))) {

            gson.toJson(list, writer);

            System.out.println("The list have been added");
        } catch (IOException e) {
            System.out.println("It wan't added " + e.getMessage());
        }
    }
}
