package glc.arung.leetCode.medium;

public class CanJump {
    public boolean canJump(int[] nums) {

        int size = nums.length;
        if(size == 1)
            return true;
        int farthest = 0;
        boolean result = false;
        for(int i = 0; i < size-1; i++){
            //[2,3,1,1,4]  [3,2,1,0,4] [1,2]
            int currFarthest = nums[i]+i; // 1 //2 //1+2 ==3 //3
            farthest = Math.max(farthest, currFarthest); //1,3 //3
            if(farthest >= size -1)
                return true;
            if(farthest ==0 || farthest <= i)
                return false;
        }
    
        
        return result;
    }
}