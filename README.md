Calculator with Undo and Redo Functionality

This program implements a simple calculator with the ability to perform basic arithmetic operations and undo/redo previous actions.

Key Features:

Arithmetic Operations: Users can perform addition, subtraction, multiplication, and division on integers.
Undo Functionality: The calculator allows users to undo the last operation performed.
Redo Functionality: Users can redo an operation that was previously undone.
User Interface: The program prompts users for input via the console, guiding them through each step of the calculation process.


How to Use:

Input Format: Enter the first number followed by an arithmetic operator and the second number (e.g., 5 + 3).
Undo: Type z to undo the last operation.
Redo: Type y to redo an undone operation.
Quit: To exit the program, type q.


Example Usage:

Simple Calculator: type z to undo, y to redo, q to quit

Enter the first number: 10

Enter the next operation on 10: + 5
= 15

Enter the next operation on 15: * 3
= 45

Enter the next operation on 45: z
UNDO: 15

Enter the next operation on 15: y
REDO: 45

Enter the next operation on 45: / 3
= 15

Enter the next operation on 15: q
Goodbye

Notes:
Invalid input will prompt the user to try again, ensuring a smooth user experience.
A single space should be provided between operators and numbers as not doing so would result in incorrect input.

This calculator offers a convenient way to perform arithmetic calculations while providing the flexibility to correct mistakes using undo and redo operations
