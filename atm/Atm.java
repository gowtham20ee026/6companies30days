package atm;
import java.util.*;
public class Atm {
    public static HashMap<String,ArrayList<String>>account=new HashMap<>();
      public static HashMap<String,Integer>atmamount=new HashMap<>();
      public static int total=0;
    public static String mini=",";
    public static void main(String[] args) {
        Scanner sg=new Scanner(System.in); 
        int user=1;
        atmamount.put("2000",0);
        atmamount.put("500",0);
        atmamount.put("200",0);
        atmamount.put("100",0);
        while(1>0)
        {
            System.out.println();
        System.out.println("Enter 1 for Admin Actions(Load amount and add user option) \nEnter 2 for user Actions\nEnter 3 for exit\nEnter 4 for atm balance");
        System.out.println("Enter Your Choice :");
        String choice=sg.nextLine();
        System.out.println();
        if(choice.equals("1"))
        {
            System.out.println("Type  load amount for loading purpose\nType add user to add account to their bank\nType exit in user id to exit");
            String action=sg.nextLine();
            System.out.println();
            if(action.equals("add user"))
            {
        while(1>0)
        {
            System.out.println("Enter user id "+user+": ");
            String name=sg.nextLine();
            if(!name.equals("exit"))
            {
                if(!account.containsKey(name))
                {
                    ArrayList<String>up=new ArrayList<>();
                    System.out.println("Enter Pin for your account: ");
                    String password=sg.nextLine();
                    up.add(password);
                    up.add("0");
                    up.add("");
                    account.put(name,up);
                }
                else
                {
                System.out.println("Enter Unique id names to avoid faults in your transaction");
                if(user>1)
                user--;
                }
            }
            else
            break;
            user++;
        }
      //  System.out.println(account);
    }
    else if(action.equals("load amount"))
    {
        int array[]=new int[2000+1];
        int pretot=total;
        System.out.println("Enter the total amount that you are going to deposit :");
        int banktot=sg.nextInt();
        System.out.println("Enter loading amount in spicific credentials");
        System.out.println("Enter multiples of 2000 :");
        int twok=sg.nextInt();
        array[2000]=twok;
        total+=twok*2000;
        System.out.println("Enter multiples of 500 :");
        int five=sg.nextInt();
        array[500]=five;
        total+=five*500;
        System.out.println("Enter multiples of 200 :");
        int two=sg.nextInt();
        array[200]=two;
        total+=two*200;
        System.out.println("Enter multiples of 100");
        int one=sg.nextInt();
        total+=one*100;
        array[100]=one;
        sg.nextLine();
        if(banktot==total-pretot)
        {
            atmamount.put("2000",atmamount.get("2000")+array[2000]);
            atmamount.put("500",atmamount.get("500")+array[500]);
            atmamount.put("200",atmamount.get("200")+array[200]);
            atmamount.put("100",atmamount.get("100")+array[100]);
        System.out.println("Total amount in the ATM :"+total);
        System.out.println(atmamount);
        }
        else
        {
        System.out.println("Check the Credentials you have entered");
        total-=total-pretot;
        }
    }
    else
    {
        System.out.println("Enter the vaild choice");
    }
    }//if of admin action completes
    else if(choice.equals("2"))//starts the user block 
    {
        ArrayList<String>ke=new ArrayList<>(account.keySet());
        if(account.size()>0)
        {
        System.out.println("THE ID ALREADY REGISTERED :");
        for(int l=0;l<ke.size();l++)
        {
            System.out.println("the id "+(l+1)+": "+ke.get(l));
        }
    }

        System.out.println("Enter the user id :");
        String userid=sg.nextLine();
        System.out.println("Enter the pin of your id :");
        String userpass=sg.nextLine();
        callfunc(userid,userpass);
       
    }
    else if(choice.equals("3"))
    break;
    else if(choice.equals("4"))
    {
        System.out.println("The Atm balance: "+total);
        System.out.println(atmamount);
    }
    else
    {
        System.out.println("Enter the vaild choice:");
    }
}//infinte loop to run up to end
        
    }
    public static void callfunc(String userid,String userpass)
    {
        Scanner sg=new Scanner(System.in);
        if(account.containsKey(userid)&&account.get(userid).get(0).equals(userpass))//if id present
        {
            System.out.println();
            System.out.println("ACCOUNT FOUND");
            System.out.println("enter 1 for cash widthdrawal");
            System.out.println("enter 2 for Deposit");
            System.out.println("enter 3 for check balance");
            System.out.println("enter 4 for change pin");
            System.out.println("enter 5 for Transfer amount");
            System.out.println("enter 6 for mini statement");
            System.out.println("enter exit for close transaction");
            System.out.println("Enter the user action you want to perform");
            String userchoice=sg.nextLine();
            if(userchoice.equals("1"))
            {
                System.out.println("Enter the amount to widthdraw :");
                int width=sg.nextInt();
                ArrayList<String>arr=new ArrayList<>(atmamount.keySet());
                int j=0;
                    if(width%100==0)
                    {
                        for(int i=arr.size()-1;i>=0;i--)
                        {
                            String temp=arr.get(i);
                            if(Integer.parseInt(account.get(userid).get(1))>=width&&atmamount.get(temp)>0&&Integer.parseInt(temp)<=width)
                            {
                                total=total-Integer.parseInt(temp);
                                atmamount.put(temp,atmamount.get(temp)-1);
                                account.get(userid).set(1,Integer.parseInt(account.get(userid).get(1))-Integer.parseInt(temp)+"");
                                width-=Integer.parseInt(temp);
                                i++;
                                account.get(userid).set(2,account.get(userid).get(2)+(width+" amount widthdrawan from your account"+userid+","));
                                j++;
                            }
                        }
                        if(j!=0)
                        {
                            System.out.println("The amount widthdrawan succesfully");
                        System.out.println("The balance available in your account "+userid+": "+account.get(userid).get(1));
                        }
                        else
                        System.out.println("Invalid transaction");

                    }
                    else{
                        System.out.println("Enter amount in multiples of 100");
                    }
            }
            else if(userchoice.equals("2"))
            {
                int array[]=new int[2000+1];
                int pretot=total;
                System.out.println("Enter the total amount that you are going to deposit :");
                int banktot=sg.nextInt();
                System.out.println("Enter loading amount in spicific credentials");
                System.out.println("Enter multiples of 2000 :");
                int twok=sg.nextInt();
                array[2000]=twok;
                total+=twok*2000;
                System.out.println("Enter multiples of 500 :");
                int five=sg.nextInt();
                array[500]=five;
                total+=five*500;
                System.out.println("Enter multiples of 200 :");
                int two=sg.nextInt();
                array[200]=two;
                total+=two*200;
                System.out.println("Enter multiples of 100");
                int one=sg.nextInt();
                total+=one*100;
                array[100]=one;
        if(banktot==total-pretot)
        {
            atmamount.put("2000",atmamount.get("2000")+array[2000]);
            atmamount.put("500",atmamount.get("500")+array[500]);
            atmamount.put("200",atmamount.get("200")+array[200]);
            atmamount.put("100",atmamount.get("100")+array[100]);
        System.out.println("Total amount in the ATM :"+total);
        System.out.println(atmamount);
        account.get(userid).set(2,account.get(userid).get(2)+banktot+" amount is deposited in your account "+userid+",");
        account.get(userid).set(1,Integer.parseInt(account.get(userid).get(1))+(total-pretot)+"");
        sg.nextLine();
        }
        else
        {
        System.out.println("Check the Credentials you have entered");
        total-=total-pretot;
        }
            }
            else if(userchoice.equals("3"))
            {
                System.out.println("the balance of your account named with "+userid+" is"+"= "+account.get(userid).get(1));
            }
            else if(userchoice.equals("4"))
            {
                System.out.println("Enter the old pin of your account");
                String oldpin=sg.nextLine();
                if(oldpin.equals(userpass))
                {
                    System.out.println("Enter the new pin to your account:");
                    String newpin=sg.nextLine();
                    account.get(userid).set(0,newpin);
                    userpass=newpin;
                    System.out.println("PIN CHANGED SUCCESSFULLY");
                }
            }
            else if(userchoice.equals("5"))
            {
                System.out.println("Enter the userid to transfer amount to other account:");
                String transid=sg.nextLine();
                if(account.containsKey(transid))
                {
                    System.out.println("Enter the amount to transfer:");
                    int transamount=Integer.parseInt(sg.nextLine());
                    if(Integer.parseInt(account.get(userid).get(1))>=transamount)
                    {
                        account.get(userid).set(1,Integer.parseInt(account.get(userid).get(1))-transamount+"");
                        account.get(transid).set(1,Integer.parseInt(account.get(transid).get(1))+transamount+"");
                        account.get(userid).set(2,account.get(userid).get(2)+(transamount +" amount is transferred from "+userid+" to the account "+transid+","));
                        account.get(transid).set(2,account.get(transid).get(2)+(transamount +" amount is deposited from "+userid+" to your account "+transid+","));
                        
                        System.out.println("AMOUNT TRANSFERRED SUCCESFULLY");
                        System.out.println("The available balance is "+account.get(userid).get(1));
                    }
                    else
                    System.out.println("Insufficient balance in your account");
                }
                else
                System.out.println("No userid found");

            }
            else if(userchoice.equals("6"))
            {
                System.out.println("MINI STATEMENT OF YOUR ACCOUNT "+userid);
                String arrr[]=account.get(userid).get(2).split(",");
                for(int k=arrr.length-1;k>=arrr.length-1-5&&k>=0;k--)
                {
                    System.out.println(arrr[k]);
                }
            }
            else if(userchoice.equals("exit"))
            {
                
                return;
            }
            else
            {
                System.out.println("Enter the vaild choice:");
            }
        }
        else//id is present or not
        {
            System.out.println("User id /Password may be wrong or you had no account in our bank ");
            return;
        }
        callfunc(userid, userpass);
    }
}

