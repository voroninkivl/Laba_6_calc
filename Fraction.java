public class Fraction {

    public int numerator;
    public int denominator;


    public Fraction(int num, int denomin) { //creating a fraction
        this.numerator = num;
        this.denominator = denomin;
        FractionReduction();
    }

    public Fraction(String Fraction) {
        int numerator;
        int denominator;
        String slash = "/";

        int indexOfSlash = Fraction.indexOf(slash);  //finding the index of the dash in the Fraction
        String numeratorString = Fraction.substring(0, indexOfSlash);
        String denominatorString = Fraction.substring(indexOfSlash + 1);
        numerator = Integer.parseInt(numeratorString);
        denominator = Integer.parseInt(denominatorString);

        this.numerator = numerator;
        this.denominator = denominator;
        FractionReduction();
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    public int GreatestCommonDivisor(int numerator, int denominator) {
        if (numerator % denominator == 0) { //if numerator is divisible by the given denominator, return denominator
            return denominator;
        }
        if (denominator % numerator == 0) { //else return numerator
            return numerator;
        }
        return GreatestCommonDivisor(denominator, numerator % denominator); //or call the function again (recursion)
    }


    void FractionReduction() { //this method reduces the given fraction to its lowest form possible
        int greatestCommonDivisor = GreatestCommonDivisor(numerator, denominator);
        numerator /= greatestCommonDivisor;
        denominator /= greatestCommonDivisor;
    }


    public Fraction Addition(Fraction SecondFraction) { //method for adding two fractions
        int newNumerator = (numerator * SecondFraction.getDenominator()) +
                (SecondFraction.getNumerator() * denominator);
        int newDenominator = denominator * SecondFraction.getDenominator();

        return new Fraction(newNumerator, newDenominator); //using the method for building a fraction
    }


    public Fraction Subtraction(Fraction SecondFraction) {
        int newNumerator = (numerator * SecondFraction.denominator) -
                (SecondFraction.numerator * denominator);
        int newDenominator = denominator * SecondFraction.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction Multiplication(Fraction SecondFraction) {
        int newNumerator = numerator * SecondFraction.numerator;
        int newDenominator = denominator * SecondFraction.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction Division(Fraction SecondFraction) {
        int newNumerator = numerator * SecondFraction.getDenominator();
        int newDenominator = denominator * SecondFraction.numerator;

        return new Fraction(newNumerator, newDenominator);
    }

    public static Fraction Addition(Fraction FirstFraction, Fraction SecondFraction) {
        int newNumerator = FirstFraction.getNumerator() * SecondFraction.getDenominator() + SecondFraction.getNumerator() * FirstFraction.getDenominator();
        int newDenominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fraction(newNumerator, newDenominator);

    }

    public static Fraction Subtraction(Fraction FirstFraction, Fraction SecondFraction) {
        int numerator = FirstFraction.getNumerator() * SecondFraction.getDenominator() - SecondFraction.getNumerator() * FirstFraction.getDenominator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction Multiplication(Fraction FirstFraction, Fraction SecondFraction) {
        int numerator = FirstFraction.getNumerator() * SecondFraction.getNumerator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction Division(Fraction FirstFraction, Fraction SecondFraction) {
        int numerator = FirstFraction.getNumerator() * SecondFraction.getDenominator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getNumerator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction SimplestFraction() {
        int numerator = 1;
        int denominator = 1;

        return new Fraction(numerator, denominator);
    }

    public static String ConvertingToString(Fraction OurFraction) { //method for converting Fractions into String
        int numerator = OurFraction.getNumerator();
        int denominator = OurFraction.getDenominator();

        String result;
        result = numerator + "/" + denominator;
        return result;
    }
}