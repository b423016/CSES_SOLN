package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class roundtrip {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static boolean[] vis;
    static int[] par;
    static List<List<Integer>> adj;
    static int start = -1, end = -1;

    public static void main(String[] args) {

        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        adj = new ArrayList<>();

        for(int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        vis = new boolean[n+1];
        par = new int[n+1];

        for(int i = 1; i <= n; i++){
            if(!vis[i] && dfs(i,-1)) break;
        }

        if(start == -1){
            System.out.println("IMPOSSIBLE");
            return;
        }

        List<Integer> path = new ArrayList<>();

        int v = end;

        while(v != start){
            path.add(v);
            v = par[v];
        }

        path.add(start);
        Collections.reverse(path);
        path.add(start);

        System.out.println(path.size());

        StringBuilder sb = new StringBuilder();
        for(int x : path) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    public static boolean dfs(int u, int p){
        vis[u] = true;
        par[u] = p;

        for(int v : adj.get(u)){
            if(v == p) continue;

            if(vis[v]){
                start = v;
                end = u;
                return true;
            }

            if(!vis[v] && dfs(v,u))
                return true;
        }

        return false;
    }
}