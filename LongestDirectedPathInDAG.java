import java.util.*;

class Vertex {
    long id;

    Vertex(long id) {
        this.id = id;
    }
}

class Edge {
    Vertex from;
    Vertex to;

    Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }
}

public class LongestDirectedPathInDAG {
    private Map<Vertex, List<Edge>> graph;

    LongestDirectedPathInDAG() {
        graph = new HashMap<>();
    }

    public void addEdge(Vertex from, Vertex to) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Edge(from, to));
    }

    public int longestPath(Vertex source) {
        Map<Vertex, Integer> memo = new HashMap<>();
        int longestPath = 0;

        for (Vertex vertex : graph.keySet()) {
            longestPath = Math.max(longestPath, dfs(vertex, memo));
        }

        return longestPath;
    }

    private int dfs(Vertex source, Map<Vertex, Integer> memo) {
        if (memo.containsKey(source)) {
            return memo.get(source);
        }

        int longestPath = 0;
        if (graph.containsKey(source)) {
            for (Edge edge : graph.get(source)) {
                longestPath = Math.max(longestPath, dfs(edge.to, memo) + 1);
            }
        }

        memo.put(source, longestPath);
        return longestPath;
    }

    public static void main(String[] args) {
        LongestDirectedPathInDAG dag = new LongestDirectedPathInDAG();

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        dag.addEdge(v1, v2);
        dag.addEdge(v1, v3);
        dag.addEdge(v2, v3);
        dag.addEdge(v2, v4);
        dag.addEdge(v3, v4);

        System.out.println("Longest path starting from v1: " + dag.longestPath(v1));
    }
}
