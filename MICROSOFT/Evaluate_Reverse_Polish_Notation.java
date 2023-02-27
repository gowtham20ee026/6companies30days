package MICROSOFT;
import java.util.*;
class ReversePolish {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums=new Stack<>(); 
        String operator="+-/*";
        
        for(int i=0;i<tokens.length;i++)
        {
            int first=0,second=0,c=0;
            if(!operator.contains(tokens[i]))
            {
                nums.push(Integer.parseInt(tokens[i]));
                
            }
            else
            {
                first=nums.pop();
                second=nums.pop();
                if(tokens[i].equals("+"))
                {
                    c=second+first;
                    nums.push(c);
                }
                else if(tokens[i].equals("-"))
                {
                    c=second-first;
                    nums.push(c);
                }
                else if(tokens[i].equals("*"))
                {
                    c=second*first;
                    nums.push(c);
                }
                else if(tokens[i].equals("/"))
                {
                    c=second/first;
                    nums.push(c);
                }
            }
        }
        return (nums.pop());
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        String arr1[]=st.split(",");
        System.out.println(evalRPN(arr1));

    }
}