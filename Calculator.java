import java.util.Scanner;

/**
 * Calculator class represents a simple calculator with undo and redo functionality.
 */
public class Calculator {
    private LinkedStack<Integer> undoStack;
    private LinkedStack<Integer> redoStack;
    private int result = 0;
    private Scanner kb = new Scanner(System.in);
    private boolean found = false;

    /**
     * Constructs a Calculator object with initialized stacks for undo and redo.
     */
    public Calculator() {
        undoStack = new LinkedStack<>();
        redoStack = new LinkedStack<>();
    }

    /**
     * Performs the specified arithmetic operation.
     *
     * @param Operator the arithmetic operator (+, -, *, /)
     * @param operand  the operand for the operation
     */
    public void PerformOperation(String Operator, int operand) {
        switch (Operator) {
            case "+":
                this.result = undoStack.top() + operand;
                System.out.println("\n= " + this.result);
                break;
            case "-":
                this.result = undoStack.top() - operand;
                System.out.println("\n= " + this.result);
                break;
            case "*":
                this.result = undoStack.top() * operand;
                System.out.println("\n= " + this.result);
                break;
            case "/":
                this.result = undoStack.top() / operand;
                System.out.println("\n= " + this.result);
                break;
        }
    }

    /**
     * Initiates the calculation process and handles user input.
     */
    public void Calculate() {
        System.out.println("Simple Calculator: type z to undo, y to redo, q to quit");
        System.out.print("\nEnter the first number:");
        int Num = kb.nextInt();
        kb.nextLine();
        this.result = Num;

        while (!found) {
            System.out.println("\nEnter the next operation on " + result + ":");
            String Input = kb.nextLine();
            Loop(Input);
        }
    }

    /**
     * Parses user input and performs the corresponding action.
     *
     * @param Input the user input
     */
    public void Loop(String Input) {
        String[] values = Input.split(" ");

        if (values.length == 2) {
            undoStack.push(this.result);
            String symbol = values[0];
            int Num = Integer.parseInt(values[1]);
            PerformOperation(symbol, Num);
        } else if (values.length == 1) {
            StackAction(values[0]);
        } else {
            System.out.println("Invalid Input, try again");
        }
    }

    /**
     * Retrieves the current result of the calculation.
     *
     * @return the current result
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Performs the specified action based on user input.
     *
     * @param oneWord the user input
     */
    public void StackAction(String oneWord) {
        if (oneWord.equals("z")) {
            undo(kb);
        } else if (oneWord.equals("y")) {
            redo();
        } else if (oneWord.equals("q")) {
            found = true;
            System.out.println("Goodbye");
        } else {
            System.out.println("Wrong Input");
        }
    }

    /**
     * Undoes the last operation.
     *
     * @param kb the scanner object for user input
     */
    public void undo(Scanner kb) {
        redoStack.push(this.result);
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            System.out.println("Enter a number:\n");
            result = kb.nextInt();
            kb.nextLine();
        } else {
            result = undoStack.pop();
            System.out.println("UNDO: " + result);
        }
    }

    /**
     * Redoes the last undone operation.
     */
    public void redo() {
        if (redoStack.size() == 0) {
            System.out.println("Nothing to redo");
        } else {
            undoStack.push(result);
            result = redoStack.pop();
            System.out.println("REDO: " + result);
        }
    }

    /**
     * Returns a string representation of the Calculator object.
     *
     * @return a string representation of the Calculator object
     */
    public String toString() {
        return undoStack.toString() + " " + redoStack.toString();
    }
}
