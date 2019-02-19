package UniformCostSearch;

public class Node {

    public final String value;
    public int pathCost;
    public Edge[] neighbors;
    public Node parent;

    public Node(String value){
        this.value = value;
    }

    public String toString(){
        return this.value;
    }
}
