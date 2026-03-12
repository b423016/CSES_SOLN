package graph;

import java.util.*;

public class roads{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<=n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++ ){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        List<Integer> lead = new ArrayList<>();
        boolean[] vis = new boolean[n+1];
        for(int i =1 ; i<=n ; i++){
            if(!vis[i]){
                lead.add(i);
                dfs(i,adj,vis);
            }
        }
        System.out.println(lead.size()-1);
        for(int i = 0; i< lead.size()-1 ; i++){
            System.out.println(lead.get(i) +" "+ lead.get(i+1));
        }
    }
    public static void dfs(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis ){
        vis[i] = true;
        for(int nei : adj.get(i)){
            if(!vis[nei])
                dfs(nei, adj, vis);
        }

    }
}