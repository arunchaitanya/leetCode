package glc.arung.leetCode.medium;

import java.util.*;
import glc.util.ListNode;

public class NextGreaterNode{


    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    public int[] nextLargerNodes(ListNode head) {
        ListNode copyHead = head;
        List<Integer> input = new ArrayList<Integer>();
        while(copyHead!=null) {
            input.add(copyHead.val);
            copyHead = copyHead.next;
        }
        int start = 0; // indexes where we need to add start the first max from
        int end = 0; /// indexes where we need to end the max from
        int max = 0;
        int[] result = new int[input.size()]; //[1,2,1]
        for(int i = 1; i < input.size(); i++){
            if(input.get(i-1) < input.get(i)){

                   max = input.get(i); //max= 2
                  fillMax(input, result, start, i, max); // 0, 1 2 --> [2,nul, null]
                   start = i; // 1
                   max = 0;    

                
            }
        }
        if(start > 0){
           fillMax(input, result, start, input.size(), max);    
        }
        
        fixResult(input, result);
        
        return result;
    }
    // there is definitely a better way to do this than being done
    void fillMax(List<Integer> input, int[] result, int start, int end, int value){
        for(int i = start; i< end; i++){
            result[i] = input.get(i) < value ? value :0;
        }
    }
    
    // there is definitely a better way to do this than this method
    void  fixResult(List<Integer> input, int[] result){
        for(int i= 0; i < result.length-1; i++){
            if(result[i] ==0 ) {
                int value = input.get(i);
                for(int j =i+1; j < result.length-1; j++){
                    if(value < result[j]){
                        result[i] = result[j];
                        break;
                    }
                        
                }
            }
        }
    }
}