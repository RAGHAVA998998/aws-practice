package Graph;

import java.util.List;

public class Tester {

    public static void main(String[] args) {
        Vertices A;
        Vertices B;
        Vertices C;
        Vertices D;
        Vertices E;
        Vertices F;
        A= new Vertices("A", 1.0, 1.0);
        B= new Vertices("B", 1.0, 2.0);
        C= new Vertices("C", 4.0, 2.0);
        D= new Vertices("D", 3.0, 1.0);
        E= new Vertices("E", 0.0, 4.0);
        F= new Vertices("F", 2.0, 3.0);
        
        Graph graph= new Graph(A);
        graph.add(B);
        graph.add(C);
        graph.add(D);
        graph.add(E);
        graph.add(F);
       List newliList = graph.KthNearest(A, graph, 1.0);
      

    }
}
