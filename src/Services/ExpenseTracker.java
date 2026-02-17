package Services;

import java.time.LocalTime;
import java.util.*;

import Model.Expense;
import Storage.ExpenseStorage;
import Storage.JsonStorage;

public class ExpenseTracker {
    private List<Expense> expenseslist;
    private List<String> jsonlist;
    private ExpenseStorage es;
    private JsonStorage js;

    public ExpenseTracker() {
        expenseslist = new ArrayList<>();
        es = new ExpenseStorage();
        js = new JsonStorage();
    }

    public void add(int id, String desc, int amount) {
        // 1. Check for duplicates safely
        for (Expense e : expenseslist) {
            if (e.getId() == id) {
                System.out.println("Error: Expense with ID " + id + " already exists.");
                return; // Exit the method early; don't add!
            }
        }

        // 2. If the loop finishes and we didn't 'return', it's safe to add
        Expense newExpense = new Expense(id, desc, amount);
        expenseslist.add(newExpense);
        System.out.println("Expense added successfully!");
    }

    public void update(int id, String desc, int amount) {
        boolean found = false;
        for (Expense e : expenseslist) {
            if (e.getId() == id) {
                e.setDesc(desc);
                e.setAmount(amount);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Expense ID " + id + "not found");
        }
    }

    // Can't use for-each loop because it is using internal iterator
    // and this will cause the system to crash if we change the
    // size of the list while still inside it
    public void delete(int id) {
        // Use a standard loop to avoid ConcurrentModificationException
        boolean found = false;
        for (int i = 0; i < expenseslist.size(); i++) {
            // Look at the ID of the expense at the current position
            if (expenseslist.get(i).getId() == id) {
                expenseslist.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Expense ID " + id + "not found");
        }
    }

    public void Deletee(int id) {
        Iterator<Expense> it = expenseslist.iterator();

        boolean found = false;

        while (it.hasNext()) {
            Expense e = it.next();
            if (e.getId() == id) {
                it.remove();
                found = true;
                System.out.println("Found it " + id);
                break;
            } else {
                System.out.println("Nothing!!!!");
            }
        }
    }

    public void list() {
        for (Expense e : expenseslist) {
            System.out.println(e);
        }
    }

    public void summary() {
        int total = expenseslist.stream()
                .mapToInt(Expense::getAmount)
                .sum();
        System.out.println(total);

        /*
         * The way you was searching about is
         * int total ;
         * for(int i = 0 ; i < expenseslist.size() ; i++){
         * total += expenseslist.get(i).getamount();
         * }
         * sysoout(total)
         */
    }

    public void store() {
        if (expenseslist.isEmpty()) {
            System.out.println("NOTHING HERE!!");
            return;
        }
        es.saveToFile(expenseslist);

    }

    public void load(String filename) {
        try {
            List<Expense> loaded = es.loadFromFile(filename);
            expenseslist.addAll(loaded);
        } catch (Exception e) {
            System.out.println("Coudn't load the file");
        }
    }

    public void loadJson(String Jsonname) {
        try {
            List<Expense> loaded = js.loadFromJson(Jsonname);
            expenseslist.addAll(loaded);
        } catch (Exception e) {
            System.out.println("Couldn't load!!!!!");
        }
    }

    public void storeJson() {
        try {
            js.saveToJson(expenseslist);
        } catch (Exception e) {
            System.out.println("Coudn't save!!!!!");
        }

    }

}
