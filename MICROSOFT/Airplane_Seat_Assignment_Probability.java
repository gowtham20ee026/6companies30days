package MICROSOFT;
import java.util.Scanner;

class Solution {
    public static double nthPersonGetsNthSeat(int n) {
        if(n==1)
        {
            return (double)1.0000;
        }
        else
        {
            double res=(double)1/(double)2;
        return res;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println(nthPersonGetsNthSeat(a));

    }
}

