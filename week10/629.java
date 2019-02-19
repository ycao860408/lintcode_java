/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    Map<String , String> father = new HashMap<>();
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        List<Connection> res = new ArrayList<>();
        Collections.sort(connections, new Comparator<Connection>() {
            public int compare(Connection a, Connection b) {
                if (a.cost != b.cost) {
                    return a.cost - b.cost;
                } 
                if (a.city1.equals(b.city1)) {
                    return a.city2.compareTo(b.city2);
                }
                return a.city1.compareTo(b.city1);
            }
        });
        
        for (Connection con : connections) {
            String rootA = find(con.city1), rootB = find(con.city2);
            if (rootA != rootB) {
                res.add(con);
            }
            father.put(rootA, rootB);
        }
        if (father.size() - 1 != res.size()) {
            return new ArrayList<Connection>();
        }
        return res;
    }
    
    private String find(String str) {
        if (!father.containsKey(str)) {
            father.put(str,str);
        } else if (!father.get(str).equals(str)) {
            father.put(str, find(father.get(str)));
        }
        return father.get(str);
    }
}