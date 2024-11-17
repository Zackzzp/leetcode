import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Partition {
    boolean[][] f;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    int [][]f1;

    //动态规划+回溯
    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = (s.charAt(i) == s.charAt(j) && f[i + 1][j - 1]);
            }
        }
        dfs(s, 0);
        return ret;

    }

    private void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; j++) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    //记忆化搜索+回溯
    public List<List<String>> partition1(String s){
        n=s.length();
        f1=new int [n][n];
        dfs1(s,0);
        return ret;
    }
    private void dfs1(String s,int i){
        if (i==n){
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j <n ; j++) {
            if (isPalindrome(s,i,j)==1){
            ans.add(s.substring(i,j+1));
            dfs1(s,j+1);
            ans.remove(ans.size()-1);
            }
        }

    }

    public int isPalindrome(String s,int i,int j){
        if (f1[i][j]!=0){
            return f1[i][j];
        }
        if (i>=j){
            f1[i][j]=1;
        }
        else if (s.charAt(i)==s.charAt(j)){
            f1[i][j]=isPalindrome(s,i+1,j-1);
        }
        else f1[i][j]=-1;

        return f1[i][j];
    }
}
