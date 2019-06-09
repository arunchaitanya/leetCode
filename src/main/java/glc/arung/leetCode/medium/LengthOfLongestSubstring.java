package glc.arung.leetCode.medium;

import java.io.*;
import java.util.*;


public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        LinkedHashSet set = null;
        int length = s.length();
        int maxSubStrLength = 0;
        for(int i = 0; i < length; i++){
            char c = s.charAt(i);
            if(set== null || set.contains(c)) {
                maxSubStrLength = (set!=null && set.size() > maxSubStrLength) ? set.size() : maxSubStrLength;
                set = trimmedSet(set, c);
                set.add(c);
            } else{
                set.add(c);
            }
        }
        
        maxSubStrLength = (set!=null && set.size() > maxSubStrLength)? set.size() : maxSubStrLength;
        
        return maxSubStrLength;
    }
    
    // the code below is to ensure if character is in the middle 
    // it will be removed a new continuous string is created
    private LinkedHashSet trimmedSet(LinkedHashSet s, char c){
        if(s==null)
            return new LinkedHashSet();
        else {
            Iterator itr = s.iterator();
            boolean removed = false;
            while(itr.hasNext() && !removed) {
                char b = (char)itr.next();
                if(!removed || b == c) {
                    itr.remove();
                    removed = (b ==c) ? true : false;
                }                
            }
        }
        return s;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            
            int ret = new LengthOfLongestSubstring().lengthOfLongestSubstring(line);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}