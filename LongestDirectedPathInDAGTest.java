import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LongestDirectedPathInDAGTest {

    @Test
    void testLongestPathLinearGraph() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);

        v1.edges.add(new Edge(v1, v2));
        v2.edges.add(new Edge(v2, v3));

        assertEquals(2, LongestDirectedPathInDAG.longestPath(v1));
        assertEquals(1, LongestDirectedPathInDAG.longestPath(v2));
        assertEquals(0, LongestDirectedPathInDAG.longestPath(v3));
    }

    @Test
    void testLongestPathBranchingGraph() {
        Vertex a = new Vertex(1);
        Vertex b = new Vertex(2);
        Vertex c = new Vertex(3);
        Vertex d = new Vertex(4);
        Vertex e = new Vertex(5);

        a.edges.add(new Edge(a, b));
        a.edges.add(new Edge(a, c));
        b.edges.add(new Edge(b, d));
        c.edges.add(new Edge(c, e));

        assertEquals(2, LongestDirectedPathInDAG.longestPath(a));
        assertEquals(1, LongestDirectedPathInDAG.longestPath(b));
        assertEquals(1, LongestDirectedPathInDAG.longestPath(c));
        assertEquals(0, LongestDirectedPathInDAG.longestPath(d));
        assertEquals(0, LongestDirectedPathInDAG.longestPath(e));
    }

    @Test
    void testLongestPathDisconnectedGraph() {
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        v1.edges.add(new Edge(v1, v2));
        v3.edges.add(new Edge(v3, v4));

        assertEquals(1, LongestDirectedPathInDAG.longestPath(v1));
        assertEquals(0, LongestDirectedPathInDAG.longestPath(v2));
        assertEquals(1, LongestDirectedPathInDAG.longestPath(v3));
        assertEquals(0, LongestDirectedPathInDAG.longestPath(v4));
    }

    @Test
    void testLongestPathEmptyGraph() {
        assertEquals(0, LongestDirectedPathInDAG.longestPath(null));
    }

    @Test
    void testLongestPathSingleVertexGraph() {
        Vertex v = new Vertex(1);
        assertEquals(0, LongestDirectedPathInDAG.longestPath(v));
    }
}
