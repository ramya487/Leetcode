class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> initlst = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        initlst.add(temp);
        
        System.out.println(initlst);

        for (int i = 1; i<numRows; i++){
            List<Integer> l = new ArrayList<Integer>();
            List<Integer> lst = initlst.get(i-1);
            for (int j = 0; j<=i; j++){
                if (j-1>=0 && j<lst.size()){
                    l.add(lst.get(j-1)+lst.get(j));
                }else {
                    l.add(1);
                }
            }
            initlst.add(l);
        }
        return initlst;
    }
}