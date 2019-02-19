package UniformCostSearch;

public class Edge {

    public final int cost;
    public final Node target;

    public Edge(Node target, int cost){
        this.cost = cost;
        this.target = target;
    }

    @Override
    public String toString() {
        return this.target.value;
    }
}
