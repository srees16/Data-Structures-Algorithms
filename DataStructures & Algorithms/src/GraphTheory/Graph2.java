package GraphTheory;//Ref: http://krishnalearnings.blogspot.com/search/label/Basic%20understanding%20of%20Graph%20using%20Java

import java.util.*;

public class Graph2 { //Unweighted, undirected graph

	private Vertex vertices[]; //stores the nodes of the graph
	private int noOfVertices;

	private Graph2(int noOfVertices) { //No of vertices
		this.noOfVertices=noOfVertices;
		vertices=new Vertex[noOfVertices];
	}

	private class Vertex {
		int name;
		Neighbour neighbors;
		int weight;
		private Vertex(int name,int weight) {
			this.name=name;
			this.weight=weight;
		}
	}

	private class Neighbour {
		int index;
		Neighbour next;
		int weight;
		private Neighbour(int index, int weight, Neighbour next) {
			this.index=index;
			this.weight=weight;
			this.next=next;
		}
	}

	private void addNode(int name,int weight) {
		vertices[name-1]=new Vertex(name,weight);
	}

	private void addEdge(int sourceName,int destiName,int weight) { //Directed graph. Uncomment for undirected graph
		int sourceIndex=sourceName-1;
		int destiIndex=destiName-1;
		Vertex source=vertices[sourceIndex];
		//Vertex desti=vertices[destiIndex];
		source.neighbors=new Neighbour(destiIndex,weight,source.neighbors);
		//desti.neighbors=new Neighbour(sourceIndex,weight,desti.neighbors);
	}

	private void printState() {
		for(int i=0;i<noOfVertices;i++) {
			Vertex n=vertices[i];
			Neighbour temp=n.neighbors;
			while(temp!=null) {
				Vertex m=vertices[temp.index];
				System.out.println("Vertex "+n.name+", at a distance of "+n.weight+" is connected with "+m.name+", with cost: "+m.weight+" with edge weight "+temp.weight);
				temp=temp.next;
			}
		}
	}

	public static void main(String[] args) {
		Graph2 g=new Graph2(4);
		g.addNode(1,2);
		g.addNode(2,10);
		g.addNode(3,19);
		g.addNode(4,3);
		g.addEdge(1,2,4);
		g.addEdge(1,3,5);
		g.addEdge(3,4,100);
		g.addEdge(4,2,90);
		g.addEdge(4,3,2);
		g.addEdge(4,2,2);
		g.printState();
	}
}