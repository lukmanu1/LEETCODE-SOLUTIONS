class Solution {
    public void findWordSplit(String s, int index, StringBuilder str, List<String> wordDict, List<String> ans){
        if(index == s.length()){
            ans.add(str.toString());
            return;
        }

        StringBuilder tempStr = new StringBuilder();

        for(int i = index; i<s.length(); i++){
            if(wordDict.contains(s.substring(index, i + 1))){

                int oldLength = str.length();

                if(index != 0)
                    str.append(" ");

                str.append(s.substring(index, i + 1));

                findWordSplit(s, i + 1, str, wordDict, ans);

                str.delete(oldLength, str.length());
            }
        }

        return;
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        findWordSplit(s, 0, new StringBuilder(), wordDict, ans);
        return ans;
    }
}