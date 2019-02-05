package GraphTheory;

import java.util.*;

public class GraphDFS2 { //Unweighted un-directed graph. Ref: https://algorithms.tutorialhorizon.com/graph-depth-first-traversal

	int vertex;
	LinkedList<Integer> list[];
	
	public GraphDFS2(int vertex) {
		this.vertex=vertex;
		list=new LinkedList[vertex];
		for(int i=0;i<vertex;i++) {
			list[i]=new LinkedList<>();
		}
	}
	
	public void addEdge(int from, int to) {
		list[from].addFirst(to);
		list[to].addFirst(from);
	}
	
	public void DFS(int startVertex) {
		System.out.print("Depth First Search: ");
		boolean visited[]=new boolean[vertex];
		Stack<Integer> stack=new Stack<>();
		stack.add(startVertex);
		for(int startIndex=startVertex;startIndex<vertex;startIndex++) {
			if(!visited[startIndex]) {
				stack.push(startIndex);
				visited[startIndex]=true;
				while(!stack.isEmpty()) {
					int nodeIndex=stack.pop();
					System.out.print(nodeIndex+" ");
					LinkedList<Integer> nodeList=list[nodeIndex];
					for(int i=0;i<nodeList.size();i++) {
						int dest=nodeList.get(i);
						if(!visited[dest]) {
							stack.push(dest);
							visited[dest]=true;
						}
					}
				}
			}
		}
	}

	public void printGraph() {
		for(int i=0;i<vertex;i++) {
			LinkedList<Integer> nodeList=list[i];
			if(nodeList.isEmpty()==false) {
				System.out.print("Source "+i+" is connected to ");
				for(int j=0;j<nodeList.size();j++) {
					System.out.print(nodeList.get(j)+" ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		GraphDFS2 graf=new GraphDFS2(6);
		graf.addEdge(0,1);
		graf.addEdge(0,2);
		graf.addEdge(1,2);
		graf.addEdge(1,3);
		graf.addEdge(3,4);
		graf.addEdge(2,3);
		graf.addEdge(4,0);
		graf.addEdge(4,1);
		graf.addEdge(4,5);
		graf.printGraph();
		graf.DFS(4);
	}
}