import java.util.ArrayList;
import java.util.Scanner;

public class Solver {
    public static void main(String args[]) {
        if(args.length!=0) {

        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Please type your equation :: ");
            System.out.println(Equation.solve(in.next()));
        }
    }
}