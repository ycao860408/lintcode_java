import java.util.*;

interface MyMap {
    void put(String key, String val);
    String get(String key);
}

class Pair {
    String key, val;
    Pair(String key, String val) {
        this.key = key; 
        this.val = val;
    }
}

class MyMapListImpl implements MyMap {
    private List<Pair> pairs;
    
    public MyMapListImpl() {
        pairs = new ArrayList<Pair>();
    }
    
    public void put(String key, String val) {
        if(key == null) {
            return;
        }
        
        for (Pair pair : pairs) {
            if (pair.key.equals(key)) {
                pair.val = val;
                return;
            }
        }
        pairs.add(new Pair(key, val));
    }
    
    public String get(String key) {
        if (key == null) {
            return null;
        }
        for (Pair pair : pairs) {
            if (pair.key.equals(key)){
                return pair.val;
            }
        }
        return null;
    }
}

class TreeNode {
    Pair pair;
    TreeNode left, right;
    TreeNode (Pair pair) {
        this.pair = pair;
    }
}

class MyMapBSTImpl implements MyMap{
    private TreeNode root;
    public void put(String key, String val) {
        if (key == null) {
            return;
        }
        root = insert(root, new Pair(key, val));
    }
    
    private TreeNode insert(TreeNode root, Pair pair) {
        if (root == null) {
            return new TreeNode(pair);
        }
        int compar = pair.key.compareTo(root.pair.key);
        if (compar == 0) {
            root.pair = pair;
        } else if (compar < 0){
            root.left = insert(root.left, pair);
        } else {
            root.right = insert(root.right, pair);
        }
        return root;
    }
    
    public String get(String key) {
        if (key == null) {
            return null;
        }
        return search(root, key);
    }
    
    private String search(TreeNode root, String key) {
        if (root == null) {
            return null;
        }
        int compare = key.compareTo(root.pair.key);
        if (compare == 0) {
            return root.pair.val;
        } else if (compare < 0) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }
}


class ListNode {
    Pair pair;
    ListNode next;
    ListNode(Pair pair) {
        this.pair = pair;
        next = null;
    }
}

class MyMapOpenHashingImpl implements MyMap {
   
   private ListNode[] data;
   private int compacity;
   private int size;
   private static final float LOAD_FACTOR = 0.75f;
   
   
   public MyMapOpenHashingImpl(int compacity) {
       this.compacity = compacity;
       this.size = 0;
       data = new ListNode[compacity];
   }
   
   public  void put(String key, String val) {
        if (key == null) {
            return;
        }
        
        if (size >= compacity * LOAD_FACTOR) {
            doubleSizeAndRehash();
        }
        int idx = key.hashCode() % compacity;
        ListNode cur = data[idx];
        while (cur != null) {
            if (cur.pair.key.equals(key)) {
                cur.pair.val = val;
                return;
            }
            cur = cur.next;
        }
        ListNode temp = new ListNode(new Pair(key, val));
        temp.next = data[idx];
        data[idx] = temp;
        size++;
    }
    
    private void doubleSizeAndRehash() {
        int newCompacity = 2 * compacity;
        ListNode[] newData = new ListNode[newCompacity];
        for (int i = 0; i < compacity; i++) {
            ListNode cur = data[i];
            while (cur != null) {
                ListNode temp = cur;
                cur = cur.next;
                int newIdx = temp.pair.key.hashCode() % newCompacity;
                temp.next = newData[newIdx];
                newData[newIdx] = temp;
            }
        }
        data = newData;
        compacity = newCompacity;
    }
    
    public String get(String key) {
        if (key == null) {
            return null;
        }
        int idx = key.hashCode() % compacity;
        ListNode cur = data[idx];
         
        while (cur != null) {
            if (cur.pair.key.equals(key)) {
                return cur.pair.val; 
            }
            cur = cur.next;
        }
        return null;
    }
    
}

class MyMapCloseHashingImpl implements MyMap {
    private Pair[] data;
    private int compacity;
    
    public MyMapCloseHashingImpl(int compacity) {
        this.compacity = compacity;
        data = new Pair[compacity];
    }
    
    public void put(String key, String val) {
        if (key == null) {
            return;
        }
        int idx = key.hashCode() % compacity;
        for (int i = 0; i < compacity; i++) {
            int cur = (idx + i) % compacity;
            if (data[cur] == null) {
                data[cur] = new Pair(key, val);
                return;
            } else {
                if (data[cur].key.equals(key)) {
                    data[cur].val = val;
                    return;
                }
            }
        }
        throw new IllegalStateException("Hash Table is already full");
    }
    
    public String get(String key) {
        if (key == null) {
            return null;
        }
        int idx = key.hashCode() % compacity;
        
        for (int i = 0; i < compacity; i++) {
            int cur = (i + idx) % compacity;
            if (data[cur] == null) {
                return null;
            } else if (data[cur].key.equals(key)) {
                return data[cur].val;
            } 
        }
        return null;
    }
}

public class Main {
    public static void main(String args[]) {
        System.out.println(testMyMapListImp());
        System.out.println(testMyMapBSTImp());
        System.out.println(test("BST"));
        System.out.println(test("LL"));
        Map<String, String> map = new HashMap<>();
        // more fast but without order;
        //Map<String, String> map = new TreeMap<>();
        map.put("Jack","CMU");
        map.put("Rose", "MIT");
        System.out.println(map.size());
        System.out.println(map.get("Jack"));
        System.out.println(map.containsKey("Jack"));
        // transversal the map: 
        for (String key : map.keySet()) {
            System.out.println(key + ": " +map.get(key));
        }
        System.out.println();
        for (String value : map.values()) {
            System.out.println(value);
        }
        System.out.println();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
        
        map.remove("Jack");
        System.out.println(map.get("Jack"));
        System.out.println(map.containsKey("Jack"));
        
        System.out.println(map.containsValue("MIT"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println();
        Set<String> set = new HashSet<>();
        // implemented by hashtable, faster but non ordered;
        // Set<String> set = new TreeSet<>(); 
        // implemented by the balanced BST, slower but with order. 
        set.add("Jack");
        set.add("Rose");
        set.add("Tome");
        System.out.println(set.contains("Jack"));
        set.remove("Jack");
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println();
        
        for (String elm : set) {
            System.out.println(elm);
        }
        System.out.println();
        System.out.println(test("Open hashing"));
        System.out.println();
        System.out.println(test("Close hashing"));
        System.out.println();
         
    }
    
    private static boolean testMyMapListImp(){
        MyMapListImpl map = new MyMapListImpl();
        map.put("Jack","CMU");
        map.put("Rose","MIT");
        if (!"CMU".equals(map.get("Jack"))) {
            System.out.println("Expected CMU: but reuslt " +map.get("Jack"));
            return false;
        }
        if (!"MIT".equals(map.get("Rose"))) {
            System.out.println("Expected MIT: but reuslt " +map.get("Rose"));
            return false;
        }
        map.put("Jack","Standford");
        if (!"Standford".equals(map.get("Jack"))) {
            System.out.println("Expected Standford: but reuslt " +map.get("Jack"));
            return false;
        }
        if (!"MIT".equals(map.get("Rose"))) {
            System.out.println("Expected MIT: but reuslt " +map.get("Rose"));
            return false;
        }
        return true;
    }
    
    private static boolean testMyMapBSTImp(){
        MyMapBSTImpl map = new MyMapBSTImpl();
        map.put("Jack","CMU");
        map.put("Rose","MIT");
        if (!"CMU".equals(map.get("Jack"))) {
            System.out.println("Expected CMU: but reuslt " +map.get("Jack"));
            return false;
        }
        if (!"MIT".equals(map.get("Rose"))) {
            System.out.println("Expected MIT: but reuslt " +map.get("Rose"));
            return false;
        }
        map.put("Jack","Standford");
        if (!"Standford".equals(map.get("Jack"))) {
            System.out.println("Expected Standford: but reuslt " +map.get("Jack"));
            return false;
        }
        if (!"MIT".equals(map.get("Rose"))) {
            System.out.println("Expected MIT: but reuslt " +map.get("Rose"));
            return false;
        }
        return true;
    }
    
    private static boolean test(String type){
        MyMap map;
        if (type.equals("BST")) {
            map = new MyMapBSTImpl();
        } else if (type.equals("LL")) {
            map = new MyMapBSTImpl();
        }  else if (type.equals("Open hashing")) {
            map =  new MyMapOpenHashingImpl(1);
        } 
        else if (type.equals("Close hashing")) {
            map =  new MyMapCloseHashingImpl(16);
        } else {
            System.out.println("Invalid input");
            return false;
        }
        map.put("Jack","CMU");
        map.put("Rose","MIT");
        map.put("A","Standford");
        map.put("B","ASU");
        map.put("C","Harvard");
        map.put("D","PENN");
        map.put("E","UD");
        
        System.out.println(map.get("Jack"));
        System.out.println(map.get("Rose"));
        System.out.println(map.get("A"));
        System.out.println(map.get("B"));
        System.out.println(map.get("C"));
        System.out.println(map.get("D"));
        System.out.println(map.get("E"));
        
        if (!"CMU".equals(map.get("Jack"))) {
            System.out.println("Expected CMU: but reuslt " +map.get("Jack"));
            return false;
        }
        if (!"MIT".equals(map.get("Rose"))) {
            System.out.println("Expected MIT: but reuslt " +map.get("Rose"));
            return false;
        }
        map.put("Jack","Standford");
        if (!"Standford".equals(map.get("Jack"))) {
            System.out.println("Expected Standford: but reuslt " +map.get("Jack"));
            return false;
        }
        if (!"MIT".equals(map.get("Rose"))) {
            System.out.println("Expected MIT: but reuslt " +map.get("Rose"));
            return false;
        }
        return true;
    }
}