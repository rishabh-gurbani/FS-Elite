package D2;

//Ibrahim is an interior designer wants to color wall of size M*N.
//He plans to color the wall and put lights of two different colors
//
//The designer can lit the wall using M*N lights.The lights are Blue or pink
//in color.Blue colored lights represented with digit-1 and pink colored lights
//represented with digit-0.
//
//The Blue colored lights forms different shapes, that are connected 4 directonally.
//The directons are upwards, downwards, left, and right. Ibrahim got an idea to
//count the unique shapes formed by blue colored lights.
//
//You will be given the decorated wall as a matrix wall[][].
//Your task is to help Ibrahim to count the unique shapes by the lights.
//
//Input Format:
//-------------
//Line-1: Two space separated integers M and N, size of the wall.
//Next M lines: N space separated integers, either 0 or 1.
//
//Output Format:
//--------------
//Print an integer, Number of distinct shapes formed by Blue Lights.
//
//
//Sample Input-1:
//---------------
//4 5
//1 1 0 1 1
//1 1 0 0 1
//0 0 0 0 0
//1 1 0 0 0
//
//Sample Output-1:
//----------------
//3
//
//
//Sample Input-2:
//---------------
//5 5
//1 1 0 1 1
//1 0 0 0 1
//0 0 0 0 0
//1 0 0 0 1
//1 1 0 1 1
//
//Sample Output-2:
//----------------
//4
//
//Note:
//-------
//The shapes,
//1 1  		  1 1
//1      and      1

import java.util.*;

public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();
        for(int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if(arr[i][j]==1 && !visited[i][j]) {
                    set.add(findIslands(arr, i, j, visited));
                }
            }
        }
        System.out.println(set.size());
    }

    // dfs bhi kar sakte
    static String findIslands(int[][] matrix, int r, int c, boolean[][]visited){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        // record track
        String[] dir = {"U", "D", "L", "R"};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        StringBuilder ans = new StringBuilder();
        visited[r][c] = true;
        while(!q.isEmpty()){
            int s = q.size();
            while(s>0){
                int[] pos = q.poll();

                for(int i=0; i<4; i++){
                    int[] next = dirs[i];
                    int nr = pos[0]+next[0];
                    int nc = pos[1]+next[1];
                    if(0<=nr && nr<rows && 0<=nc && nc<cols && matrix[nr][nc]==1 && !visited[nr][nc]){
                        visited[nr][nc]= true;
                        q.add(new int[]{nr, nc});
                        ans.append(dir[i]);
                    }
                }
                ans.append("b");
                s--;
            }
        }
        return ans.toString();
    }
}
