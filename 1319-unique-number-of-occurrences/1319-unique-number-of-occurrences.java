// T- O(nlogn) + O(N) since tc of add,contains of hashset is constant
// S- O(N)
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<Integer>();
        int count = 1;
        for (int i = 0; i<arr.length-1; i++){
            if (arr[i] == arr[i+1]) count++;
            else {
                if (!set.contains(count)) set.add(count);
                else return false;
                count = 1;
            }
        }
        if (!set.contains(count)) return true;
        return false;
    }
}