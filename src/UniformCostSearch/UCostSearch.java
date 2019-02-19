package UniformCostSearch;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class UCostSearch {

    private static ArrayList<Node> map = new ArrayList<>();

    public static void main(String[] args) {
        Help.init();
        for(Edge e : Help.Y.neighbors){
            System.out.println(e.toString());
        }
    }
}


