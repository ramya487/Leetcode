// O(N) + O(NlogN) + O(N) - T
// O(N) - S
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] temp = Arrays.copyOf(people, people.length);
        Arrays.sort(temp);
        int count = 0;
        int left = 0;
        int right = temp.length-1;
        while (left <right){
            if (temp[left] + temp[right] <= limit){
                count++;
                left++;
                right--;
            }else{
                right--;
            }
        }
        System.out.println(count);
        return temp.length - 2*count + count;
    }
}