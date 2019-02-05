package GraphTheory;

import java.util.*;

public class GraphDFS1 { //Unweighted un-directed graph. Easy to understand example. Ref: https://www.programiz.com/dsa/graph-dfs

	private int noOfVertices;
	private LinkedList<Integer> adjList[];
	private boolean visited[];

	GraphDFS1(int vertices) {
		noOfVertices=vertices;
		adjList=new LinkedList[vertices];
		visited=new boolean[vertices];
		for(int i=0;i<vertices;i++) {
			adjList[i]=new LinkedList<>();
		}
	}

	void addEdge(int from, int to) {
		adjList[from].add(to); //directed
		adjList[to].add(from); //uncomment for undirected
	}

	void DFS(int vertex) { //DFS traversal from the input to the other vertices
		visited[vertex]=true;
		System.out.print(vertex+" ");
		Iterator<Integer> iterator=adjList[vertex].iterator();
		while(iterator.hasNext()) {
			int adj=iterator.next();
			if(!visited[adj]) {
				DFS(adj);
			}
		}
	}

	public static void main(String args[]) {
		GraphDFS1 graf=new GraphDFS1(4);
		graf.addEdge(0,1);
		graf.addEdge(0,2);
		graf.addEdge(1,2);
		graf.addEdge(2,3);
		System.out.println("Depth First Search from the vertex");
		graf.DFS(0);
	}
}