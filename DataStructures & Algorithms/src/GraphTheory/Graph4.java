package GraphTheory;

import java.util.*;

public class Graph4 { //weighted directed graph

	static class Edge {
		int source;
		int destination;
		int distance;
		
		public Edge(int source,int destination,int distance) {
			this.source=source;
			this.destination=destination;
			this.distance=distance;
		}
	}
	
	static class Graph {
		int numVertices;
		List<Edge> vertexList[];
		
		public Graph(int vertices) {
			numVertices=vertices;
			vertexList=new LinkedList[vertices];
			for(int i=0;i<vertices;i++) {
				vertexList[i]=new LinkedList<>();
			}
		}
		
		public void addEdges(int src,int desti,int distance) {
			Edge edge=new Edge(src,desti,distance);
			vertexList[src].add(edge);
		}
		
		public void printGraph() {
			for(int i=0;i<numVertices;i++) {
				List<Edge> edgeList=vertexList[i];
				for(int j=0;j<edgeList.size();j++) {
					System.out.println("Vertex "+i+" connected to "+edgeList.get(j).destination+" distant by "+edgeList.get(j).distance);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Graph g=new Graph(6);
		g.addEdges(0,1,4);
		g.addEdges(0,2,3);
		g.addEdges(1,3,2);
		g.addEdges(1,2,5);
		g.addEdges(2,3,7);
		g.addEdges(3,4,2);
		g.addEdges(4,0,4);
		g.addEdges(4,1,4);
		g.addEdges(4,5,6);
		g.printGraph();
	}
}