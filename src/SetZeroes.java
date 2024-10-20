public class SetZeroes {
    //两个标记变量
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean col=false,row=false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0]==0){
                col=true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i]==0){
                row=true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j]==0)
                    matrix[i][0]=matrix[0][j]=0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if (col){
            for (int i = 0; i < m; i++) {
                matrix[i][0]=0;
            }
        }
        if (row){
            for (int i = 0; i < n; i++) {
                matrix[0][i]=0;
            }
        }

    }
    //使用一个标记变量
    public void setZeroes1(int [][]matrix){
        int m=matrix.length,n=matrix[0].length;
        boolean col=false;
        for (int i = 0; i < m; i++) {
            if (matrix[m][0]==0){
                col=true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j]==0){
                    matrix[i][0]=matrix[0][j]=0;
                }
            }
        }
        for (int i = m-1; i >=0 ; i--) {
            for (int j = 1; j <n; j++) {
                if (matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;

            }
            if (col){
                matrix[i][0]=0;
            }
        }
    }
}
