package D2;

// A game-zone is represented as an infinite 2D grid. At every integer coordinate
//(x,y) there is a bag, and the bag contains |x| + |y| number of chocolates in it.
//
//You want grab N chocolates for your kid. You have to select some square area in
//the game-zone such a way that the selected area is an axis-aligned square plot
//that is centered at (0, 0).
//
//Your task is to find the minimum perimeter of the square area such that
//at least it conains N chocolates are inside or on the perimeter of that area.
//
//NOTE:
//The value of |x| is defined as: x if x >= 0 -x if x < 0
//
//Constarint:
//-----------
//1 <= N <= 10^14
//
//Input Format:
//-------------
//An integer N, number of chocolates.
//
//Output Format:
//--------------
//Print an integer result.
//
//
//Sample Input-1:
//---------------
//5
//
//Sample Output-1:
//----------------
//8
//
//Explanation:
//------------
//
//
//Sample Input-2:
//---------------
//56
//
//Sample Output-2:
//----------------
//16
//
//Explanation:
//------------
//
//
//Sample Input-3:
//---------------
//62
//
//Sample Output-3:
//----------------
//24

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args){
//        Scanner sc= new Scanner(System.in);
//        long n  = sc.nextInt();
        long n = 432532;
        long s =0, e = ((int) Math.sqrt(n)) + 1, m;
        while(s<e){
            m = s+(e-s)/2;
            long areaM = area(m);
            // System.out.println(m+" "+areaM);
            if(m==n) {
                e=m;
                break;
            } else if (areaM<n){
                s=m+1;
            } else {
                e=m;
            }
        }
        System.out.println(perimeter(e));
        // System.out.println(area(n));
    }

    // recursive way
    // all numbers counted 8x except mid and corner
    // O(n)
//    static long area(long n) {
//        if(n==0) return 0;
//        long current = 0;
//        long limit = n*2;
//        for(long i=n; i<=limit; i++){
//            current+=8*i;
//        }
//        current = current - 4*n - 4*limit;
//        return current + area(n-1);
//    }

    // O(1)
    // formula given
    static long area(long n){
        return (long) (4*Math.pow(n, 3) + 6*Math.pow(n, 2) + 2*n);
    }

    static long perimeter(long n){
        return 8*n;
    }
}
