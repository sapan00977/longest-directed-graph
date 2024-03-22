import java.util.*;

class Vertex {
    long id;
    List<Edge> edges;

    Vertex(long id) {
        this.id = id;
        this.edges = new ArrayList<>();
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
    private static Map<Vertex, Long> cache = new HashMap<>();

    public static long longestPath(Vertex vertex) {
        if (cache.containsKey(vertex))
            return cache.get(vertex);

        long maxPath = 0;
        for (Edge edge : vertex.edges) {
            maxPath = Math.max(maxPath, longestPath(edge.to) + 1);
        }

        cache.put(vertex, maxPath);
        return maxPath;
    }

    public static void main(String[] args) {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        v1.edges.add(new Edge(v1, v2));
        v1.edges.add(new Edge(v1, v3));
        v2.edges.add(new Edge(v2, v3));
        v2.edges.add(new Edge(v2, v4));
        v3.edges.add(new Edge(v3, v4));
        v4.edges.add(new Edge(v4, v5));

        System.out.println("Longest path from vertex 1: " + longestPath(v1));
        System.out.println("Longest path from vertex 2: " + longestPath(v2));
        System.out.println("Longest path from vertex 3: " + longestPath(v3));
        System.out.println("Longest path from vertex 4: " + longestPath(v4));
        System.out.println("Longest path from vertex 5: " + longestPath(v5));
    }
}
