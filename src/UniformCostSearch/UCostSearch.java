package UniformCostSearch;
import java.awt.event.MouseAdapter;
import java.util.*;

public class UCostSearch {


    public static void main(String[] args) {
        Help.init(); // Sets all the edges for the graph
        Search(Help.X); // This is the origin
        printPathTo(Help.D); // This is the end point
    }


    public static void Search(Node source){
        // Priority queue organizes the nodes by minimum path cost
        Queue<Node> queue = new PriorityQueue<>(20, Help.comp);
        // To keep track of the nodes that have been visited
        List<Node> visited = new ArrayList<>();
        /**
         * Initial State
         * =============
         */
        queue.add(source);
        source.pathCost = 0;
        while(!queue.isEmpty()){
            Node current = queue.poll(); // get the node with the lowest cost path in the queue
            visited.add(current);

            // Expand node
            for(Edge e : current.neighbors){
                Node child = e.target;
                if((current.parent != null)  && current.parent.value.equals(child.value)) continue;
                int cost = e.cost + current.pathCost; // aggregate the cost
                if(!visited.contains(child) && !queue.contains(child)){ // Newly introduced node
                    child.pathCost = cost;
                    child.parent = current;
                    queue.add(child);
                }
                else if(queue.contains(child) && child.pathCost>current.pathCost){
                    // Previously introduced node that is still in queue
                    Iterator<Node> temporary_check = queue.iterator();
                    boolean childIsLowest = checkLowest(temporary_check, child, cost);
                    if(childIsLowest){
                        child.pathCost = cost;
                        child.parent = current;
                        queue.remove(child);
                        queue.add(child);
                    }

                }

            }

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

    public static boolean checkLowest(Iterator<Node> queue, Node child, int cost){

        while (queue.hasNext()){
            Node current = queue.next();
            // If we find the child in the queue and the cost in the child is less than the queue
            if(current.value.equals(child.value) && cost < current.pathCost){
                return true;
            }
        }
        return false;
    }

}


