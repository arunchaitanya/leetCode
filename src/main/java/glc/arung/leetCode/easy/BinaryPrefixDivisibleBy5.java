package glc.arung.leetCode.easy;

import java.util.*;


public class BinaryPrefixDivisibleBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        
        List<Boolean> results = new ArrayList<Boolean>();
        int length = A.length;
        int lastDigit = 0;
        for(int i =0; i < length; i++){
            // everytime a new digit is added we move the previous digit by a multiplier of 2 and addition of the last digit.
            lastDigit = 2*(lastDigit) + A[i]; 
            // a number is divisble by 5 if the last digit is divisible by 5
            results.add( lastDigit % 5==0 ? true : false);
            // we are only interested in the last digit so dividing by 10 to ge the mod
            lastDigit = lastDigit % 10;
        }
        
        return results;
    }

}