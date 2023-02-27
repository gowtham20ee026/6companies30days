package MICROSOFT;
import java.util.*;
class happyprefix {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int len=0; 
        int lps[]=new int[s.length()];
        lps[0]=0;
        int i=1;
        while(i<s.length())
        {
            if((s.charAt(i)+"").equals(s.charAt(len)+""))
            {
                len++;
                lps[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len=lps[len-1];
                }
                else
                {
                    lps[i]=0;
                    i++;
                }
            }
        }
        
            int res_val=lps[lps.length-1];
            System.out.println(s.substring(0,res_val));
    }
}