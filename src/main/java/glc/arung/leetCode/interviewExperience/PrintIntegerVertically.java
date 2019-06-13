package com.arung.leetCode.interviewExperience;
import java.util.*;

public class PrintIntegerVertically{

    public void printVertically(int x) {
        if (x == 0) {
            System.out.println(x);
            return;
        }

        Stack<Integer> s = new Stack<Integer>();
        boolean isNegative =  x < 0 ? true : false;
        x = isNegative ? x * (-1) : x;

        while (x > 0) {
            int y = x % 10;
            s.push(y);
            x /= 10;
        }
        while(!s.isEmpty()) {
            int i = s.pop();
            if(isNegative) {
                i = i * (-1);
                isNegative = false;
            }
                
            System.out.println(i);
        }

    }

    public static void main(String[] args) {
        PrintIntegerVertically printInt = new PrintIntegerVertically();
        printInt.printVertically(12345);
        System.out.println("");
        printInt.printVertically(1234554321);
        System.out.println("");
        printInt.printVertically(-1234554321);
        System.out.println("");
        printInt.printVertically(0);
    }

}