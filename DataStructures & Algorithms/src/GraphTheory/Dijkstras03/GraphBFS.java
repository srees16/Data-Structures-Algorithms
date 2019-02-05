package GraphTheory.Dijkstras03;

public class GraphBFS { //Ref: http://krishnalearnings.blogspot.com/search/label/BFS

	private Node[] vertices; // stores the nodes of the graph
    private int size; // number of nodes in the graph
    private Queue queue;
    public GraphBFS(int size) {
        this.size = size;
        vertices = new Node[size];
        addNodes();
        queue = new Queue(size);
    }

    public class Node {
        int name;
        Neighbour neighbourList;
        State state; 
        Node(int name) {
            this.name = name;
            state = State.NEW;
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
    private void addNodes(){
        for(int i = 1; i <= size ; i++){
            addNode(i);
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
        // the graph is non directional so if from S, D is reachable then vice versa is also true
        destiNode.neighbourList = new Neighbour(srcIndex, destiNode.neighbourList);
    }

    public void traverseGraph() {
        System.out.println("Using BFS Traversing the graph");
        for (int i = 0; i < size; i++) {
            if (vertices[i].state != State.VISITED) {
                bfs(vertices[i]);
            }
        }
    }

    private void bfs(Node currentNode) {
        queue.add(currentNode);
        currentNode.state = State.IN_Q;
        while(!queue.isEmpty()){
            Node visitedNode = queue.remove();
            visitedNode.state = State.VISITED;
            System.out.println(visitedNode.name);
            Neighbour temp = visitedNode.neighbourList;
            while(temp != null){
                Node neighbour = vertices[temp.index];
                if(neighbour.state == State.NEW){
                    queue.add(neighbour);
                    neighbour.state = State.IN_Q;
                }
                temp = temp.next;
            }
        }
    }

    public enum State {
        NEW, IN_Q, VISITED
    };

    /**
     * This is a simple queue implemented using array. Although ideally queue
     * should be implemented in circular style so as to use the empty area when
     * items are deleted from the front but for BFS implementation we each item
     * is added only once so if the size of the queue is taken as the size of
     * the items then there is no need for circular styled implementation.
     */
    public class Queue {
        Node[] queue;
        int maxSize;
        int front = -1,rear = -1;

        Queue(int maxSize) {
            this.maxSize = maxSize;
            queue = new Node[maxSize];
        }

        public void add(Node node) {
            queue[++rear] = node;
        }

        public Node remove() {
            Node node = queue[++front];
            queue[front] = null;
            return node;
        }

        public boolean isEmpty() {
            return front == rear;
        }
    }

    public static void main(String[] args) {
        GraphBFS graph = new GraphBFS(14);
        graph.addEdge(1, 4);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(3, 7);
        graph.addEdge(3, 6);
        graph.addEdge(9, 13);
        graph.addEdge(9, 12);
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(10, 11);
        graph.addEdge(11, 14);
        graph.addEdge(12, 14);
        graph.traverseGraph();
    }
}