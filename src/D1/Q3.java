package D1;

// There are N cities, and M routes[], each route is a path between two cities.
//routes[i] = [city1, city2], there is a travel route between city1 and city2.
//Each city is numbered from 0 to N-1.
//
//There are one or more Regions formed among N cities.
//A Region is formed in such way that you can travel between any two cities
//in the region that are connected directly and indirectly.
//
//Your task is to find out the number of regions formed between N cities.
//
//Input Format:
//-------------
//Line-1: Two space separated integers N and M, number of cities and routes
//Next M lines: Two space separated integers city1, city2.
//
//Output Format:
//--------------
//Print an integer, number of regions formed.
//
//
//Sample Input-1:
//---------------
//5 4
//0 1
//0 2
//1 2
//3 4
//
//Sample Output-1:
//----------------
//2
//
//
//Sample Input-2:
//---------------
//5 6
//0 1
//0 2
//2 3
//1 2
//1 4
//2 4
//
//Sample Output-2:
//----------------
//1
//
//Note: Look HINT for explanation.

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        DSUU d = new DSUU(n);
        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            d.union(u, v);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(d.parent[i]==i) count++;
        }
        System.out.println(count);
    }
}

class DSUU {
    public int[] size;
    public int[] parent;

    public DSUU (int n){
        this.size = new int[n];
        this.parent = new int[n];
        for(int i=0; i<n; i++){
            size[i]=1;
            parent[i] = i;
        }
    }

    public int find (int a){
        if(parent[a]==a) return a;
        return parent[a] = find(parent[a]);
    }

    public void union(int u, int v){
        int r1 = find(u);
        int r2 = find(v);
        if(r1==r2) return;
        if(size[r1]>=size[r2]){
            parent[r2] = r1;
            size[r1]+=size[r2];
        }else{
            parent[r1] = r2;
            size[r2]+=size[r1];
        }
    }
}


