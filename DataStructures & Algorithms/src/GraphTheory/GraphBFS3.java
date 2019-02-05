package GraphTheory; //Ref: https://codereview.stackexchange.com/questions/141616/directed-weighted-graph-data-structure-in-java

import java.util.*;

	class GraphNode { //Weighted directed graph
		private Set<GraphEdge> edges;
		private String name;

		GraphNode(String name) {
			this.name=name;
			edges=new HashSet<>();
		}

		void addEdge(GraphEdge edge) {
			edges.add(edge);
		}

		Set<GraphNode> getNeighbours() {
			Set<GraphNode> neighbor=new HashSet<>();
			for(GraphEdge edge:edges) {
				neighbor.add(edge.getDestination());
			}
			return neighbor;
		}

		Set<GraphEdge> getEdges() {
			return new HashSet<>(this.edges);
		}

		String getName() {
			return this.name;
		}
	}

	class GraphEdge {
		private GraphNode source,destination;
		private double distance;
		
		GraphEdge(GraphNode src,GraphNode desti,double distance) {
			source=src;
			destination=desti;
			this.distance=distance;
		}
		
		GraphNode getSource() {
			return this.source;
		}
		
		GraphNode getDestination() {
			return this.destination;
		}
		//to get distance between vertices directly connected to each other
		double getDistance() {
			return this.distance;
		}
	}
	
	public class GraphBFS3 {
		int numVertices;
		private Map<GraphNode,Set<GraphEdge>> vertices;
		
		private GraphBFS3() {
			numVertices=0;
			vertices=new HashMap<>();
		}
		
		protected void addEdge(GraphNode src,GraphNode desti,double distance) {
			if(vertices.containsKey(src)) {
				GraphEdge gEdge=new GraphEdge(src,desti,distance);
				vertices.get(src).add(gEdge);
				src.addEdge(gEdge);
			} else {
				System.out.println("Source vertex not found!");
			}
		}

		protected void addVertex(GraphNode n) {
			if(!vertices.containsKey(n)) {
				vertices.put(n, new HashSet<GraphEdge>());
				System.out.println("Vertex Added!");
				++numVertices;
			} else {
				System.out.println("Vertex Already Present!");
			}
		}
		
		protected ArrayList<GraphNode> getNeighbour(GraphNode node) {
			return new ArrayList<>(node.getNeighbours());
		}
		
		protected double getDistance(GraphNode src,GraphNode desti) {
			for(GraphEdge edge:vertices.get(src)) {
				if(edge.getDestination()==desti) {
					return edge.getDistance();
				}
			}
			return 0.0;
		}
		//No of vertices in graph
		int noOfVertices() {
			return numVertices;
		}
		
		void BFS(GraphNode src) {
			Queue<GraphNode> q=new LinkedList<>();
			Set<GraphNode> visited=new HashSet<>();
			List<String> path=new ArrayList<>();
			q.add(src);
			while(!q.isEmpty()) {
				GraphNode node=q.poll();
				visited.add(node);
				Set<GraphNode> neighbour=node.getNeighbours();
				System.out.print("City "+node.getName()+" ");
				for(GraphNode v:neighbour) {
					System.out.print(v.getName()+" ");
					if(!visited.contains(v)) {
						q.add(v);
						visited.add(v);
						path.add(v.getName());
					}
				}
				System.out.println();
			}
			System.out.println("BFS traversal: "+path.toString());
		}

	public static void main(String[] args) {
		GraphBFS3 g=new GraphBFS3();
		GraphNode blr=new GraphNode("Bangalore"); //creating vertices
		GraphNode che=new GraphNode("Chennai");
		GraphNode vtz=new GraphNode("Vizag");
		GraphNode mum=new GraphNode("Mumbai");
		GraphNode rjy=new GraphNode("Rajahmundry");
		GraphNode rvp=new GraphNode("Ravulapalem");
		
		g.addVertex(rvp);g.addVertex(rjy);g.addVertex(mum);g.addVertex(vtz);g.addVertex(che);g.addVertex(blr); //adding vertices
		g.addEdge(rjy, rvp, 35); //connecting edges
		g.addEdge(rjy, vtz, 240);
		g.addEdge(mum, blr, 480);
		g.addEdge(vtz, blr, 350);
		g.addEdge(che, vtz, 380);
		g.addEdge(rvp, vtz, 290);
		g.BFS(rjy);
		System.out.println("Distance between VTZ & BLR is "+g.getDistance(vtz,blr));
	}
}