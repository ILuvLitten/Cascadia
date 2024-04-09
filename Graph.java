public class Graph {
    public int V;
    public int E;
    public int[][] adj;
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new int[V][V];
    }
    public void addEdge(int v, int w) {
        adj[v][w] = 1;
        adj[w][v] = 1;
        E++;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + "\n");
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public void removeEdge(int v, int w) {
        adj[v][w] = 0;
        adj[w][v] = 0;
        E--;
    }
    public static int degree(Graph G, int v) {
        int degree = 0;
        for (int w : G.adj[v]) {
            if (w == 1) {
                degree++;
            }
        }
        return degree;
    }
    public static int maxDegree(Graph G) {
        int max = 0;
        for (int v = 0; v < G.V; v++) {
            if (degree(G, v) > max) {
                max = degree(G, v);
            }
        }
        return max;
    }
    public static int avgDegree(Graph G) {
        return 2 * G.E / G.V;
    }
    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        for (int v = 0; v < G.V; v++) {
            for (int w : G.adj[v]) {
                if (w == v) {
                    count++;
                }
            }
        }
        return count / 2;
    }




}
