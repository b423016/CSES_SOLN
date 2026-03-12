package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class teams { // Note: CSES usually prefers the class name to be 'Main', but 'teams' often works if it's the only class. Change to 'Main' if you get a compile error.

    // 1. The FastReader template to beat the Time Limit Exceeded
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
    }

    public static void main(String[] args) {
        // Use FastReader instead of Scanner
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        bipartite(adj, n);
    }

    public static void bipartite(List<List<Integer>> adj, int n){
        int[] team = new int[n + 1];

        // 2. FIXED WRONG ANSWER: Loop from 1 to <= n
        for(int i = 1; i <= n ; i++){
            if(team[i] == 0){
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                team[i] = 1;

                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int nei : adj.get(curr)){
                        if(team[nei] == 0){
                            team[nei] = (team[curr] == 1) ? 2 : 1;
                            q.add(nei);
                        }
                        else if(team[nei] == team[curr]) {
                            // 3. FIXED WRONG ANSWER: ALL CAPS
                            System.out.println("IMPOSSIBLE");
                            return;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(team[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}