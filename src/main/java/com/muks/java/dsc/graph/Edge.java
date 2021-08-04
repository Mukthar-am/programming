package com.muks.java.dsc.graph;

public class Edge {
    public Vertex FromVertex;
    public Vertex ToVertex;
    public int Weight;

    public Edge(Vertex v1, Vertex v2) {
        this.FromVertex = v1;
        this.ToVertex = v2;
    }

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.FromVertex = v1;
        this.ToVertex = v2;
        this.Weight = weight;
    }

    public String toString() {
        return "{" + this.FromVertex.Name + "->" + this.ToVertex.Name + ", w: " + this.Weight + "}";
    }

    public Vertex getFromVertex() {
        return this.FromVertex;
    }

    public Vertex getToVertex() {
        return this.ToVertex;
    }
}
