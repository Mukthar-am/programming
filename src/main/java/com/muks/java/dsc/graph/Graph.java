package com.muks.java.dsc.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph<T> {
    public HashMap<Object, Vertex<T>> Vertices;

    public Graph() {
        this.Vertices = new HashMap<>();
    }

    public Vertex addVertex(Object id, Object name) {
        Vertex v = new Vertex(id, name);
        this.Vertices.put(v.Id, v);
        return v;
    }

    public void addEdgeToVertex(Vertex from, Vertex edgeTo, boolean isDirected) {
        from.addEdge(from, edgeTo, true);
        if (!isDirected)
            from.addEdge(from, edgeTo, false);
    }

    public Vertex<T> getVertex(Vertex v) {
        return this.Vertices.get(v.Id);
    }

    public boolean containsVertex(Vertex v) {
        return this.Vertices.containsKey(v.Id);
    }

    public void runBFS(Vertex startVertex) {
        System.out.println("+ Running Breadth First: ");
        if (!containsVertex(startVertex)) {
            throw new RuntimeException("Vertex does not exist.");
        }

        System.out.println("found... vertex found..");

        // init the Queue
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = getVertex(startVertex);
        queue.add(start);

        System.out.print(" starting with: " + start.Id);

        // explore the graph
        while (!queue.isEmpty()) {
            Vertex first = queue.remove();

            first.setVisited();
            List<Edge> edges = first.getEdges();
            for (Edge e : edges) {
                Vertex neighbour = e.ToVertex;

                //System.out.println("\n+ Neighbour = " + neighbour.toString());
                if (!neighbour.IsVisisted) {
                    neighbour.IsVisisted = true;

                    System.out.print(" -> " + neighbour.Id);

                    // parent here is established for shortest path Algorithm
                    neighbour.setParent(first);
                    queue.add(neighbour);
                }
            }

        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Map.Entry<Object, Vertex<T>>> itr = this.Vertices.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Object, Vertex<T>> entry = itr.next();
            Vertex v = entry.getValue();
            System.out.println("v.id: " + v.Id + ", name: " + v.Name);
            System.out.println("edges: " + v.getEdges());
            sb.append(entry.getValue().toString());
            if (itr.hasNext())
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
