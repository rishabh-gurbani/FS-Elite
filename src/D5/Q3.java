package D5;

// A transitive law is "If a == b and b == c, then a == c"
//Which also says "If a == b and b != c, then a != c"
//
//You will be given a list of strings relations[], i.e, like p==q or p!=q.
//Your task is to find out whether all the relations follow the transitive law or not.
//If all of them followed return true, otherwise return false.
//
//Input Format:
//-------------
//Space separated strnigs, list of relations
//
//Output Format:
//--------------
//Print a boolean value, whether transitive law is obeyed or not.
//
//
//Sample Input-1:
//---------------
//a==b c==d c!=e e==f
//
//Sample Output-1:
//----------------
//true
//
//
//Sample Input-2:
//---------------
//a==b b!=c c==a
//
//Sample Output-2:
//----------------
//false
//
//
//Sample Input-3:
//---------------
//a==b b==c c!=d d!=e f==g g!=d
//
//Sample Output-3:
//----------------
//true


import java.util.*;
public class Q3 {
    static int[] parent = new int[26];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] statements = line.split(" ");

        for(int i=0; i<26; i++) parent[i] = i;
        for(String s : statements){
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if(s.charAt(1) == '='){
                parent[a] = b;
            }
        }
        boolean flag = true;
        for(String s : statements){
            int a = s.charAt(0) - 'a';
            int b = s.charAt(3) - 'a';
            if(s.charAt(1) == '!'){
                int r1 = findParent(a);
                int r2 = findParent(b);
                if(r1==r2){
                    flag = false;
                    break;
                }
            }
        }
        System.out.println(flag);
    }

    static int findParent(int i){
        if(parent[i] == i) return i;
        return parent[i] = findParent(parent[i]);
    }
}
