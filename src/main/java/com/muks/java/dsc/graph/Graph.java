package com.muks.java.dsc.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph<T> {
    public HashMap<Object, Vertex<T>> Vertices;

    public Graph() {
        this.Vertices = new HashMap();
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

    public void addEdgeToVertex(Vertex from, Vertex edgeTo, boolean isDirected, int weight) {
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
        resetGraph();   // to override the previous run of BFS or DFS

        List<Vertex> bfsVertices = new ArrayList<>();

        System.out.println("+ Running Breadth First: ");
        if (!containsVertex(startVertex)) {
            throw new RuntimeException("Vertex does not exist.");
        }

        System.out.println("found... vertex found..");

        // init the Queue
        Queue<Vertex> queue = new LinkedList<>();
        Vertex start = getVertex(startVertex);
        queue.add(start);
        bfsVertices.add(start);

        //System.out.print(" starting with: " + start.Id);

        // explore the graph
        while (!queue.isEmpty()) {
            Vertex first = queue.remove();

            first.setVisited();

            List<Edge> edges = first.getEdges();

            for (Edge e : edges) {
                Vertex neighbour = e.ToVertex;

                if (!neighbour.IsVisisted) {
                    neighbour.setVisited();

                    //System.out.print(" -> " + neighbour.Id);
                    bfsVertices.add(neighbour);

                    // parent here is established for shortest path Algorithm
                    neighbour.setParent(first);
                    queue.add(neighbour);
                }
            }

            //System.out.println("@ " + first.Id + ", Q.now: " + queue.toString());

        }


        ListIterator<Vertex> itr = bfsVertices.listIterator();
        StringBuilder sb = new StringBuilder("(");
        while (itr.hasNext()) {
            sb.append(itr.next().Id);

            if (itr.hasNext())
                sb.append(" -> ");
        }
        sb.append(")");
        System.out.println("BFS: " + sb.toString());
    }

    public void runDFS(Vertex v) {
        resetGraph();   // to override the previous run of BFS or DFS

        List<Vertex> dfsVertices = new ArrayList<>();
        Stack<Vertex> stack = new Stack<>();

        Vertex start = getVertex(v);
        stack.push(start);
        dfsVertices.add(start);

        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();

            vertex.setVisited();

            List<Edge> edges = vertex.getEdges();
            for (Edge e : edges) {
                Vertex neighbour = e.getToVertex();

                if (!neighbour.IsVisisted) {
                    neighbour.setVisited();
                    stack.add(neighbour);
                    dfsVertices.add(neighbour);


                    // parent here is established for shortest path Algorithm
                    neighbour.setParent(vertex);
                }
            }

        }

        ListIterator<Vertex> itr = dfsVertices.listIterator();
        StringBuilder sb = new StringBuilder("(");
        while (itr.hasNext()) {
            sb.append(itr.next().Id);

            if (itr.hasNext())
                sb.append(" -> ");
        }
        sb.append(")");
        System.out.println("DFS: " + sb.toString());
    }



    public void shortestPath(Vertex startVertex, Vertex endVertex) {
        System.out.println("\n\n+ Shortest path algorithm +");

        // if nodes not found, return empty path
        if (!containsVertex(startVertex) || !containsVertex(endVertex)) {
            System.out.println("no path found between these 2 nodes...");
            return;
        }

        // mark parent for each node by running BFS
        runBFS(startVertex);

        List<Vertex> path = new ArrayList<>();

        // trace path back from end vertex to start
        Vertex end = getVertex(endVertex);

        while (end != null && end != getVertex(startVertex)) {
            path.add(end);
            end = end.getParent();
        }

        // if end is null, node not found
        if (end == null) {
            System.out.println("node not found..");
            return ;
        }
        else {
            path.add(end);
            Collections.reverse(path);
        }


        ListIterator<Vertex> itr = path.listIterator();
        StringBuilder sb = new StringBuilder("(");
        while (itr.hasNext()) {
            sb.append(itr.next().Id);

            if (itr.hasNext())
                sb.append(" -> ");
        }
        sb.append(")");
        System.out.println("shortest path:- " + sb.toString());
    }

    public void shortestPathByWeight(Vertex startVertex, Vertex endVertex) {
        System.out.println("\n\n+ Shortest path algorithm +");

        // if nodes not found, return empty path
        if (!containsVertex(startVertex) || !containsVertex(endVertex)) {
            System.out.println("no path found between these 2 nodes...");
            return;
        }

        // mark parent for each node by running BFS
        runBFS(startVertex);

        List<Vertex> path = new ArrayList<>();

        // trace path back from end vertex to start
        Vertex end = getVertex(endVertex);

        while (end != null && end != getVertex(startVertex)) {
            path.add(end);
            end = end.getParent();
        }

        // if end is null, node not found
        if (end == null) {
            System.out.println("node not found..");
            return ;
        }
        else {
            path.add(end);
            Collections.reverse(path);
        }


        ListIterator<Vertex> itr = path.listIterator();
        StringBuilder sb = new StringBuilder("(");
        while (itr.hasNext()) {
            sb.append(itr.next().Id);

            if (itr.hasNext())
                sb.append(" -> ");
        }
        sb.append(")");
        System.out.println("shortest path:- " + sb.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Map.Entry<Object, Vertex<T>>> itr = this.Vertices.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Object, Vertex<T>> entry = itr.next();
            Vertex v = entry.getValue();
            sb.append(entry.getValue().toString());
            if (itr.hasNext())
                sb.append(" || ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void resetGraph() {
        Iterator<Map.Entry<Object, Vertex<T>>> itr = this.Vertices.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Object, Vertex<T>> entry = itr.next();
            entry.getValue().IsVisisted = false;
        }
    }

    public void printParentsOfVertices() {
        StringBuilder sb = new StringBuilder("(");

        Iterator<Map.Entry<Object, Vertex<T>>> itr = this.Vertices.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Object, Vertex<T>> entry = itr.next();
            Vertex v = entry.getValue();
            Vertex p = v.getParent();
            if (p != null) {
                sb.append(p.Id + "(p) -> " + v.Id + " ");
            } else {
                sb.append("@(p) -> " + v.Id + " ");
            }

            if (itr.hasNext()) {
                sb.append(", ");
            } else {
                sb.append(")");
            }
        }
        System.out.println("Parent view of graph:- " + sb.toString());
    }
}
