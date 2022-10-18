class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
/*
{
    "aet": ["eat", "tea", "ate"],
    "ant": ["tan", "nat"],
    "abt": ["bat"]
}
*/
        HashMap<String, List<String>> groups = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String copy = new String(arr);
            if (!groups.containsKey(copy)) {
                groups.put(copy, new ArrayList<String>());
            }
            groups.get(copy).add(s);
        }
        List<List<String>> ans = new ArrayList<List<String>>();
        for (List<String> group : groups.values()) {
            ans.add(group);
        }
        return ans;
    }
}
