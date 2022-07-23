// https://practice.geeksforgeeks.org/problems/levels-of-game/1

//approach 1
static int rules[][]={{3,2},{-5,-10},{-20,5}};
    public static int maxLevel(int h,int m) {
        int dp[][]=new int[2*2000][2*2000];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        int ans=solve(h,m,dp,-1);
        return ans==-1?0:ans;
    }
    public static int solve(int h,int m,int dp[][],int turn){
        if(h<=0 || m<=0)    return -1;
        if(dp[h][m]!=-1)    return dp[h][m];
        int ans=0;
        for(int i=0;i<3;i++){
            if(turn==i) continue;
            ans=Math.max( ans, 1+solve(h+rules[i][0],m+rules[i][1],dp,i) );
        }
        return dp[h][m]=ans;
    }

_________________________________________________________________________________________________________________________________________________________________
//approach 2

public static int maxLevel(int h,int m) {
        int level=0;
        int fh=3, fm=2, sh= -5, sm= -10, th= -20, tm=5;
        int f_flag=1, s_flag=1, t_flag=1;
        while(h>0 && m>0){
            if(h+fh>0 && m+fm>0 && f_flag==1){
                h=h+fh; m=m+fm; level++; //print("first",h,m, level);
                f_flag=0; s_flag=1; t_flag=1;
            }
            else if(h+sh>0 && m+sm>0 && s_flag==1){
                h=h+sh; m=m+sm; level++; //print("second",h,m, level);
                f_flag=1; s_flag=0; t_flag=1;
            }
            else if(h+th>0 && m+tm>0 && t_flag==1){
                h=h+th; m=m+tm; level++; //print("third",h,m, level);
                f_flag=1; s_flag=1; t_flag=0;
            }
            else break;
            //System.out.println("level is:"+level);
        }
        return level;
    }
