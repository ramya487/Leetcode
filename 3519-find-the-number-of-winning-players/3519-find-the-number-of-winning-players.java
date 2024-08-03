class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Map<Integer, Integer>> mp = new HashMap<>();
        for (int i = 0; i<pick.length; i++){
            int person = pick[i][0];
            int ball = pick[i][1];

            if (!mp.containsKey(person)){
                Map<Integer, Integer> nmp = new HashMap<>();
                nmp.put(ball, 1);
                mp.put(person, nmp);
            }else{
                if (!mp.get(person).containsKey(ball)){
                    Map<Integer, Integer> xx = mp.get(person);
                    xx.put(ball, 1);
                    mp.put(person, xx);
                }else{
                    Map<Integer, Integer> xy = mp.get(person);
                    xy.put(ball, xy.get(ball)+1);
                    mp.put(person, xy);
                }
            }
        }

        int count = 0;

        for (Map.Entry<Integer, Map<Integer, Integer>> entry: mp.entrySet()){
            int k = entry.getKey();
            Map<Integer, Integer> val = entry.getValue();

            for (Map.Entry<Integer, Integer> ent: val.entrySet()){
                int v = ent.getValue();
                if (v > k) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(mp);
        return count;

    }
}