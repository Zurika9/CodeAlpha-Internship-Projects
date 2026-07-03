Here is a **complete, professional README.md** for your **CodeAlpha Task 2: Stock Trading Platform**. You can directly copy-paste this into your GitHub repository.

---

# 📈 Stock Trading Platform (Java OOP Project)

## 🧾 Project Overview

The **Stock Trading Platform** is a console-based Java application that simulates a real-world stock market environment. It allows users to view market stocks, buy and sell shares, and track their portfolio performance over time.

This project is developed as part of the **CodeAlpha Java Programming Internship – Task 2** and demonstrates strong Object-Oriented Programming (OOP) principles.

---

## 🎯 Features

* 📊 View available market stocks
* 💰 Buy stocks based on available balance
* 📉 Sell owned stocks
* 📂 Track portfolio holdings
* 🔄 Simulate stock market price changes
* 🔍 Search stocks by symbol
* 📈 Real-time-like market simulation (random price updates)

---

## 🏗️ Project Structure

```
StockTradingPlatform/
│
├── src/
│   ├── Main.java
│   ├── Stock.java
│   ├── Market.java
│   ├── User.java
│   ├── Portfolio.java
│   └── Transaction.java
│
├── README.md
└── .gitignore
```

---

## 🧠 OOP Concepts Used

This project strongly focuses on core Java OOP principles:

* ✅ Encapsulation (private variables, getters/setters)
* ✅ Abstraction (separating logic into classes)
* ✅ Composition (Market contains Stock objects)
* ✅ Object Interaction (User ↔ Portfolio ↔ Market)
* ✅ Constructor usage
* ✅ Method overriding (`toString()`)

---

## 📌 Step 2: Stock Class

### 🔹 Purpose

Represents an individual stock in the market.

### 🔹 Key Features

* Stores stock symbol, company name, and price
* Provides methods to update price
* Displays stock information
* Supports price fluctuation simulation

### 🔹 Example Output

```
TCS | Tata Consultancy Services | ₹3500.0
```

---

## 📌 Step 3: Market Class

### 🔹 Purpose

Simulates a stock exchange containing multiple stocks.

### 🔹 Key Features

* Stores list of stocks
* Displays market data in tabular format
* Searches stock by symbol
* Simulates random market price changes

### 🔹 Core Methods

* `displayMarket()` → Shows all stocks
* `getStockBySymbol()` → Finds stock for trading
* `updateMarketPrices()` → Simulates live market changes

### 🔹 Example Output

```
===== STOCK MARKET =====
SYMBOL | COMPANY | PRICE
-----------------------------
TCS     Tata Consultancy Services   ₹3500
INFY    Infosys                    ₹1600
WIPRO   Wipro                     ₹500
```

---

## 🔄 How the System Works

```
Start Program
   ↓
Display Market Stocks
   ↓
User Buys/Sells Stocks
   ↓
Portfolio Updates
   ↓
Transaction Recorded
   ↓
Balance Updated
   ↓
Exit Program
```

---

## 💡 Future Enhancements

* 🧾 Transaction history tracking
* 💾 File handling for data persistence
* 🗄️ Database integration (MySQL)
* 📊 Profit/Loss calculation
* 👥 Multi-user system
* 📱 GUI-based interface (JavaFX / Swing)

---

## 📌 Step 4: Portfolio Class

### 🔹 Purpose
The `Portfolio` class manages the stocks owned by a user. It keeps track of stock holdings and supports buying and selling operations.

### 🔹 Features
- Stores stock holdings using a `HashMap`
- Buy stocks and update quantities
- Sell stocks with quantity validation
- Automatically removes stocks when all shares are sold
- Display current portfolio holdings

### 🔹 Key Methods
- `buyStock(String symbol, int quantity)`
- `sellStock(String symbol, int quantity)`
- `getQuantity(String symbol)`
- `displayPortfolio()`

### 🔹 Java Concepts Used
- HashMap
- Collections Framework
- Encapsulation
- Business Logic

## 📌 Step 5: User Class

### Purpose
The `User` class represents a trader in the stock trading platform. It manages the user's wallet balance, portfolio, and trading operations.

### Features
- Stores user details
- Tracks wallet balance
- Buys stocks after balance validation
- Sells stocks after ownership validation
- Integrates with the `Portfolio` class

### Java Concepts Used
- Object composition
- Business logic implementation
- Encapsulation

---

## 📌 Step 6: Transaction Class

### Purpose

The `Transaction` class records every stock purchase and sale performed by the user.

### Features

- Stores transaction type (BUY/SELL)
- Records stock symbol
- Stores quantity purchased or sold
- Calculates total transaction amount
- Saves transaction timestamp
- Displays transaction details in a formatted manner

### Java Concepts Used

- LocalDateTime
- DateTimeFormatter
- Encapsulation
- Object-Oriented Design

## 🛠️ Technologies Used

* Java (JDK 25+)
* Object-Oriented Programming (OOP)
* Collections Framework (ArrayList, HashMap)
* Console-based UI
* File Handling (optional extension)

---


## 📌 Step 6B: Transaction History

### Features
- Records every BUY operation
- Records every SELL operation
- Stores transaction timestamp
- Displays complete trading history

### Java Concepts Used
- ArrayList
- Object Composition
- Java Time API
- Enhanced for loop

## 📌 Step 7: Interactive Console Menu

### Purpose

The application now provides an interactive menu-driven interface, allowing users to perform stock trading operations without modifying the source code.

### Features

- View market stocks
- Buy stocks
- Sell stocks
- View portfolio
- Check wallet balance
- View transaction history
- Simulate market price updates
- Exit application safely

### Java Concepts Used

- Scanner class
- Switch-case statements
- Looping (`do-while`)
- Method decomposition

## 📌 Step 8: File Persistence

### Purpose
The application now saves the user's portfolio to a file, allowing data to persist between program executions.

### Features
- Save portfolio to a text file
- Load portfolio automatically on startup
- Create the data folder if it doesn't exist
- Handle file-related exceptions

### Java Concepts Used
- File I/O
- FileWriter
- Scanner
- Exception Handling
- Static Utility Methods

## 📌 Step 8B: Portfolio Persistence

### Features

- Automatically loads portfolio when the application starts
- Automatically saves portfolio before exiting
- Stores portfolio data in `data/portfolio.txt`
- Uses Java File I/O for persistent storage

### Java Concepts Used

- File handling
- Exception handling
- Static utility methods


## 📌 Step 9: Transaction Persistence

### Features

- Saves complete transaction history
- Loads transaction history on startup
- Preserves timestamps
- Uses LocalDateTime for accurate records

### Java Concepts Used

- File I/O
- LocalDateTime
- Object Serialization (manual text format)
- Collections

## 📌 Step 10: Portfolio Performance

### Features

- Calculates current portfolio value
- Calculates total investment
- Displays overall profit or loss
- Uses live market prices for valuation

### Java Concepts Used

- HashMap
- Nested loops
- Aggregation
- Financial calculations

## 📌 Step 11A: Input Validation

### Purpose

Improved the application's robustness by validating user input and handling invalid entries gracefully.

### Features

- Prevents crashes caused by non-numeric menu choices.
- Validates stock quantity input.
- Rejects zero or negative quantities.
- Displays user-friendly error messages.

### Java Concepts Used

- Exception Handling (`try-catch`)
- `InputMismatchException`
- Input Validation


## 🚀 Learning Outcomes

By building this project, I learned:

* How real stock trading systems are structured
* Strong OOP design principles
* Working with collections in Java
* Simulating real-world systems using logic
* Git & GitHub workflow for project tracking

---

## 👨‍💻 Author

**Bhavya Shukla**
CodeAlpha Java Internship Project

---

## 📌 Status

```
✔ Stock Class Completed
✔ Market Class Completed
⏳ Portfolio System In Progress
```

---

## ⭐ If you like this project

Give it a ⭐ on GitHub and feel free to contribute or suggest improvements!

---


