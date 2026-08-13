class Node{
    int longest;
    char firstChar;
    char lastChar;

    int prefixLength;
    int suffixLength;
    int length;

}

class Solution {

    public void update(char ch, int target, Node segmentTree[], int index, int low, int high){
        
        if(low == high){
            Node node = segmentTree[index];
            node.firstChar = node.lastChar = ch;
            return;
        }

        int mid = low + (high - low)/2;

        if(target <= mid){
            update(ch, target, segmentTree, 2 * index + 1, low, mid);
        }else update(ch, target, segmentTree, 2 * index + 2, mid + 1, high);

        Node node = segmentTree[index];

        Node lnode = segmentTree[2 * index + 1];
        Node rnode = segmentTree[2 * index + 2];

        updateNodeDetails(node, lnode, rnode);

        return;

    }

    public void updateNodeDetails(Node node, Node lnode, Node rnode){

        node.firstChar = lnode.firstChar;
        node.lastChar = rnode.lastChar;

        if (lnode.lastChar == rnode.firstChar) {

            node.longest = Math.max(
                lnode.longest,
                Math.max(
                    rnode.longest,
                    lnode.suffixLength + rnode.prefixLength
                )
            );

        } else {
            node.longest = Math.max(lnode.longest, rnode.longest);
        }


        if (lnode.length == lnode.prefixLength &&
            lnode.lastChar == rnode.firstChar) {

            node.prefixLength =
                lnode.prefixLength + rnode.prefixLength;

        } else {
            node.prefixLength = lnode.prefixLength;
        }


        if (rnode.length == rnode.suffixLength &&
            lnode.lastChar == rnode.firstChar) {

            node.suffixLength =
                lnode.suffixLength + rnode.suffixLength;

        } else {
            node.suffixLength = rnode.suffixLength;
        }

        node.length = lnode.length + rnode.length;

        return;

    }

    public void build(String s, int low, int high, Node segmentTree[], int index){

        if (low == high) {
            Node node = new Node();

            node.longest = 1;
            node.firstChar = node.lastChar = s.charAt(low);
            node.prefixLength = node.suffixLength = 1;
            node.length = 1;

            segmentTree[index] = node;
            return;
        }

        int mid = low + (high - low)/2;
        build(s, low, mid, segmentTree, 2 * index + 1);
        build(s, mid + 1, high, segmentTree, 2 * index + 2);

        Node node = new Node();

        Node lnode = segmentTree[2 * index + 1];
        Node rnode = segmentTree[2 * index + 2];

        updateNodeDetails(node, lnode, rnode);

        segmentTree[index] = node;

        return;

    }
    
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        Node segmentTree[] = new Node[4 * s.length()];
        build(s, 0, s.length() - 1, segmentTree, 0);

        int ans[] = new int[queryIndices.length];

        for(int i = 0; i<queryIndices.length; i++){
            update(queryCharacters.charAt(i), queryIndices[i], segmentTree, 0, 0, s.length() - 1);
            ans[i] = segmentTree[0].longest;
        }

        return ans;
    }
}