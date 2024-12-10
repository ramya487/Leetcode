import java.util.Random;
class Solution {
    int[] nums;
    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
       int[] shuffled = nums.clone(); // Clone the array to shuffle
       Random rand= new Random();
        for (int i = 0; i < shuffled.length; i++) {
            // Generate a random index from i to the end of the array
            int randomIndex = rand.nextInt(shuffled.length);
            // Swap the elements at i and randomIndex
            int temp = shuffled[i];
            shuffled[i] = shuffled[randomIndex];
            shuffled[randomIndex] = temp;
        }
        return shuffled; // Return the shuffled array
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */