package RAILWAY;
import java.util.*;
public class railway {
    public static HashMap<String,ArrayList<String>>train=new HashMap<>();
    public static HashMap<String,ArrayList<Integer>>trainstatus=new HashMap<>();
    public static int total=10;
    public static int waitmem=5;
    static ArrayList<String>waitinglist=new ArrayList<>();
    public static String arr[]={"coimbatore","thirupur","erode","salem","chennai"};
    public static HashMap<String,ArrayList<String>>wait=new HashMap<>();
    public static ArrayList<String>waitstr=new ArrayList<>();
    public static ArrayList<String>location=new ArrayList<>(Arrays.asList(arr));
    public static void main(String[] args) {
        Scanner sg=new Scanner(System.in);
         ArrayList<Integer> c1 =new ArrayList<Integer>();
        c1.add(10);              
        ArrayList<Integer>c2=new ArrayList<>();
        c2.add(10);  
        ArrayList<Integer>c3=new ArrayList<>();
        c3.add(10); 
        ArrayList<Integer>c4=new ArrayList<>();
        c4.add(10); 
        ArrayList<Integer>c5=new ArrayList<>();
        c5.add(10); 
      trainstatus.put("coimbatore",c1);
        trainstatus.put("thirupur",c2);
        trainstatus.put("erode",c3);
        trainstatus.put("salem",c4);
        trainstatus.put("chennai",c5);
        while(1>0)
        {
            System.out.println();
            System.out.println("Type 1 for sign up\nType 2 for log in");

            String userchoice=sg.nextLine();
            System.out.println();
            if(userchoice.equals("1"))
            {
                ArrayList<String>list=new ArrayList<>();
                System.out.println("Enter user name :");
                String username=sg.nextLine();
                if(!train.containsKey(username))
                {
                    System.out.println("Create password for your account "+username);
                    String password=sg.nextLine();
                    list.add(password);
                    list.add("0");
                    train.put(username,list);
                }
                else
                {
                    System.out.println("Account already created");
                }
            }
            else if(userchoice.equals("2"))
            {
                System.out.println("Enter user name of your account:");
                String username=sg.nextLine();
                if(train.containsKey(username))
                {
                    System.out.println("Enter password of your account:");
                    String password=sg.nextLine();
                    if(train.get(username).get(0).equals(password))
                    {
                        System.out.println("Account Found:");
                        System.out.println("The choice you have:\n1 to book\n2 to cancel ticket\n3 to check your tickets");
                        String bookchoice=sg.nextLine();
                        if(bookchoice.equals("1"))
                        {
                            System.out.println("Before Booking ");
                            System.out.println(trainstatus);
                            System.out.println();
                            System.out.println("type 1 for coimbatore");
                            System.out.println("type 2 for thirupur");
                            System.out.println("type 3 for erode");
                            System.out.println("type 4 for salem");
                            System.out.println("type 5 for chennai");
                            System.out.println("Enter the boarding station :");
                            int board=Integer.parseInt(sg.next())-1;
                            System.out.println("Enter the destination station :");
                            int desni=Integer.parseInt(sg.next())-1;
                            System.out.println("Enter the number of tickets you want :");
                            int seatsneed=Integer.parseInt(sg.next());        
                            int mini=1000;
                            for(int k=board;k<desni;k++)
                            {
                                mini=(int)Math.min(mini,trainstatus.get(location.get(k)).get(0));
                            }
                            int minic=mini;
                                if(minic>seatsneed)
                                {
                                    minic=seatsneed;
                                }
                               for(int k=board;k<desni;k++)
                               {
                                if(trainstatus.get(location.get(k)).get(0)-minic>=0)
                                {
                                trainstatus.get(location.get(k)).set(0,trainstatus.get(location.get(k)).get(0)-minic);
                                }
                               }
                               if(waitmem!=0&&seatsneed>minic)
                               {
                                if(!wait.containsKey(username))
                                {
                                    wait.put(username,new ArrayList<String>());
                                    wait.get(username).add("0,0,0,0");
                                }
                               if(waitmem-(seatsneed-mini)>0)
                               {
                               waitstr.add(username);
                               waitmem-=(seatsneed-minic);
                               wait.get(username).add(board+","+desni+","+minic+","+(seatsneed-mini));
                               }
                               else if(waitmem!=0)
                                {
                                    int avai=waitmem;
                                    int dif=(seatsneed -minic)-waitmem;
                                    waitmem=0;
                                    waitstr.add(username);
                                    wait.get(username).add(board+","+desni+","+(seatsneed-(seatsneed-minic))+","+(avai));
                                    System.out.println("the "+dif+" cant book");
                                }
                            }
                            System.out.println("After Booking ");
                            System.out.println(trainstatus);
                            System.out.println(wait);
                            System.out.println(waitstr);

                        }  
                        else if(bookchoice.equals("2"))
                        {
                            System.out.println("type 1 for coimbatore");
                            System.out.println("type 2 for thirupur");
                            System.out.println("type 3 for erode");
                            System.out.println("type 4 for salem");
                            System.out.println("type 5 for chennai");
                               System.out.println("Enter board cancel");
                               int b=sg.nextInt()-1;
                               System.out.println("Enter deni cancel");
                               int de=sg.nextInt()-1;
                               System.out.println(" Enter the no of tickets to cancel");
                               int cancel=sg.nextInt();
                                for(int a=b;a<de;a++)
                                {
                                trainstatus.get(location.get(a)).set(0,trainstatus.get(location.get(a)).get(0)+cancel);
                                }
                                if(waitstr.size()>0)
                                {
                                    for(int j=0;j<waitstr.size();j++)
                                    {
                                            String ch[]=wait.get(waitstr.get(j)).get(1).split(",");
                                            int mini=1000;
                                            for(int k=Integer.parseInt(ch[0]);k<Integer.parseInt(ch[1]);k++)
                                            {
                                                mini=(int)Math.min(mini,trainstatus.get(location.get(k)).get(0));
                                            }
                                            int minic=mini;
                                            int seatsneed=Integer.parseInt(ch[3]);
                                                if(minic>=seatsneed)
                                                {
                                                    minic=seatsneed;
                                                }
                                               for(int k=Integer.parseInt(ch[0]);k<Integer.parseInt(ch[1]);k++)
                                               {
                                                if(trainstatus.get(location.get(k)).get(0)-minic>=0)
                                                {
                                                trainstatus.get(location.get(k)).set(0,trainstatus.get(location.get(k)).get(0)-minic);
                                                }
                                               }
                                               if(Integer.parseInt(ch[3])-minic<=0&&minic>0)
                                               {
                                                waitmem+=Integer.parseInt(ch[3]);
                                                wait.get(waitstr.get(j)).remove(1);
                                                int ind=waitstr.indexOf(waitstr.get(j));
                                                waitstr.remove(ind);
                                               }
                                               else
                                               {
                                                waitmem+=Integer.parseInt(ch[3])-minic;
                                                String u=ch[0]+","+ch[1]+","+ch[2]+","+(Integer.parseInt(ch[3])-minic);
                                                wait.get(waitstr.get(j)).set(1,u);
                                               }
                                
                                        }
                                    }
                                    System.out.println(trainstatus);
                                    System.out.println(waitstr);
                                    System.out.println(wait);
                               }
                    }
                    else{
                        System.out.println("Wrong username or password");
                    }
                            }
                            }
                        }
        }
   }
    

