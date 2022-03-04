package code1;

//递归（非常慢）
public class code1 {
    public String countAndSay(int n) {
        StringBuilder s = new StringBuilder();
        if (n == 1) {
            return "1";
        }
        char temp = '0';
        int count = 0;
        String sFormer = countAndSay(n - 1);
        for (int i = 0; i < sFormer.length(); i++) {
            count = 0;
            temp = sFormer.charAt(i);
            while (i < sFormer.length() && sFormer.charAt(i) == temp) {
                i++;
                count++;
            }
            i--;
            char ap = (char)('0' + count);
            s.append(ap);
            s.append(countAndSay(n - 1).charAt(i));
        }
        return s.toString();
    }
}
