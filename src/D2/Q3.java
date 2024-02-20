package D2;

// Vihaar is working with strings.
//He is given two strings A and B, and another string T,
//where the length of A and B is same.
//
//You can find the relative groups of letters from A and B,
//using the following rule set:
//- Equality rule: 'p' == 'p'
//- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
//- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
//
//Vihaar has to form the relatively smallest string of T,
//using the relative groups of letters.
//
//For example, if A ="pqr" and B = "rst" ,
//then we have 'p' == 'r', 'q' == 's', 'r' == 't' .
//
//The relatives groups formed using above rule set are as follows:
//[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".
//
//You will be given the strings A , B and T.
//Your task is to help Vihaar to find the relatively smallest string of T.
//
//
//Input Format:
//-------------
//Three space separated strings, A , B and T
//
//Output Format:
//--------------
//Print a string, relatively smallest string of T.
//
//
//Sample Input-1:
//---------------
//kmit ngit mgit
//
//Sample Output-1:
//----------------
//ggit
//
//Explanation:
//------------
//The relative groups using A nd B are [k, n], [m, g], [i], [t] and
//the relatively smallest string of T is "ggit"
//
//
//Sample Input-2:
//---------------
//attitude progress apriori
//
//Sample Output-2:
//----------------
//aaogoog
//
//Explanation:
//------------
//The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
//the relatively smallest string of T is "aaogoog"


import java.util.*;


public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        String p = line[0];
        String q = line[1];
        String t = line[2];

        DSU d = new DSU();
        for(int i=0; i<p.length(); i++) {
            int pi = (int) p.charAt(i) - 97;
            int qi = (int) q.charAt(i) - 97;
            d.union(pi, qi);
        }

        StringBuilder ans = new StringBuilder();
        for(int i=0; i<t.length(); i++){
            int c = (int) t.charAt(i) - 97;
            int parent = d.find(c);
            ans.append((char) (parent + 97));
        }

        System.out.println(ans);
    }
}

class DSU {
    int[] parent;
    public DSU () {
        this.parent = new int[26];
        for(int i=0; i<26; i++){
            parent[i] = i;
        }
    }

    public int find(int u){
        if(parent[u]==u) return u;
        return parent[u] = find(parent[u]);
    }

    // DSU union based on lexicographical value instead of size/rank
    public void union (int u, int v){
        int r1 = find(u);
        int r2 = find(v);
        // smaller character becomes parent
        if(r1<=r2){
            parent[r2] = r1;
        }else{
            parent[r1] = r2;
        }
    }
}
