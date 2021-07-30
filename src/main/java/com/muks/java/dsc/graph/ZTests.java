package com.muks.java.dsc.graph;

public class ZTests {
    public static void main(String[] args) {
        Graph graph = new Graph();

        Vertex v1 = graph.addVertex(1, 'a');
        Vertex v2 = graph.addVertex(2, 'b');
        Vertex v3 = graph.addVertex(3, 'c');
        Vertex v4 = graph.addVertex(4, 'd');
        Vertex v5 = graph.addVertex(5, 'e');
        Vertex v6 = graph.addVertex(6, 'f');


        graph.addEdgeToVertex(v1, v2, true);
        graph.addEdgeToVertex(v2, v5, true);
        graph.addEdgeToVertex(v1, v3, true);
        graph.addEdgeToVertex(v3, v4, true);
        graph.addEdgeToVertex(v5, v4, true);

        Vertex v = graph.getVertex(v2);
        System.out.println("edges: " + v.Edges.toString());
//        System.out.println(graph.toString());

        graph.runBFS(v1);

    }
}
