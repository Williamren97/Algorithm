//通过对比两map里单词出现的次数 比较2数组里面元素是否一样
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        wordsMap = new HashMap<>();
        int tot = 0; // words单词总长度
        for (String word : words) {
            tot += word.length();
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i + tot <= s.length(); i++) {
            // 看：s的从下标i开始的tot个字符构成的子串
            // 是不是由 words里的单词 按某种顺序串联形成的
            if (valid(s.substring(i, i + tot), words)) {
                ans.add(i);
            }
        }
        return ans;
    }

    //如果看words怎么拼成str,因为words顺序不固定，这样是阶乘的复杂度，所以这里用把str拆成k个words
    boolean valid(String str, String[] words) {
        // 设k=words每个单词的长度
        // 把子串str每k个字符分成一个单词
        // 一共形成一个单词数组，看跟words是否一样即可
        int k = words[0].length();//k是words里面单词长度，因为每个单词长度一样，所以取0
       //如何判断两个数组是否含有相同元素，？这里可以 把一个字符串看成一个字符数组，（类似力扣异构词那道题），两map一样，就包含相同元素，比较2map里面字符串出现的次数是否相同
        //复杂度是length of s * words.length，枚举所有起始位置，可以通过枚举部分起始位置+滑动窗口优化，（每次不移动1位，而是k位
        // 起始位置按照k的余数分组分为0组，1组,k-1组）（k是length of one world），0这一组，就是从下标0开始的起始位置，k,2k,3k,etc，第二行从下标1开始，1+k,1+2k,map插入删除都是0(1)，这样复杂度是length of s * o1(o1是length of one word)
        HashMap<String, Integer> h = new HashMap();
        for (int i = 0; i < str.length(); i += k) {
            String key = str.substring(i, i + k);//从i开始的k个字符
            //可以开一个数组，把截取出来的放进去，对比是否含有相同，对数组里的字符串快排，但这样复杂度是数组的长度，不是o1（字符串比较大小，需要逐一比对）
            h.put(key, h.getOrDefault(key, 0) + 1);
        }
        return h.equals(wordsMap);
    }

    HashMap<String, Integer> wordsMap;
};
// 请大家自行实现优化的解法
