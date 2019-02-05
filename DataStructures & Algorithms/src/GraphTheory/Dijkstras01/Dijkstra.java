package GraphTheory.Dijkstras01;

import java.util.*;
/*Algo:
1. Take the unvisited node with minimum weight.
2. Visit all its neighbours.
3. Update the distances for all the neighbours (In the Priority Queue).
Repeat the process till all the connected nodes are visited.*/

public class Dijkstra { //Ref -https://github.com/vaishnav/Dijkstra
	
	public void calculate(Vertex source){
		
		source.minDistance = 0;
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.add(source);
		
		while(!queue.isEmpty()){
			
			Vertex u = queue.poll();
		
			for(Edge neighbour:u.neighbours){
				Double newDist = u.minDistance+neighbour.weight;
				if(neighbour.target.minDistance>newDist){
					queue.remove(neighbour.target); // Remove the node from the queue to update the distance value
					neighbour.target.minDistance = newDist;
					neighbour.target.path = new LinkedList<Vertex>(u.path); //Take the path visited till now and add the new node.s
					neighbour.target.path.add(u);
					queue.add(neighbour.target); //Reenter the node with new distance					
				}
			}
		}
	}

	public static void main(String[] arg){
		
		Dijkstra obj = new Dijkstra();
		Graph g = new Graph(9); //Create a new graph
		g.addEdge(0, 1, 4); g.addEdge(0, 7, 8); //Add the required edges
		g.addEdge(1, 2, 8); g.addEdge(1, 7, 11); g.addEdge(2, 1, 8);
		g.addEdge(2, 8, 2); g.addEdge(2, 5, 4); g.addEdge(2, 3, 7);
		g.addEdge(3, 2, 7); g.addEdge(3, 5, 14); g.addEdge(3, 4, 9); 
		g.addEdge(4, 3, 9); g.addEdge(4, 5, 10); 
		g.addEdge(5, 4, 10); g.addEdge(5, 3, 9); g.addEdge(5, 2, 4); g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1); g.addEdge(6, 8, 6); g.addEdge(6, 5, 2);
		g.addEdge(7, 0, 8); g.addEdge(7, 8, 7); g.addEdge(7, 1, 11); g.addEdge(7, 6, 1);
		g.addEdge(8, 2, 2); g.addEdge(8, 7, 7); g.addEdge(8, 6, 6);
		obj.calculate(g.getVertex(0)); // Calculate Dijkstra	
		
		for(Vertex v:g.getVertices()){ //Print the minimum Distance
			System.out.print("Vertex - "+v+", Distance - "+ v.minDistance+", Path - ");
			for(Vertex pathvert:v.path) {
				System.out.print(pathvert+" ");
			}
			System.out.println(""+v);
		}
	}
}