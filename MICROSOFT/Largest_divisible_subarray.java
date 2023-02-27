package MICROSOFT;
import java.util.*;
class subarray {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        var dp=new int[nums.length];
        return construction(nums,dp,LDSsize(nums,dp));
    }
    private static int LDSsize(int nums[],int dp[])
    {
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        var ldsize=1;
        for(var i=1;i<nums.length;i++)
        {
            for(var j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0)
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ldsize=Math.max(dp[i],ldsize);
                }
            }
        }
        return ldsize;
    }
    private static List<Integer> construction(int nums[],int[] dp,int ldsize)
    {
        var prev=-1;
        var lds=new LinkedList<Integer>();
        for(var i=dp.length-1;i>=0;i--)
        {
            if(dp[i]==ldsize && (prev==-1 || prev%nums[i]==0))
            {
                lds.addFirst(nums[i]);
                ldsize--;
                prev=nums[i];
            }
        }
        return lds;
    }
     public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(largestDivisibleSubset(arr));
    }
}