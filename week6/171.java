public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        
        // write your code here
        if (strs == null || strs.length == 0) {
            return null;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String str: strs) {
            char[] cstr = str.toCharArray();
            Arrays.sort(cstr);
            String sortedString =new String(cstr);
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(str);
        }
        
        for (List<String> item : map.values()) {
            if (item.size() > 1) {
                ans.addAll(item);
            }
        }
        return ans;
    }
}