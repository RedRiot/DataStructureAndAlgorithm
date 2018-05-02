import java.util.Arrays;

public class TheStack {
    private String[] stackArray;
    private int stackSize;
    private int topOfStack;

    TheStack(int size) {
        stackSize = size;
        stackArray = new String[size];
        Arrays.fill(stackArray, "-1");


    }

    public void push(String input) {
        if (topOfStack + 1 < stackSize) {
            stackArray[topOfStack] = input;
            topOfStack++;

        } else System.out.println("Sorry but Stack is Full");
        displayTheStack();
        System.out.println("Push" + input + "was added to Stack");
    }

    public void pushMany(String manyValues) {
        String[] tempList = manyValues.split(" ");
        for (int i = 0; i < tempList.length; i++) {
            push(tempList[i]);
        }
    }

    public String pop() {
        if (topOfStack >= 0) {
            displayTheStack();
            System.out.println("Pop" + stackArray[topOfStack] + "was removed from Stack");
            stackArray[topOfStack] = "-1";
            return stackArray[topOfStack--];
        } else {
            displayTheStack();
            System.out.println("Sorry but the Stack is Empty");
            return "-1";

        }
    }

    public void popAll() {
        for (int i = 0; i < topOfStack; i--) {
            pop();
        }
    }

    public String peek() {
        displayTheStack();
        System.out.println("PEEK" + stackArray[topOfStack] + "Is at the Top of the Stack ");
        return stackArray[topOfStack];
    }

    public void displayTheStack(){

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){

            System.out.format("| %2s "+ " ", n);

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

        for(int n = 0; n < stackSize; n++){



            if(stackArray[n].equals("-1")) System.out.print("|     ");

            else System.out.print(String.format("| %2s "+ " ", stackArray[n]));

        }

        System.out.println("|");

        for(int n = 0; n < 61; n++)System.out.print("-");

        System.out.println();

    }

    public static void main(String[] args) {
        TheStack stack = new TheStack(6);
        stack.push("5");


    }
}
