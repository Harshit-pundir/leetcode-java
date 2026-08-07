class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();

        q.offer(node);
        Node clone = new Node(node.val);
        map.put(node,clone);

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(Node neighbor : curr.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new Node(neighbor.val));
                    q.offer(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}