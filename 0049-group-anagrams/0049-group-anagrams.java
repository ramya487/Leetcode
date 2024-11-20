class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map1 = new HashMap<String, List<String>>();
        for (int i = 0; i<strs.length; i++){
            char[] tempArray = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String newString = new String(tempArray);
            if (!map1.containsKey(newString)){
                List<String> newLst = new ArrayList<String>();
                newLst.add(strs[i]);
                map1.put(newString, newLst);
            }else {
                List<String> l = map1.get(newString);
                l.add(strs[i]);
                map1.put(newString,l);
            }
        }
        List<List<String>> lstAns = new ArrayList<List<String>>();
        for (List<String> element: map1.values()){
            lstAns.add(element);
        }
        return lstAns;
    }
}