import java.util.*;
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n=cost.length;
        int ans=0;
        int i=n-1;
        while(i>=0){
            ans+=cost[i]+( i>0? cost[i-1]:0);
            i-=3;

        }
        return ans;
    }
}
