package GraphTheory; //Ref: http://www.techiedelight.com/graph-implementation-java-using-collections/

import java.util.*;

public class Graph3 { //Weighted undirected graph
	static class Edge { //store graph edges
		int src, dest, weight;

		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	static class Node { // data structure for adjacency list node
		int value, weight;
		Node(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}
	}

	List<List<Node>> adj = new ArrayList<>(); // A list of lists to represent adjacency list

	public Graph3(List<Edge> edges) { // Constructor to construct graph
		for (int i = 0; i < edges.size(); i++) // allocate memory for adjacency list
			adj.add(i, new ArrayList<>());
			for (Edge e : edges) { // add edges to the undirected graph
			adj.get(e.src).add(new Node(e.dest, e.weight)); // allocate new node in adjacency List from src to dest
			//adj.get(e.dest).add(new Node(e.src, e.weight)); //Uncomment for undirected graph. Allocate new node in adjacency List from dest to src
		}
	}

	private static void printGraph(Graph3 graph) { // print adjacency list representation of graph
		int src = 0;
		int n = graph.adj.size();
		while(src<n) {
			for (Node edge : graph.adj.get(src)) // print current vertex and all its neighboring vertices
				System.out.print(src + " --> " + edge.value + " (" + edge.weight + ")\t");
			System.out.println();
			src++;
		}
	}

	public static void main (String[] args) { // Weighted digraph Implementation in Java
		// Input: List of edges in a weighted digraph (as per above diagram)
		List<Edge> edges = Arrays.asList(new Edge(0,1,6), //represents edge from x to y having weight w
										new Edge(1,2,7),
										new Edge(2,0,5),
										new Edge(2,1,4),
										new Edge(3,2,10), 
										new Edge(4,5,1),
										new Edge(5,4,3));
		Graph3 graph = new Graph3(edges); // construct graph from given list of edges
		printGraph(graph); // print adjacency list representation of the graph
	}
}