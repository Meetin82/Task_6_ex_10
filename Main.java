package ru.vsu.cs.semenov_d_s;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        double x = readNum("x: ");
        if (checkXPositive(x)){
            System.out.println("The entered number does not match the conditions of this task.");
            return;
        }

        int n = (int) readNum("n: ");
        if (checkNPositive(n)) {
            System.out.println("The ordinal number of a number cannot be less than zero.");
            return;
        }

        double e = readNum("e: ");

        double sumOfNTerms = calcSumOfNTerms(x, n);
        double sumTermsIsGreaterThanE = calcSumTermsIsGreaterThanE(x, n, e);
        double sumTermsIsGreaterThanEDividedBy10 = calcSumTermsIsGreaterThanE(x, n, e / 10);
        double valueFunctionUsingMath = calcFunctionUsingMath(x);

        printResult(sumOfNTerms, sumTermsIsGreaterThanE, sumTermsIsGreaterThanEDividedBy10, valueFunctionUsingMath);
    }

    private static double calcSumOfNTerms(double x, int n) {
        double sumOfSequence = 0;
        for (int i = 0; i < n; i++){
            if (i % 2 != 0){
                sumOfSequence += -1 * (i + 1) * Math.pow(x, i);
            } else {
                sumOfSequence += (i + 1) * Math.pow(x, i);
            }
        }
        return sumOfSequence;
    }

    private static double calcSumTermsIsGreaterThanE(double x, int n, double e){
        double term;
        double sum = 0;

        for (int i = 0; i < n; i++){
            if (i % 2 != 0){
                term = -1 * (i + 1) * Math.pow(x, i);
            } else {
                term = (i + 1) * Math.pow(x, i);
            }
            if (Math.abs(term) > e){
                sum += term;
            }
        }
        return sum;
    }

    private static double calcFunctionUsingMath(double x){
        return 1 / Math.pow(1 + x, 2);
    }

    private static void printSumOfNTerms(double sumOfNTerms){
        System.out.println("Sum of n terms: " + sumOfNTerms);
    }

    private static void printSumTermsIsGreaterThanE (double sumTermsIsGreaterThanE){
        System.out.println("The sum of terms that are greater in absolute value than e: " + sumTermsIsGreaterThanE);
    }

    private static void printSumTermsIsGreaterThanEDividedBy10 (double sumTermsIsGreaterThanEDividedBy10){
        System.out.println("The sum of terms that are greater in absolute value than e/10: " + sumTermsIsGreaterThanEDividedBy10);
    }

    private static void printValueFunctionUsingMath(double valueFunctionUsingMath){
        System.out.println("Function value using Math methods: " + valueFunctionUsingMath);
    }

    private static void printResult(double sumOfNTerms, double sumTermsIsGreaterThanE, double sumTermsIsGreaterThanEDividedBy10, double valueFunctionUsingMath){
        printSumOfNTerms(sumOfNTerms);
        printSumTermsIsGreaterThanE(sumTermsIsGreaterThanE);
        printSumTermsIsGreaterThanEDividedBy10(sumTermsIsGreaterThanEDividedBy10);
        printValueFunctionUsingMath(valueFunctionUsingMath);
    }

    private static boolean checkXPositive(double num){
        return num <= -1 || num >= 1;
    }

    private static boolean checkNPositive(double num){
        return num < 0;
    }

    private static double readNum(String value){
        System.out.print("Enter " + value);
        Scanner scn = new Scanner(System.in);
        return scn.nextDouble();
    }
}
