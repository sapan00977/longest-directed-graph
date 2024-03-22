# Directed Acyclic Graph Longest Path

## Overview
This repository contains Java code for finding the longest directed path in a Directed Acyclic Graph (DAG). The solution is implemented using a recursive approach to traverse the DAG and compute the longest path starting from each vertex and with caching to avoid redundant calculations by storing previously computed results.

## Implementation Details
- **Vertex:** Vertex within a graph.  Contains a unique identifier (id) and a list of edges that are outgoing from this vertex.
- **Edge:** Directed edge that connects two vertices.
- **LongestDirectedPathInDAG:** The primary class in DAG that constructs the graph and determines the longest path.
    - **cache:** Map to store already computed longest paths for vertices to avoid recalculating the longest path for vertices that have already been visited.  
    - **longestPath(Vertex source):** Recursive function that calculates the longest path starting from the given vertex. It recursively explores all outgoing edges from the current vertex and calculate the   longest path from each adjacent vertex and taking the maximum among them.
- **Main Method:** An example graph to show how to use the LongestDirectedPathInDAG class.

## Running the Program
Compile and run the `LongestDirectedPathInDAG.java` file. 

## Sample Example
- Five vertices are created (`v1` to `v5`) along with edges connecting them to form a DAG
- The edges are set up such that there is a directed path from `v1` to `v5`.

## Possible Optimizations
- Use a **parallelization of independent computations** to utilize the available resources more efficiently and achieve faster execution times when the graphs has significantly large number of vertices.
- Perform a **topological sort** before calculating the path to ensures that we process vertices in the correct order and prevent potential errors like the graphs not in topological order since the real-world case might have graphs that are not in topological order. 
- Implement **error handling** to check for cyclic graphs.

## Questions and Answer

**Does the solution work for larger graphs?**
Yes, the method should work for larger graphs since it uses dynamic programming alongside caching, which optimizes performance by avoiding redundant calculations.

**Can you think of any optimizations?**
One optimization could be to use a parallelization of independent computations and performing a topological sort before computing longest paths.

**What’s the computational complexity of your solution?**
This approach has a computational complexity of O(V + E), where V is the number of vertex and E is the number of edges in the graph.

**Are there any unusual cases that aren't handled?**
This approach requires the input graph is a directed acyclic graph (DAG). If the graph has cycles, the DFS algorithm may enter an infinite loop. So, it's important to ensure that the input graph is indeed acyclic.

