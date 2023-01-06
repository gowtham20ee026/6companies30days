import java.util.*;
import java.io.*;
public class mst {
    public static int mi(int key[],boolean vis[])
    {
        int min=Integer.MAX_VALUE;
        int index=-1;
        for(int i=0;i<key.length;i++)
        {
            if(key[i]<min&&vis[i]==false)
            {
                min=key[i];
                index=i;
            }
        }
        System.out.println("index "+index);
        return index;
    }
    public static void main(String[] args) {
        int vertices=5;
        int graph[][]={{0,2,0,6,0},{2,0,3,8,5},{0,3,0,0,7},{6,8,0,0,9},{0,5,7,9,0}};
        int key[]=new int[vertices];
        for(int i=0;i<key.length;i++)
            key[i]=Integer.MAX_VALUE;
        key[0]=0;
        boolean vis[]=new boolean[vertices];
        int parent[]=new int[vertices];
       for(int j=0;j < (vertices-1) ;j++)
       {
        int u= mi(key,vis);
        vis[u]=true;
        for(int h=0;h<vertices;h++)
        {
        if(graph[u][h] != 0 && vis[h] == false && graph[u][h] < key[h])
        {
            key[h]=graph[u][h];
            parent[h]=u;
        }
    }
       }
       for(int k=1;k<vertices;k++)
       {
        System.out.println(parent[k]+"-"+k+" "+graph[k][parent[k]]);
       }
       



    }
    
}
