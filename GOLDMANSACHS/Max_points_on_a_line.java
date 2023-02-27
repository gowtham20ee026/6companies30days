package GOLDMANSACHS;
import java.util.*;
public class Max_points_on_a_line {
    public int maxPoints(int[][] p) {
        int n=p.length;
        if(n<=2)return n;
        int max=2;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int count=2;
                for(int k=j+1;k<n;k++){
                    int x=(p[j][1]-p[i][1])*(p[k][0]-p[i][0]);
                    int y=(p[k][1]-p[i][1])*(p[j][0]-p[i][0]);
                    if(x==y){
                        count++;
                    }
                }
                if(count>max){
                    max=count;
                }
            }
        }
        return max;
    }
}