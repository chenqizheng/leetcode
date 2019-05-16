package com.chen.nowcoder;

import java.util.HashMap;
import java.util.Stack;

public class JSONParser {


    public static void main(String[] args) {
        JSONObject jsonObject = new JSONParser().parse("{\"k1\":\"v1\",\"k2\":\"v2\",\"k3\":{\"k4\":\"v4\"}");
        System.out.print(jsonObject);
    }

    public JSONObject parse(String json) {
        Stack<JSONObject> stack = new Stack<>();
        int index = 0;
        String lastKey = null;
        char[] chars = json.toCharArray();
        while (index < json.length()) {
            if (chars[index] == '{') {
                if(lastKey != null ){
                    JSONObject parent = stack.peek();
                    parent.map.put(lastKey, new JSONObject());
                    stack.push((JSONObject) parent.map.get(lastKey));
                    lastKey = null;
                } else {
                    stack.push(new JSONObject());
                }
                index++;
            } else if (chars[index] == '}') {
                stack.pop();
                index++;
            } else if (chars[index] == '"') {
                int next = findNextChar(chars, index + 1, '"');
                if (lastKey == null) {
                    lastKey = json.substring(index + 1, next);
                } else {
                    String value = json.substring(index + 1, next);
                    JSONObject current = stack.peek();
                    current.map.put(lastKey, value);
                    lastKey = null;
                }
                index = next + 1;
            } else {
                index++;
            }
        }
        return stack.pop();
    }

    private int findNextChar(char[] chars, int start, char target) {
        for (int i = start; i < chars.length; i++) {
            if (chars[i] == target) {
                return i;
            }
        }
        return -1;

    }

    class JSONObject {
        private HashMap<String, Object> map = new HashMap<>();

        public String getString(String key) {
            return (String) map.get(key);
        }

        public JSONObject getJSONObject(String key) {
            return (JSONObject) map.get(key);
        }

    }
}
