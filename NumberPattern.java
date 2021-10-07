import java.util.Scanner;

public class NumberPattern {
    // Write recursive printNumPattern() method

    public static void printNumPattern(int startingNum, int changeNum){
        System.out.print(startingNum + " ");
        if(startingNum <= 0){
            return;
        }
        printNumPattern(startingNum-changeNum,changeNum);
        System.out.print(startingNum + " ");


    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int num1;
        int num2;

        num1 = scnr.nextInt();
        num2 = scnr.nextInt();
        printNumPattern(num1, num2);

    }
}
