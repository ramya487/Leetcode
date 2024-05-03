class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> lst = new ArrayList<Integer>();
        for (int element: nums){
            if (!map.containsKey(element)){
                map.put(element, 1);
            }else{
                map.put(element, map.get(element)+1);
            }
        }
        for (Integer key: map.keySet()){
            if (map.get(key) > nums.length/3) lst.add(key);
        }
        return lst;
    }
}