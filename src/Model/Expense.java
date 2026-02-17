package Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Expense{
    private int id ;
    private String desc;
    private int amount ;
    
    public Expense(int id, String desc, int amount) {
        this.id = id;
        this.desc = desc;
        this.amount = amount;
        
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Expense [ id = " + id + ", desc = " + desc + ", amount = " + amount + " ] ";
    }

    
}