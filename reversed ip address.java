class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        addDots(s,0, 0, new StringBuilder(), ans);
        return ans;
    }
    
    public void addDots(String s, int index, int dots,  StringBuilder path, List<String> ans){
        String[] temp = s.split("\\.");
        if(dots == 3){
            String segment = s.substring(index);
            if (!isInvalid(segment)) {
                ans.add(path.toString() + segment);
            }
            return;
        }
        for(int len = 1; len <= 3; len++) {
            if (index + len > s.length()) return;

            String segment = s.substring(index, index + len);
            if (isInvalid(segment)) continue;

            int before = path.length();
            path.append(segment).append(".");
            addDots(s, index + len, dots + 1, path, ans);
            path.setLength(before); 
        }
    }
    
    public boolean isInvalid(String s){
        if (s.length() > 1 && s.charAt(0) == '0') return true;
        if(s.isEmpty()) return true;
        long val = Long.parseLong(s);
        return val > 255;
    }
}


// ... 2.5525511135
//     .. 2.5.525511135
// ..      . 2.5.5.25511135
//         x 25511135 > 255 --> backtrack
//         . 2.5.52.55... X
//         . 2.5.525. ... X (no more checking because 525 exceeded 255)
//         .. X
//     .. 2.52.
//         ----
//     2.525.
//         X
