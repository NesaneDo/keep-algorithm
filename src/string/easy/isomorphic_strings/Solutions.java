package string.easy.isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

public class Solutions {
    public boolean isIsomorphic(String s, String t) {
        return h(s,t)&&h(t,s);
    }
    public boolean h(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Character> sm=new HashMap<>(s.length());
        for(int i=0;i<s.length();i++){
            char sc=s.charAt(i);
            char tc=t.charAt(i);
            if(sm.containsKey(sc)&&sm.get(sc)!=tc) return false;
            sm.put(sc,tc);
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        return h2(s).equals(h2(t));
    }
    public String h2(String s) {
        int[] cs=new int[128];
        int i=0;
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(cs[c]==0)cs[c]=++i;
            sb.append(cs[c]);
        }
        return sb.toString();
    }
}
