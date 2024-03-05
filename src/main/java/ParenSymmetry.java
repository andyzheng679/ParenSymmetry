package src.main.java;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;


public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for(char character : s.toCharArray()){
            if(character == '('){
                stack.push(character);
            } else if (character == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();        //if character is ) and the stack is not empty and when you
            }else{
                // look at the top of stack and it equals to (, then take out ( from stack
                System.out.println("Not Balanced");
                return false;
            }
        }
        System.out.println("String Balanced");
        return true;
    }

    private void checkFile(String filename) {
        // open file named filename

        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file

        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String readFile = scanner.nextLine();
                boolean balance = isBalanced(readFile);
                System.out.println(balance);
            }
            scanner.close();

        }catch(FileNotFoundException e){
            System.out.println("No file found");
            e.printStackTrace();
        }




    }

    public static void main(String[] args) {

        ParenSymmetry ps = new ParenSymmetry();

        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
