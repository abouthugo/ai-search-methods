package UniformCostSearch;
import java.awt.event.MouseAdapter;
import java.util.*;

public class UCostSearch {

    private static Comparator<Node> comp =  (Node a, Node b) -> {
        if(a.pathCost>b.pathCost) return 1;
        else if(a.pathCost<b.pathCost) return -1;
        else return 0;
    };

    public static void main(String[] args) {
        Help.init(); // Sets all the edges for the graph
        Search(Help.A);
        printPathTo(Help.Y);
    }


    public static void Search(Node source){
        // Priority queue organizes the nodes by minimum path cost
        Queue<Node> queue = new PriorityQueue<>(20, comp);
        Queue<Node> found = new PriorityQueue<>(10, comp);


        // To keep track of the nodes that have been visited
        List<Node> visited = new ArrayList<>();

        /**
         * Initial State
         * =============
         */
        System.out.println("Initial state: " + queue);
        queue.add(source);
        source.pathCost = 0;


        while(!queue.isEmpty()){
            System.out.println("Popped: " + queue.peek());
            Node current = queue.poll(); // get the node with the lowest cost path in the queue
            visited.add(current);

            // Expand node
            for(Edge e : current.neighbors){
                Node child = e.target;
                int cost = e.cost;
                child.pathCost = current.pathCost + cost; // aggregate the cost



                if(!visited.contains(child) && !queue.contains(child)){ // Newly introduced node
                    child.parent = current;
                    queue.add(child);
                    System.out.println("New child "+ child +" with cost: " + child.pathCost);
                }
                else if(queue.contains(child) && child.pathCost>current.pathCost){
                    // Previously introduced node that is still in queue
                    child.parent = current;
                    queue.remove(child);
                    System.out.println("Removing: " + child);
                    queue.add(child);
                }

            }
            System.out.println(queue);

        }

    }

    public static void printPathTo(Node goal){
        List<Node> path = new ArrayList<>();
        int cost =  goal.pathCost;
        for(Node node = goal; node!=null; node=node.parent){
            path.add(node);
        }
        Collections.reverse(path);
        System.out.println("Path: " + path);
        System.out.println("Cost: " + cost);
    }


}


