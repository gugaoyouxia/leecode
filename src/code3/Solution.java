package code3;

import java.util.HashMap;

class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i += 2){
            if(hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], hashMap.get(nums[i]) + 1);
            }
            else{
                hashMap.put(nums[i],1);
            }
        }
        int temp11 = 0, temp12 = 0;
        int rec11 = 0, rec12 = 0;
        for(int i = 0; i < nums.length; i += 2){
            if(hashMap.get(nums[i]) >= temp11){
                temp12 = temp11;
                rec12 = rec11;
                temp11 = hashMap.get(nums[i]);
                rec11 = nums[i];
            }
            else if(hashMap.get(nums[i]) >= temp12){
                temp12 = hashMap.get(nums[i]);
                rec12 = nums[i];
            }
        }

        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        for(int i = 1; i < nums.length; i += 2){
            if(hashMap2.containsKey(nums[i])){
                hashMap2.put(nums[i], hashMap2.get(nums[i]) + 1);
            }
            else{
                hashMap2.put(nums[i],1);
            }
        }
        int temp21 = 0, temp22 = 0;
        int rec21 = 0, rec22 = 0;
        for(int i = 1; i < nums.length; i += 2){
            if(hashMap2.get(nums[i]) > temp21){
                temp22 = temp21;
                rec22 = rec21;
                temp21 = hashMap2.get(nums[i]);
                rec21 = nums[i];
            }
            else if(hashMap2.get(nums[i]) > temp22){
                temp22 = hashMap2.get(nums[i]);
                rec22 = nums[i];
            }
        }

        if(rec11 == rec21){
            return nums.length - Math.max(temp11 + temp22, temp12 + temp21);
        }
        return nums.length - temp11 - temp21;
    }
}
