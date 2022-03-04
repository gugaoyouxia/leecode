package code1;

//循环
public class code2 {
    public String countAndSay(int n){
        if(n == 1){
            return "1";
        }
        StringBuilder s = new StringBuilder();
        s.append("1");
        int count,temp;
        for(int i = 1; i < n; i++){
            StringBuilder sr = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                String sFormer = s.toString();
                count = 0;
                temp = sFormer.charAt(j);
                while (j < sFormer.length() && sFormer.charAt(j) == temp) {
                    j++;
                    count++;
                }
                j--;
                char ap = (char)('0' + count);
                sr.append(ap);
                sr.append(sFormer.charAt(j));
            }
            s = sr;
        }
        return s.toString();
    }
}
