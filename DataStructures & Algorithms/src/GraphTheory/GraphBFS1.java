package GraphTheory;

import java.util.*;
	/*Step 1: Push the root node in the Queue. Ref: https://www.codeproject.com/Articles/32212/Introduction-to-Graph-with-Breadth-First-Search-BF
	Step 2: Loop until the queue is empty.
	Step 3: Remove the node from the Queue.
	Step 4: If the removed node has unvisited child nodes, mark them as visited and insert the unvisited children in the queue.*/
public class GraphBFS1 { //Unweighted un-directed graph. G4G example.

	private int noOfVertices; //for no of vertices
	private LinkedList<Integer> adjList[]; //array of lists for adjacency representation
	
	private GraphBFS1(int vertices) { //constructor to initialize vertices and add them as each adjacency list
		noOfVertices=vertices;
		adjList=new LinkedList[vertices];
		for(int i=0;i<vertices;++i) {
			adjList[i]=new LinkedList<>();
		}
	}
	
	private void addEdge(int source,int desti) { //Adding edges between given 2 vertices. Can be used for undirected graph by a line for adding direction vice versa
		adjList[source].add(desti);
		adjList[desti].add(source);
	}
	
	public void BFS(int startVertex) { //prints BFS traversal from a given vertex
		boolean visited[]=new boolean[noOfVertices]; //mark all vertices as Not Visited by default
		LinkedList<Integer> queue=new LinkedList<>(); //list for BFS
		visited[startVertex]=true; // mark the node as visited and enqueue it
		queue.add(startVertex);
		while(!queue.isEmpty()) { //as long as the queue is not empty, dequeue vertex and print it
			startVertex=queue.poll();
			System.out.print(startVertex+" ");
			Iterator<Integer> i=adjList[startVertex].listIterator();
			while(i.hasNext()) { // Get all adjacent vertices of the dequeued vertex s if a adjacent has not been visited, then mark it visited and enqueue it
				int n=i.next();
				if(!visited[n]) {
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		GraphBFS1 g=new GraphBFS1(4);
		g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(2,3);
		g.addEdge(3,3);
		System.out.println("Following is the BFS traversal");
		g.BFS(1);
	}
}