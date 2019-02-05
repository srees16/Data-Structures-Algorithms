package GraphTheory.Dijkstras03;

public class GraphDFS {// Ref- http://krishnalearnings.blogspot.com/search/label/Depth%20first%20search 

	    private Node[] vertices; // stores the nodes of the graph
	    private int size; // number of nodes in the graph

	    public GraphDFS(int size) {
	        this.size = size;
	        vertices = new Node[size];
	    }

	    public class Node {
	        int name;
	        boolean visited = false;
	        Neighbour neighbourList;

	        Node(int name) {
	            this.name = name;
	        }
	    }

	    public class Neighbour {
	        int index;
	        Neighbour next;

	        public Neighbour(int index, Neighbour next) {
	            this.index = index;
	            this.next = next;
	        }
	    }

	    public void addNode(int name) {
	        vertices[name - 1] = new Node(name);
	    }

	    public void addEdge(int sourceName, int destiName) {
	        int srcIndex = sourceName - 1;
	        int destiIndex = destiName - 1;
	        Node srcNode = vertices[srcIndex];
	        Node destiNode = vertices[destiIndex];
	        srcNode.neighbourList = new Neighbour(destiIndex, srcNode.neighbourList);
	        // the graph is non directional so if from S, D is reachable then vice
	        // versa is also true
	        destiNode.neighbourList = new Neighbour(srcIndex, destiNode.neighbourList);
	    }

	    public void traverseGraph() {
/*If graph contains disconnected nodes or sub graphs then below loops makes sure that all such nodes or sub graphs are also visited. In a single
connected graph below loop is not needed and simply dfs(vertices[0]); can be called and the graph will be visited*/
	        for (int i = 0; i < size; i++) {
	            if (!vertices[i].visited) {
	                dfs(vertices[i]);
	            }
	        }
	    }

	    private void dfs(Node currentNode) {
	        currentNode.visited = true;
	        System.out.println(currentNode.name);
	        Neighbour temp = currentNode.neighbourList;
	        while (temp != null) {
	            if (!vertices[temp.index].visited) {
	                dfs(vertices[temp.index]);
	            }
	            temp = temp.next;
	        }
	    }

	    public static void main(String[] args) {
	    	GraphDFS graph = new GraphDFS(11);
	        graph.addNode(1);
	        graph.addNode(2);
	        graph.addNode(3);
	        graph.addNode(4);
	        graph.addNode(5);
	        graph.addNode(6);
	        graph.addNode(7);
	        graph.addNode(8);
	        graph.addNode(9);
	        graph.addNode(10);
	        graph.addNode(11);
	        graph.addEdge(1, 3);
	        graph.addEdge(1, 4);
	        graph.addEdge(2,3);
	        graph.addEdge(3,5);
	        graph.addEdge(3, 6);
	        graph.addEdge(4, 5);
	        graph.addEdge(4,7);
	        graph.addEdge(9,11);
	        graph.addEdge(10,11);
	        graph.traverseGraph();
	    }
}