class Solution {
    public int numberOfSpecialChars(String word) {
        Set<Character> set1 = new HashSet<Character>();
        Set<Character> set2 = new HashSet<Character>();
        for (int i = 0; i<word.length(); i++){
            set1.add(word.charAt(i));
            set2.add(Character.toUpperCase(word.charAt(i)));
        }
        List<Character> lst = new ArrayList<Character>();
        for (Character c: set1){
            char character = c;
            lst.add(Character.toUpperCase(character));
        }
        int count = 0;
        for (Character element: set2){
            if (Collections.frequency(lst, element) > 1){
                count++;
            }
        }
        return count;
    }
}