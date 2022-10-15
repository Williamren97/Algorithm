class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
    Stack<Character> stack = new Stack<Character>();
    for (char c : s.toCharArray()) {
        if (c =='(') {
            stack.push(')');
        }  else if (c == '{') {
            stack.push('}');
        }  else if (c == '[') {
            stack.push(']');
        } else if (stack.isEmpty() || c != stack.pop()) {
            //当不为左括号时候，说明c是右括号，stack.pop弹出栈元素中存储的右括号元素，比较这两个右括号是否相等。
            return false;
        }
    }
    if (stack.isEmpty()) {
        //判断相对情况下的第一个字符是否为’），｝，】‘这种类型的。
        //当stack为空时输入一个c=）时，stack内没有（与之对应，则认为false
            return true;
        } 
    return false;
    }
}

