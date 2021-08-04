package com.muks.java.dsc.graph;

/*
    Created by mukthar.ahmed on 04-Aug-21
    Note:
        The grpah built and used in below example is from Graph traversal tutorials video
    Code ex: http://codereview.stackexchange.com/questions/67970/graph-implementation-in-java-8
 */

public class ZTests {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex v1 = graph.addVertex(1, 'a');
        Vertex v2 = graph.addVertex(2, 'b');
        Vertex v3 = graph.addVertex(3, 'c');
        Vertex v4 = graph.addVertex(4, 'd');
        Vertex v5 = graph.addVertex(5, 'e');
        Vertex v6 = graph.addVertex(6, 'f');
        Vertex v7 = graph.addVertex(7, 'g');
        Vertex v8 = graph.addVertex(8, 'h');
        Vertex v9 = graph.addVertex(9, 'i');
        Vertex v10 = graph.addVertex(10, 'j');


        graph.addEdgeToVertex(v1, v2, true, 2);
        graph.addEdgeToVertex(v2, v5, true, 2);
        graph.addEdgeToVertex(v1, v3, true, 1);
        graph.addEdgeToVertex(v3, v4, true, 1);
        graph.addEdgeToVertex(v5, v4, true, 2);
        graph.addEdgeToVertex(v5, v6, true, 1);
        graph.addEdgeToVertex(v6, v7, true, 1);
        graph.addEdgeToVertex(v7, v8, true, 1);
        graph.addEdgeToVertex(v8, v9, true, 1);
        graph.addEdgeToVertex(v9, v10, true, 1);
        graph.addEdgeToVertex(v4, v10, true, 1);

        Vertex v = graph.getVertex(v2);
        System.out.println("edges: " + v.Edges.toString());
//        System.out.println(graph.toString());

        graph.runBFS(v1);

        graph.runDFS(v1);

        // get shortest path between 2 vertices.
        graph.shortestPath(v1, v10);

        graph.resetGraph();
        graph.printParentsOfVertices();

        // get shortest path between 2 vertices.
        graph.shortestPathByWeight(v1, v10);
    }
}
