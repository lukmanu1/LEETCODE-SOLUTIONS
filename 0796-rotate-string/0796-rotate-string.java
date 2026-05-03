class Solution {
    public boolean compare_from_i_th_char(String s, int start, String goal){
        for(int i = start, j = 0; i < s.length() + start; i++, j++){
            if(s.charAt(i % s.length()) != goal.charAt(j)) return false;
        }

        return true;
    }
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())return false;
        char startChar = goal.charAt(0);

        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == startChar){
                System.out.println("in here "+i);
                if(compare_from_i_th_char(s, i, goal)) return true;
            }
        }

        return false;
    }
}