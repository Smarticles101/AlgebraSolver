import java.util.ArrayList;
import java.util.List;

// TODO:
//      clean up code by adding methods to do specific things that are repeated a lot
//      multiplication and division support
//      parenthesis
//      exponents and roots
//      logarithms

public class Equation {
    public static double solve(List<Object> parsedEquation) {
        int loc = -1;

        while((loc = parsedEquation.indexOf('+')) != -1 || (loc = parsedEquation.indexOf('-')) != -1) {
            System.out.println(parsedEquation);
            Object n1 = parsedEquation.get(loc-1);
            Object op = parsedEquation.get(loc);
            Object n2 = parsedEquation.get(loc+1);
            if((n1 instanceof Float) && (n2 instanceof Float)) {
                parsedEquation.remove(loc);
                parsedEquation.remove(loc);
                if((Character)op == '+') {
                    parsedEquation.set(loc-1, (Float)n1 + (Float) n2);
                }
                if((Character)op == '-') {
                    parsedEquation.set(loc-1, (Float)n1 - (Float) n2);
                }
            } else {
                parsedEquation.remove(loc);
                parsedEquation.remove(loc);
                int operateAt = parsedEquation.size();
                int eqSignLoc = parsedEquation.indexOf('=');
                int varLoc = parsedEquation.indexOf("VAR");
                if(varLoc>eqSignLoc) {
                    operateAt = eqSignLoc-1;
                }
                Object number = n1 instanceof Float? n1:n2;

                if((Character)op == '+') {
                    if(operateAt != parsedEquation.size()) {
                        parsedEquation.add(operateAt, '-');
                        parsedEquation.add(operateAt, number);
                    } else {
                        parsedEquation.add(operateAt, number);
                        parsedEquation.add(operateAt, '-');
                    }
                }
                if((Character)op == '-') {
                    if(operateAt != parsedEquation.size()) {
                        parsedEquation.add(operateAt, '+');
                        parsedEquation.add(operateAt, number);
                    } else {
                        parsedEquation.add(operateAt, number);
                        parsedEquation.add(operateAt, '+');
                    }
                }
            }
        }

        while((loc = parsedEquation.indexOf('*')) != -1 || (loc = parsedEquation.indexOf('/')) != -1) {

        }

        System.out.println(parsedEquation);
        float answer = 0.0f;
        for(Object o:parsedEquation)
            if(o instanceof Float) answer = (Float)o;

        return answer;
    }

    public static double solve(String equation) {
        return solve(parse(equation));
    }

    public static List<Object> parse(String equation) {
        List<Object> parsedEquation = new ArrayList<Object>();
        String charsToParseAsInt = "";

        for(char i : equation.toCharArray()) {
            System.out.println(i);
            try {
                Float.parseFloat(Character.toString(i));                        // just check if it is parseable
                charsToParseAsInt += i;
                System.out.println(charsToParseAsInt);
            } catch (NumberFormatException e) {
                if(charsToParseAsInt.length() != 0) {
                    parsedEquation.add(Float.parseFloat(charsToParseAsInt));
                    charsToParseAsInt = "";
                }
                    switch (i) {
                        case '=':
                        case '+':
                        case '-':
                        case '*':
                        case '/':
                        case '^':
                        case 'r':
                        case 'l':
                        case '(':
                        case ')':
                        case ',':
                            parsedEquation.add(i);
                            break;

                        default:
                            parsedEquation.add("VAR");
                    }
            }
        }
        if(charsToParseAsInt.length()!=0)
        parsedEquation.add(Float.parseFloat(charsToParseAsInt));

        return parsedEquation;
    }

    public double nthRoot(double num, double root) {
        return Math.pow(num, 1 / root);
    }
}