package com.muks.java.dsc.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
    public Object Id = null;
    public Object Name = null;
    public List<Edge> Edges = new ArrayList<>();
    public boolean IsVisisted;
    public Vertex Parent;

    public Vertex(Object id, Object name) {
        this.Id = id;
        this.Name = name;
    }

    public void addEdge(Vertex fromVertex, Vertex toVertex, boolean isDirected) {
        Edge e = new Edge(fromVertex, toVertex);
        if (isDirected) {
            this.Edges.add(e);
        } else {
            Edge e2 = new Edge(toVertex, fromVertex);
            this.Edges.add(e2);
        }
    }

    public List<Edge> getEdges() {
        return this.Edges;
    }

    public void setVisited(){
        this.IsVisisted = true;
    }

    public void setParent(Vertex p) {
        this.Parent = p;
    }

    public String toString() {
        return "(" + this.Id + "-" + this.Name + ", e: " + this.Edges.toString() + ")";
    }

}
