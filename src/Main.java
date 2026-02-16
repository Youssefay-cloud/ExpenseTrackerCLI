import Services.ExpenseTracker;


public class Main {
    public static void main(String[] args) throws Exception {
       if(args.length < 1){
        System.out.println("Please provide (load,add,delete,update,list,Finish)");
        // If you didn't leave it will give you java.lang.ArrayIndexOutOfException
        return;
       }

       ExpenseTracker tracker = new ExpenseTracker();
       String command = args[0].toLowerCase();
       
       tracker.load("Expenses.txt");

       try{
       switch (command) {
        case "add":
            handleAdd(tracker, args);
            tracker.store();
                break; 
        case "update":
            handleUpdate(tracker, args);
            tracker.store();    
                break;
        case "delete":
            handledelete(tracker, args);
            tracker.store();
                break;
        case "list":
            tracker.list();
            break;
        case "summary":
            tracker.summary();
        default:
            break;
       }

       
    }catch(Exception e){
        System.out.println("wrong" + e.getMessage());
        e.printStackTrace();
    }
    }


    private static void handleAdd(ExpenseTracker tracker, String[] args) {
        if(args.length < 4){
            System.out.println("Usage add <id> <desc> <amount>");
            return;
        }

        int id = Integer.parseInt(args[1]);
        String desc = args[2];
        int amount = Integer.parseInt(args[3]);
        tracker.add(id, desc, amount);
    }

    private static void handleUpdate(ExpenseTracker tracker, String[] args){
        if(args.length <4){
            System.out.println("Usage update <id> <desc> <amount>");
            return;
        }

        int id = Integer.parseInt(args[1]);
        String desc = args[2];
        int amount = Integer.parseInt(args[3]);
        tracker.update(id, desc, amount);
    }

    private static void handledelete(ExpenseTracker tracker, String[] args){
        if(args.length < 2){
            System.out.println("Usage delete <id>");
            return;
        }

        int id = Integer.parseInt(args[1]);
        tracker.delete(id);
    }

    
}
