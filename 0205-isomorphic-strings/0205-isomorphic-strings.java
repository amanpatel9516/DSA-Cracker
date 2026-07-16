class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapSt = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch1 =s.charAt(i);
            char ch2 =t.charAt(i);

            if(mapSt.getOrDefault(ch1, ch2)!=ch2 || mapTS.getOrDefault(ch2, ch1)!=ch1)
            {
        return false;
        }
    mapSt.put(ch1, ch2);
    mapTS.put(ch2, ch1);
    }
    return true;
    }

}
