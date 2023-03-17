import java.util.Scanner;
import java.util.regex.*;


public class Main {

    public static Fraction FirstFraction;
    public static Fraction SecondFraction;


    public static void main(String[] args){
        String Expression;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a mathematical expression(with a space):");
            Expression = scanner.nextLine();
            if (Expression.equals("quit")){
                break;
            }
            else {
                try {
                    System.out.println(calculation(Expression));
                } catch (Exception y) {
                    System.out.println("Invalid data. Please, try and enter an expression again.");
                }
            }
        }
    }
    public static String calculation(String Expression){
        Pattern pattern_of_exp_with_br = Pattern.compile("\\([+\\-/*: 0-9]{1,}\\)");
        while (Expression.contains("(") && Expression.contains(")")) {
            Matcher matcher_of_exp_with_br = pattern_of_exp_with_br.matcher(Expression);
            String exp;
            while (matcher_of_exp_with_br.find()) {
                exp = matcher_of_exp_with_br.group();
                Expression = Expression.replace(exp, calculation_not_in_br(exp.substring(exp.indexOf("(") + 1, exp.indexOf(")"))));
            }
        }
        return calculation_not_in_br(Expression);
    }
    public static String calculation_not_in_br(String Expression){
        String[] parts_of_fraction, parts_of_expression;
        parts_of_expression = Expression.split(" ");
        int i=0;
        while (Expression.contains(" * ")){
            if (parts_of_expression[i].equals("*")){
                parts_of_fraction = parts_of_expression[i-1].split("/");
                FirstFraction = new Fraction(Integer.parseInt(parts_of_fraction[0]), Integer.parseInt(parts_of_fraction[1]));
                parts_of_fraction = parts_of_expression[i+1].split("/");
                SecondFraction = new Fraction(Integer.parseInt(parts_of_fraction[0]), Integer.parseInt(parts_of_fraction[1]));
                Expression = Expression.replace(parts_of_expression[i-1] + " " + parts_of_expression[i] + " " + parts_of_expression[i+1], Fraction.ConvertingToString(FirstFraction.Multiplication(SecondFraction)));
                parts_of_expression = Expression.split(" ");
            }
            else{
                i++;
            }
        }
        i = 0;
        while (Expression.contains(" : ")){
            if (parts_of_expression[i].equals(":")){
                parts_of_fraction = parts_of_expression[i-1].split("/");
                FirstFraction = new Fraction(Integer.parseInt(parts_of_fraction[0]), Integer.parseInt(parts_of_fraction[1]));
                parts_of_fraction = parts_of_expression[i+1].split("/");
                SecondFraction = new Fraction(Integer.parseInt(parts_of_fraction[0]), Integer.parseInt(parts_of_fraction[1]));
                Expression = Expression.replace(parts_of_expression[i-1] + " " + parts_of_expression[i] + " " + parts_of_expression[i+1], Fraction.ConvertingToString(FirstFraction.Division(SecondFraction)));
                parts_of_expression = Expression.split(" ");
            }
            else{
                i++;
            }
        }
        i = 0;
        while (Expression.contains(" - ")){
            if (parts_of_expression[i].equals("-")){
                parts_of_fraction = parts_of_expression[i-1].split("/");
                FirstFraction = new Fraction(Integer.parseInt(parts_of_fraction[0]), Integer.parseInt(parts_of_fraction[1]));
                parts_of_fraction = parts_of_expression[i+1].split("/");
                SecondFraction = new Fraction(Integer.parseInt(parts_of_fraction[0]), Integer.parseInt(parts_of_fraction[1]));
                Expression = Expression.replace(parts_of_expression[i-1] + " " + parts_of_expression[i] + " " + parts_of_expression[i+1], Fraction.ConvertingToString(FirstFraction.Subtraction(SecondFraction)));
                parts_of_expression = Expression.split(" ");
            }
            else{
                i++;
            }
        }
        i = 0;
        while (Expression.contains(" + ")){
            if (parts_of_expression[i].equals("+")){
                parts_of_fraction = parts_of_expression[i-1].split("/");
                FirstFraction = new Fraction(Integer.parseInt(parts_of_fraction[0]), Integer.parseInt(parts_of_fraction[1]));
                parts_of_fraction = parts_of_expression[i+1].split("/");
                SecondFraction = new Fraction(Integer.parseInt(parts_of_fraction[0]), Integer.parseInt(parts_of_fraction[1]));
                Expression = Expression.replace(parts_of_expression[i-1] + " " + parts_of_expression[i] + " " + parts_of_expression[i+1], Fraction.ConvertingToString(FirstFraction.Addition(SecondFraction)));
                parts_of_expression = Expression.split(" ");
            }
            else{
                i++;
            }
        }
        return Expression;
    }
}