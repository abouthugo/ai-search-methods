package UniformCostSearch;
import java.awt.event.MouseAdapter;
import java.util.*;

public class UCostSearch {


    public static void main(String[] args) {
        Help.init(); // Sets all the edges for the graph
        Search(Help.Y);
        printPathTo(Help.E);
    }


    public static void Search(Node source){
        Queue<Node> queue = new PriorityQueue<>(20, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.pathCost > o2.pathCost) return 1;
                else if(o1.pathCost < o2.pathCost) return -1;
                else return 0;
            }
        });


        List<Node> visited = new ArrayList<>();
        queue.add(source);
        source.pathCost = 0; // initial path cost


        while(!queue.isEmpty()){
            Node current = queue.poll(); // get the head
            visited.add(current); // add head to visited node

            // Expand node
            for(Edge e : current.neighbors){
                Node child = e.target;
                int cost = e.cost;
                child.pathCost = current.pathCost + cost; // aggregated cost

                if(!visited.contains(child) && !queue.contains(child)){

                    child.parent = current;
                    queue.add(child);

                    System.out.println(child);
                    System.out.println(queue);
                    System.out.println();
                } else if(queue.contains(child) && child.pathCost>current.pathCost){
                    child.parent = current;

                    queue.remove(child);
                    queue.add(child);
                }

            }

        }

    }

    public static void printPathTo(Node goal){
        List<Node> path = new ArrayList<>();
        for(Node node = goal; node!=null; node=node.parent){
            path.add(node);
        }
        Collections.reverse(path);
        System.out.println("Path: " + path);
    }


}


