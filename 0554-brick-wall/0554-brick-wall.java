class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        for(List<Integer> l : wall){
            int sum = 0;
            for(int i =0;i<l.size()-1;i++){
                sum += l.get(i);
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }
        int max = 0;
        for(int key : map.keySet())
            max = Math.max(max, map.get(key));
        return wall.size()-max;
    }
}