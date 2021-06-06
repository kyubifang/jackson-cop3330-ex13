/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Jamar Jackson
 */

package base;

import java.util.Scanner;

/*
Exercise 13 - Determining Compound Interest

        Simple interest is something you use only when making a quick guess. Most investments use a compound interest formula, which will be much more accurate. And this formula requires you to incorporate exponents into your programs.

        Write a program to compute the value of an investment compounded over time. The program should ask for the starting amount, the number of years to invest, the interest rate, and the number of periods per year to compound.

        The formula you’ll use for this is A = P(1 + r/n)^(n*t) where

        P is the principal amount.
        r is the annual rate of interest.
        t is the number of years the amount is invested.
        n is the number of times the interest is compounded per year.
        A is the amount at the end of the investment.

        Example Output

        What is the principal amount? 1500
        What is the rate? 4.3
        What is the number of years? 6
        What is the number of times the interest is compounded per year? 4
        $1500 invested at 4.3% for 6 years compounded 4 times per year is $1938.84.

        Constraints

        Prompt for the rate as a percentage (like 15, not .15). Divide the input by 100 in your program.
        Ensure that fractions of a cent are rounded up to the next penny.
        Ensure that the output is formatted as money.

        Challenges

        Ensure that all of the inputs are numeric and that the program will not let the user proceed without valid inputs.
        Create a version of the program that works in reverse, so you can determine the initial amount you’d need to invest to reach a specific goal.
        Implement this program as a GUI app that automatically updates the values when any value changes.
*/
public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();
        int prince = myApp.principal();
        double rate = myApp.interestRate();
        double percent = myApp.percentage(rate);
        int years = myApp.yearlyInterest();
        int times = myApp.timesInvested();
        double amount = myApp.formula(prince, percent, years, times);
        final double calc = Math.round(amount * 100.0) / 100.0;
        String invest = Double.toString(calc);
        if((calc % 1) == 0) {
            invest = String.format("%.0f", calc);
        }
        String outputString = myApp.generateOutputString(prince, rate, times, years, invest);
        myApp.printOutput(outputString);
    }

    public void printOutput(String outputString) {
        System.out.println(outputString);
    }

    public int principal() {
        System.out.println("Enter the principal: ");
        return in.nextInt();
    }

    public double interestRate() {
        System.out.println("Enter the rate of interest: ");
        return in.nextDouble();
    }

    public int yearlyInterest() {
        System.out.println("Enter the number of years: ");
        return in.nextInt();
    }

    public double percentage(double rate) {
        return (rate / 100);
    }

    public int timesInvested() {
        System.out.println("What is the number of times the interest is compounded per year? ");
        return in.nextInt();
    }

    public double formula(int prince, double percent, int years, int times) {
        //PEMDAS
        double inParentheses = 1 + (percent / times);
        int exponent = times * years;
        double solve = Math.pow(inParentheses, exponent);
        return prince * solve;
    }

    public String generateOutputString(int prince, double rate, int times, int years, String invest) {
        return "$" + prince + " invested at " + rate + "% for " + years + " years compounded " + times + " times per year is $" + invest + ".";
    }
}
