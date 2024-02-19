package D1;

public class DSU_Implement {
}

class DSU {
    int[] rank;
    int[] parent;
    int[] size;

    public DSU (int n){
        this.rank = new int[n];
        this.parent = new int[n];
        this.size = new int[n];
        for(int i=0; i<=n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findP(int n){
        if(parent[n]==n) return n;
        return parent[n] = findP(parent[n]);
    }

    public void unionByRank(int a, int b){
        int r1 = findP(a);
        int r2 = findP(b);
        if(r1==r2) return;
        if(rank[r1] >= rank[r2]){
            parent[r2] = r1;
            if(rank[r1]==rank[r2]) rank[r1] += 1;
        } else{
            parent[r1] = r2;
        }
    }

    public void unionBySize(int a, int b){
        int r1 = findP(a);
        int r2 = findP(b);
        if(r1==r2) return;
        if(size[r1]>=size[r2]){
            parent[r2] = r1;
            size[r1] += size[r2];
        } else {
            parent[r1] = r2;
            size[r2] += size[r1];
        }
    }
}
