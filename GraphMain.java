/*
 * Graph Traversal Implementation (BFS & DFS)
 *
 * Author: SaptHrishi (Hrishabh Mishra)
 *
 * Built as part of my Data Structures and Algorithms (DSA) practice.
 *
 * This project demonstrates the implementation of an Undirected Graph
 * using an Adjacency List representation in Java. The objective is to
 * understand graph construction and traversal algorithms from scratch
 * without relying on specialized graph libraries.
 *
 * Features:
 *  - Graph creation using Adjacency Lists
 *  - Add edges between vertices
 *  - Display graph structure
 *  - Breadth-First Search (BFS) traversal
 *  - Depth-First Search (DFS) traversal
 *
 * Algorithms Implemented:
 *
 * 1. Breadth-First Search (BFS)
 *    - Uses a Queue data structure
 *    - Visits vertices level by level
 *    - Useful for shortest path discovery in unweighted graphs
 *
 * 2. Depth-First Search (DFS)
 *    - Uses Recursion
 *    - Explores as deep as possible before backtracking
 *    - Useful for connectivity, cycle detection, and graph exploration
 *
 * Graph Representation:
 *  - Adjacency List
 *  - Undirected Graph
 *
 * Time Complexity:
 *  - Add Edge      : O(1)
 *  - BFS Traversal : O(V + E)
 *  - DFS Traversal : O(V + E)
 *
 * Space Complexity:
 *  - Graph Storage : O(V + E)
 *  - BFS Queue     : O(V)
 *  - DFS Stack     : O(V) (Recursive Call Stack)
 *
 * Example Graph:
 *
 *      1
 *      |
 *      2 ----- 5
 *     / \     /
 *    0   \   /
 *     \   \ /
 *      \   3
 *       \ /
 *        4
 *
 * A simple educational implementation designed to strengthen
 * core graph concepts and traversal techniques in DSA.
 */

import java.util.*;

class Graph{
    protected ArrayList<ArrayList<Integer>> graph;

    public Graph(int n){
        graph = new ArrayList<>();
        for(int i =0;i<n;i++){
            graph.add(new ArrayList<>());
        }
    }

    public void addEdges(int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    public void printGraph(){
        for(int i =0;i<graph.size();i++){
            System.out.print("Vertex" + i + " -> ");
            for(Integer neighbour: graph.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println("");
        }
    }

    public ArrayList<Integer> bfsGraph(int n){
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] v = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        v[0] = true;

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);


            for(Integer it: graph.get(node)){
                if(!v[it]){
                    v[it]= true;
                    q.add(it);
                }
            }

        }
        return bfs;
    }

    public void dfs(int node, ArrayList<Integer> dfs,boolean[] v){
        v[node] = true;
        dfs.add(node);

        for(Integer it: graph.get(node)){
            if(!v[it]){
                dfs(it,dfs,v);
            }
        }
    }

    public ArrayList<Integer> dfsGraph(int n){
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] v = new boolean[n];
        v[0] = true;
        dfs(0,dfs,v);
        return dfs;
    }
}

public class GraphMain{
    public static void main(String args[]){
        Graph g = new Graph(6);
        g.addEdges(0,2);
        g.addEdges(1,2);
        g.addEdges(5,2);
        g.addEdges(3,4);
        g.addEdges(3,5);
        g.addEdges(2,3);
        g.addEdges(0,4);
        g.printGraph();
        ArrayList<Integer> bfsResult = g.bfsGraph(6);
        System.out.print("BFS : ");
        for(Integer it: bfsResult){
            System.out.print(it + "  ");
        }
        System.out.println();
        ArrayList<Integer> dfsResult = g.dfsGraph(6);
        System.out.print("DFS : ");
        for(Integer it: dfsResult){
            System.out.print(it + "  ");
        }
        System.out.println();
    }
}