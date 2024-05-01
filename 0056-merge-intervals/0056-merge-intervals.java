class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (arr1,arr2) -> Integer.compare(arr1[0],arr2[0]));
        List<ArrayList<Integer>> ansLst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(intervals[0][0]);
        l.add(intervals[0][1]);
        ansLst.add(l);
        int start;
        int end;
        int endprev;
        for (int i = 1; i<intervals.length; i++){
            start = intervals[i][0];
            end = intervals[i][1];
            endprev = ansLst.get(ansLst.size()-1).get(1);
            if (start <= endprev){
                ansLst.get(ansLst.size()-1).set(1, Math.max(end, endprev));
            }else {
                l = new ArrayList<Integer>();
                l.add(start);
                l.add(end);
                ansLst.add(l);
            }
        }
        int[][] ansArr = new int[ansLst.size()][2];
        for (int i = 0; i<ansLst.size(); i++){
            for (int j = 0; j<2; j++){
                ansArr[i][j] = ansLst.get(i).get(j);
            }
        }
        return ansArr;
    }
}