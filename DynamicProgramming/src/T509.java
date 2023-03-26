public class T509 {
    public int fib(int n) {
        //压缩版本
        if(n<=1)
            return n;
        int a=0,b=1,c=0;
        for (int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;

        //非压缩版本
        /*if(n<=1)
            return n;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];*/

        //递归版本
        /*if (n<=1)
            return n;
        return fib(n-1)+fib(n-2);*/
    }
}
