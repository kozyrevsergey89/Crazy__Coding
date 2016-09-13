package com.kozyrev.graphs;

/**
 * Created by sergii on 9/12/16.
 */

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearchExample {
    static ArrayList<Node> nodes = new ArrayList<Node>();

    static class Node {
        int data;
        boolean visited;

        Node(int data) {
            this.data = data;
        }
    }

    // find neighbors of node using adjacency matrix
// if adjacency_matrix[i][j]==1, then nodes at index i and index j are connected
    public ArrayList<Node> findNeighbours(int adjacency_matrix[][], Node x) {
        int nodeIndex = -1;
        ArrayList<Node> neighbours = new ArrayList<Node>();
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i).equals(x)) {
                nodeIndex = i;
                break;
            }
        }
        if (nodeIndex != -1) {
            for (int j = 0; j < adjacency_matrix[nodeIndex].length; j++) {
                if (adjacency_matrix[nodeIndex][j] == 1) {
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }

    // Recursive DFS
    public void dfs(int adjacency_matrix[][], Node node) {
        System.out.print(node.data + "\t");
        ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, node);
        for (int i = 0; i < neighbours.size(); i++) {
            Node n = neighbours.get(i);
            if (n != null && !n.visited) {
                dfs(adjacency_matrix, n);
                n.visited = true;
            }
        }
    }

    // Iterative DFS using stack
    public void dfsUsingStack(int adjacency_matrix[][], Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.add(node);
        node.visited = true;
        while (!stack.isEmpty()) {
            Node element = stack.pop();
            System.out.print(element.data + "\t");
            ArrayList<Node> neighbours = findNeighbours(adjacency_matrix, element);
            for (int i = 0; i < neighbours.size(); i++) {
                Node n = neighbours.get(i);
                if (n != null && !n.visited) {
                    stack.add(n);
                    n.visited = true;
                }
            }
        }
    }

    public static void main(String arg[]) {
        Node node40 = new Node(40);
        Node node10 = new Node(10);
        Node node20 = new Node(20);
        Node node30 = new Node(30);
        Node node60 = new Node(60);
        Node node50 = new Node(50);
        Node node70 = new Node(70);
        nodes.add(node40);
        nodes.add(node10);
        nodes.add(node20);
        nodes.add(node30);
        nodes.add(node60);
        nodes.add(node50);
        nodes.add(node70);
        int adjacency_matrix[][] = {{0, 1, 1, 0, 0, 0, 0},
{0,0,0,1,0,0,0}, {0,1,0,1,1,1,0}, {0,0,0,0,1,0,0}, {0,0,0,0,0,0,1}, {0,0,0,0,0,0,1}, {0,0,0,0,0,0,0},
        };
        DepthFirstSearchExample dfsExample = new DepthFirstSearchExample();
        System.out.println("The DFS traversal of the graph using stack ");
        dfsExample.dfsUsingStack(adjacency_matrix, node40);
        System.out.println();
        clearVisitedFlags();
        System.out.println("The DFS traversal of the graph using recursion ");
        dfsExample.dfs(adjacency_matrix, node40);
    }

    public static void clearVisitedFlags() {
        for (int i = 0; i < nodes.size(); i++) {
            nodes.get(i).visited = false;
        }
    }
}