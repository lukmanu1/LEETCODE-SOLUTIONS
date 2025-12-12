import java.util.*;

class Solution {
    public int[] countMentions(int n, List<List<String>> events) {

        Collections.sort(events, (a, b) -> {
            int ta = Integer.parseInt(a.get(1));
            int tb = Integer.parseInt(b.get(1));
            if (ta != tb) return Integer.compare(ta, tb);

            if (a.get(0).equals(b.get(0))) return 0;
            if (a.get(0).equals("OFFLINE")) return -1;
            return 1; 
        });

        HashMap<Integer, Boolean> online = new HashMap<>();
        HashMap<Integer, Integer> offline = new HashMap<>();

        int ans[] = new int[n];
        Arrays.fill(ans, 0);

        
        for (int i = 0; i < n; i++) {
            online.put(i, true);
            offline.put(i, 0);
        }

        String type = null;
        int time = 0;
        String userList = null;

        for (List<String> event : events) {
            type = event.get(0);
            time = Integer.parseInt(event.get(1));
            userList = event.get(2);

            if (type.equals("OFFLINE")) {

                String users[] = userList.split(" ");
                for (String user : users) {
                    int id = parseId(user);
                    offline.put(id, time + 60); 
                    online.put(id, false);       
                }

            } else {

                
                for (int i = 0; i < n; i++) {
                    if (time >= offline.get(i)) online.put(i, true);
                    else online.put(i, false);
                }

                if (userList.equals("ALL")) {

                    for (int i = 0; i < n; i++) ans[i]++;

                } else if (userList.equals("HERE")) {

                    for (int i = 0; i < n; i++) {
                        if (online.get(i)) ans[i]++;
                    }

                } else {

                    
                    String users[] = userList.split(" ");
                    for (String user : users) {
                        int id = parseId(user);
                        ans[id]++;     
                    }
                }
            }
        }

        return ans;
    }


    private int parseId(String user) {
        if (user.startsWith("id")) {
            return Integer.parseInt(user.substring(2));
        }
        return Integer.parseInt(user); 
    }
}