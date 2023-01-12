import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.lang.ClassNotFoundException;

class Graph{
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;
    public Graph(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for(int i=0; i<V; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j){
        adj[i].add(j);
        adj[j].add(i);
    }

    public void bfs(int s){
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        vis[s] = true;

        while(!q.isEmpty()){
            int j = q.poll();
            System.out.print(j +  " ");
            for(int i : adj[j]){
                if(!vis[i]){
                    vis[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public void dfs(int s){
        boolean[] vis = new boolean[V];
        for(int i=0; i<V; i++){
            if(!vis[i])
                dfsRecur(s, vis); // adj,list 
        }
    }

    public void dfsRecur(int s, boolean[] vis){
        vis[s] = true;
        System.out.print(s + " ");
        for(int i : adj[s]){
            if(!vis[i]){
                dfsRecur(i, vis);
            }
        }
    }

    public void dfsIterative(int s, boolean[] vis){
        Stack<Integer> st = new Stack<>();
        st.push(s);
        while(!st.isEmpty()){
            int j = st.pop();
            if(!vis[j]){
                vis[j] = true;
                System.out.print(j +  " ");
                List<Integer> temp = adj[j];
                for(int i=temp.size()-1; i>=0; i--){
                    int x = temp.get(i);
                    if(!vis[x])
                        st.push(x);
                }
            }
        }
    }

    public static void main(String[] args){
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(2, 4);
        g.dfs(0);
    }
    
}
