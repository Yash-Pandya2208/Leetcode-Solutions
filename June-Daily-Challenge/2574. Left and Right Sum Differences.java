class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[]leftsum=new int[nums.length];
        int[]rightsum=new int[nums.length];

        leftsum[0]=0;
        rightsum[0]=0;
        int sum=0;
        for(int i=1;i<nums.length;i++){
            leftsum[i]=leftsum[i-1]+nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            rightsum[i]=rightsum[i+1]+nums[i+1];
        }
        int[]ans=new int[leftsum.length];

        for(int i=0;i<leftsum.length;i++){
            ans[i]=Math.abs(leftsum[i]-rightsum[i]);
        }
        return ans;        
    }
}
