# Project : ExpensesTrackerCLI
    
## Description

This is a learning project for me to practice my Java skills. It is a simple command-line interface (CLI) application for tracking expenses. It allows users to add, update, delete, list, and summarize expenses. The application uses a text file and a JSON file to store and retrieve expense data.

## Features

- **Add expenses**: Add new expenses with a unique ID, description, and amount.
- **Update expenses**: Update existing expenses by their ID.
- **Delete expenses**: Delete expenses by their ID.
- **List expenses**: List all expenses.
- **Summarize expenses**: Calculate the total amount of all expenses.
- **Store and load data**: Save expenses to a text file and a JSON file, and load them back when the application starts.

## Technologies Used

- Java — Core language
- Gson — JSON serialization/deserialization
- File I/O — BufferedReader/BufferedWriter for text and JSON storage

## What I Learned

- Object-Oriented Programming (encapsulation, separation of concerns)
- Command-line argument parsing
- File I/O with both plain text and JSON formats
- Using external libraries (Gson) in Java
- Avoiding ConcurrentModificationException with iterators


## Usage

### Running the application

To run the application, use the following command:

```bash
java -cp bin src.Main <command> [arguments]
```

Replace `<command>` with one of the following:

- `add`: Add a new expense.
- `update`: Update an existing expense.
- `delete`: Delete an expense.
- `list`: List all expenses.
- `summary`: Show the total amount of all expenses.



## File Structure

```
ExpensesTrackerCLI/
├── src/
│   ├── Model/
│   │   └── Expense.java
│   ├── Services/
│   │   └── ExpenseTracker.java
│   ├── Storage/
│   │   ├── ExpenseStorage.java
│   │   └── JsonStorage.java
│   ├── Main.java
│   ├── Expenses.txt
│   └── Expens.json
├── bin/
│   ├── Model/
│   ├── Services/
│   ├── Storage/
│   └── Main.class
├── lib/
│   └── gson-2.10.1.jar
└── README.md
```

## Dependencies

- **Gson**: For JSON serialization and deserialization.
  - Version: 2.10.1
  - Location: `lib/gson-2.10.1.jar`

## How it works

1. **Loading data**: When the application starts, it loads expenses from `Expenses.txt` and `Expens.json` files.
2. **Performing operations**: The application performs the requested operation (add, update, delete, list, or summary).
3. **Saving data**: After each operation, the application saves the updated list of expenses to both `Expenses.txt` and `Expens.json` files.

## Notes

- The application uses a simple text file format for storing expenses:
  ```
  id,description,amount
  ```
- The application uses JSON format for storing expenses:
  ```json
  [
    {
      "id": 1,
      "desc": "Groceries",
      "amount": 50
    }
  ]
  ```
- The application uses a simple command-line interface for user interaction.
- The application uses a simple command-line interface for user interaction.

**How to run**
```bash
java -cp bin src.Main <command> [arguments]
```

**How to build**
```bash
javac -d bin src/Main.java src/Model/Expense.java src/Services/ExpenseTracker.java src/Storage/ExpenseStorage.java src/Storage/JsonStorage.java
```
