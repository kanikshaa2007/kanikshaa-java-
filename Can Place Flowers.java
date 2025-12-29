class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) { 

        if(n==0){
            return true;
        }
        
        //    so we have to check the left and right side before placing the flower 
        // and edge case is the corners left and right 
        // so if we're at means i is at 0th index then there's no left neighbour 
        // and same goes if i is at last index then their's no right neighbour 
        // the most special case is n=1 and 0 only this for i there's no left neighbour and right 

        int copy = n;
        for (int i = 0; i < flowerbed.length; i++) {
         boolean leftSide=(i==0 || flowerbed[i-1]==0);
         boolean rightSide=(i==flowerbed.length-1 || flowerbed[i+1]==0);
         if(flowerbed[i]==0){
            if(leftSide && rightSide){
                flowerbed[i]=1;
                copy--;
            }
         }
        }
        // if we placed all the flowers then return true
        if(copy==0){
            return true;
        }
        // if copy is in minus means we placed more then n then too it's true 
        if(copy<=0){
            return true;
        }
        // and if we cant place all n we got then false 
       return false;
    }
}
