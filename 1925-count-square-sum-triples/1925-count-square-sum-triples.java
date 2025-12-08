class Solution {
    public int countTriples(int n) {
        int a = 0, b = 0, c = 0, count = 0;
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<=n; j++){
                if(i == j)continue;
                a = i * i;
                b = j * j;
                c = (int) Math.sqrt(a + b);
                

                if(c >0 && c <= n){
                    // System.out.println("i = "+i+" j = "+j+" c = "+c);
                    int k = (a + b) / c;
                    if( k == c && (a + b) % c == 0)count++;
                }
            }
        }

        return count;
        
    }
}