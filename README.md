# FinalProject/*
    Project Title: Smart Grocery List Manager

    Components:
    1. GroceryManager.java
       - The main class with the menu interface.
       - Manages the ArrayList for needed items and the array for purchased items.
       - Includes logic for saving/loading data when the program starts or exits.
       - Uses recursion for input validation (e.g., getValidIndex()).
       - Uses try-catch to handle bad input (e.g., non-numeric values).

    2. FileHandler.java
       - Contains static methods to save and load both ArrayLists and arrays.
       - Saves needed items to "neededItems.txt".
       - Saves purchased items to "purchasedItems.txt".
       - Uses BufferedReader and BufferedWriter with try-catch blocks.

    3. InputValidator.java
       - Uses recursive methods to ensure users enter valid input.
       - Example: If the user enters a non-integer, it catches the error
         and recursively re-prompts the user.

*/
