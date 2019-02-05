package GraphTheory; //Ref: https://www.youtube.com/watch?v=SXkqUvHRgRA

import java.util.*;

public class Graph1 { //Unweighted, undirected simple graph implementation of adding Edges and Vertices. Best example
	
	private Map<Integer,ArrayList<Integer>> adjListMap; //Map with label and neighbors

	private Graph1(int vertex) { //Constructor to put neighboring vertices to each vertex
		adjListMap=new HashMap<>(); //implementing hashmap
		for(int i=1;i<=vertex;i++) { //for loop starting with the 1st neighbor and going thru all the vertices 
			ArrayList<Integer> neighbors=new ArrayList<>(); //initiating list of neighbors for each of the vertex
			adjListMap.put(i, neighbors); //adding the vertex and its neighbors
		}
	}
	
	private void addEdge(int from,int to) { //adding edges between vertices
		if(from>adjListMap.size() || to>adjListMap.size()) { //check to see if vertices are more than the map size of vertices & neighbors
			return;
		}
		(adjListMap.get(from)).add(to); //adding as undirected graph
		(adjListMap.get(to)).add(from);
	}
	
	private ArrayList<Integer> getNeighbors(int vertex) {
		if(vertex>adjListMap.size()) {
			return null;
		}
		return new ArrayList<>(adjListMap.get(vertex)); //returns list of neighbors for a given vertex
	}
	
	public static void main(String[] args) { //main method which prompts user for inputs and displays as per vertices connected via edges
		int count=1;
		int source, destination;
		System.out.println("Enter no of vertices & edges");
		Scanner scan=new Scanner(System.in);
		int noOfVertices=scan.nextInt();
		int noOfEdges=scan.nextInt();
		Graph1 graf=new Graph1(noOfVertices);
		System.out.println("Enter Edges <source> <destination>");
		while(count<=noOfEdges) {
			source=scan.nextInt();
			destination=scan.nextInt();
			graf.addEdge(source, destination);
			count++;
		}
		System.out.println("Adjacency List for the graph is");
		for(int i=1;i<=noOfVertices;i++) {
			System.out.print(i+" --> ");
			ArrayList<Integer> edgeList=graf.getNeighbors(i);
			for(int j=1;;j++) {
				if(j!=edgeList.size()) {
					System.out.print(edgeList.get(j-1)+" --> ");
				} else {
					System.out.print(edgeList.get(j-1));
					break;
				}
			}
			System.out.println();
		}
		scan.close();
	}
}