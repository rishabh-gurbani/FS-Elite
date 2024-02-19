package D1;

//Mr Suleman is given a checkerboard of size 400*400, where the indices starts
//from (-200,-200) and ends at (199,199). In one step, he can move the box from
//position (p,q) to one of the following positions in L shape like as follows:
//	- (p-2, q-1), (p-2, q+1), (p+2, q-1), (p+2, q+1)
//	- (p-1, q+2), (p+1, q+2), (p-1, q-2), (p+1, q-2)
//
//Initially the box is at (0,0) position, and need to move the box to position (m,n).
//You will be given two integers m and n indicates the position(m,n).
//
//Now your task is to help by Mr Suleman to find the minimum number of steps
//required to move the box from (0,0) to (m,n).
//
//Note: It is allowed to move out of the board also.
//
//Input Format:
//-----------------
//Two space separated integers, m and n, position.
//
//Output Format:
//------------------
//Print an integer, minimum number of steps to reach (m,n).
//
//
//Sample Input-1:
//---------------
//2 4
//
//Sample Output-1:
//----------------
//2
//
//Explanation:
//-------------
//Initially, you are at (0,0) position, you can reach (2,4) as follows:
//(0,0) -> (1, 2) -> (2, 4)
//
//
//Sample Input-2:
//---------------
//4 7
//
//Sample Output-2:
//----------------
//5
//
//Explanation:
//------------
//Initially, you are at (0,0) position, you can reach (4,7) as follows:
//(0,0) -> (1, 2) -> (2, 4) -> (1, 6) -> (3, 5) -> (4, 7)


import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ans = bfs(m+200, n+200);
        System.out.println(ans);
    }

    static int bfs (int m, int n){
        int[][] positions = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        Queue<int[]> q = new LinkedList<>();
        // carry the steps inside the array itself (3rd element)
        // no need for another variable (count/step)
        // useful both in bfs and dfs
        q.offer(new int[]{200, 200, 0});
        boolean[][] visited = new boolean[400][400];
        visited[200][200] = true;
        while(!q.isEmpty()){
            int s = q.size();
            while(s>0){
                int[] point = q.poll();
                for(int[] dir: positions){
                    int nx = point[0] + dir[0];
                    int ny = point[1] + dir[1];
                    if(0<=nx && nx<400 && 0<=ny && ny<400 && !visited[nx][ny]){
                        q.add(new int[]{nx, ny, point[2]+1});
                        // marking visited here itself is helpful when
                        // multiple chances of same element entering the queue
                        visited[nx][ny] = true;
                        if(nx==m && ny==n) return point[2]+1;
                    }
                }
                s--;
            }
        }
        return -1;
    }
}
