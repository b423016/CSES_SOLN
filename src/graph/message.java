package graph;

import java.io.*;
import java.util.*;

public class message {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        solve(sc);
    }

    private static void solve(FastReader sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i<=n ;i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] parent = new int[n+1];
        boolean[] vis = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        vis[1] = true;
        parent[1] = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == n) break;
            for(int nei : graph.get(curr)){
                if(!vis[nei]){
                    vis[nei] = true;
                    parent[nei] = curr;
                    q.add(nei);
                }
            }
        }
        //path reconstruct
        if(!vis[n])
            System.out.println("IMPOSSIBLE");
        else{
            List<Integer> res = new ArrayList<>();
            int curr = n;
            while(curr != 0){
                res.add(curr);
                curr = parent[curr];
            }
            System.out.println(res.size());
            Collections.reverse(res);
            for( int node : res){
                System.out.print(node + " ");
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}