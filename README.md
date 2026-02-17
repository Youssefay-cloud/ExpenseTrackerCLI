# Project : ExpensesTrackerCLI

## Description

This project is a simple command-line interface (CLI) application for tracking expenses. It allows users to add, update, delete, list, and summarize expenses. The application uses a text file and a JSON file to store and retrieve expense data.

Project URL of RoadMap.sh : https://roadmap.sh/projects/expense-tracker

## Features

- **Add expenses**: Add new expenses with a unique ID, description, and amount.
- **Update expenses**: Update existing expenses by their ID.
- **Delete expenses**: Delete expenses by their ID.
- **List expenses**: List all expenses.
- **Summarize expenses**: Calculate the total amount of all expenses.
- **Store and load data**: Save expenses to a text file and a JSON file, and load them back when the application starts.

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

### Commands

#### Add

```bash
java -cp bin src.Main add <id> <desc> <amount>
```

**Arguments:**
- `<id>`: The ID of the expense (integer).
- `<desc>`: The description of the expense (string).
- `<amount>`: The amount of the expense (integer).

**Example:**
```bash
java -cp bin src.Main add 1 "Groceries" 50
```

#### Update

```bash
java -cp bin src.Main update <id> <desc> <amount>
```

**Arguments:**
- `<id>`: The ID of the expense to update (integer).
- `<desc>`: The new description of the expense (string).
- `<amount>`: The new amount of the expense (integer).

**Example:**
```bash
java -cp bin src.Main update 1 "Groceries" 75
```

#### Delete

```bash
java -cp bin src.Main delete <id>
```

**Arguments:**
- `<id>`: The ID of the expense to delete (integer).

**Example:**
```bash
java -cp bin src.Main delete 1
```

#### List

```bash
java -cp bin src.Main list
```

#### Summary

```bash
java -cp bin src.Main summary
```

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
│   └── gson-2.12.1.jar
└── README.md
```

## Dependencies

- **Gson**: For JSON serialization and deserialization.
  - Version: 2.12.1
  - Location: `lib/gson-2.12.1.jar`

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
