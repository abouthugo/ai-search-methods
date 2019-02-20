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
        Search(Help.X);
        printPathTo(Help.Y);
    }


    public static void Search(Node source){
        // Priority queue organizes the nodes by minimum path cost
        Queue<Node> queue = new PriorityQueue<>(20, comp);


        // To keep track of the nodes that have been visited
        List<Node> visited = new ArrayList<>();

        /**
         * Initial State
         * =============
         */
        queue.add(source);
        source.pathCost = 0;
        System.out.println("Initial state: " + queue);


        while(!queue.isEmpty()){
            System.out.println("Visiting: " + queue.peek());
            Node current = queue.poll(); // get the node with the lowest cost path in the queue
            visited.add(current);

            // Expand node
            for(Edge e : current.neighbors){
                Node child = e.target;
                if((current.parent != null)  && current.parent.value.equals(child.value)) continue;
                int cost = e.cost;
                System.out.println("Child: " + child + "\t Initial cost: " + cost);
                child.pathCost = current.pathCost + cost; // aggregate the cost
                System.out.println("Child: " + child + "\t Aggregated cost: " + child.pathCost);



                if(!visited.contains(child) && !queue.contains(child)){ // Newly introduced node
                    child.parent = current;
                    queue.add(child);
                    System.out.println("A ->"+ child +": " + child.pathCost);
                }
                else if(queue.contains(child) && child.pathCost>current.pathCost){
                    // Previously introduced node that is still in queue
                    child.parent = current;
                    queue.remove(child);
                    System.out.println("Removing: " + child + "(" + child.pathCost + ">" + current.pathCost + ")");
                    queue.add(child);
                    System.out.println("Adding to queue child: "+ child +" with cost: " + child.pathCost);
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
        System.out.println("Goal: " + goal);
    }


}


