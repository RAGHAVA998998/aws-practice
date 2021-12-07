package Graph;

import java.util.List;

import java.util.LinkedList;

public class Graph {
    List vertices = new LinkedList<Vertices>();
    static Vertices origin  =new Vertices("O", 0.0, 0.0);

    public Graph(Vertices vertices) {
        this.vertices.add(vertices);
    }
    public void add(Vertices vertices){
        this.vertices.add(vertices);
    }

public Graph(List vertices) {
        this.vertices = vertices;
    }


public Double distance(Vertices vertices1, Vertices vertices2) {
    Double X_distance= vertices1.x-vertices2.x;
    Double Y_distance= vertices1.y-vertices2.y;
    Double dist = Math.sqrt((X_distance*X_distance)-(Y_distance*Y_distance));
    return dist;
}

public Double distanceOrigin(Vertices vertices){
         Vertices vertices2=origin;
         Double dist= this.distance(vertices, origin);
         return dist; 
}
public List KthNearest(Vertices vertices,Graph graph, Double radius){
    Vertices temp = (Vertices) graph.vertices.get(0);
    List KthNear = new LinkedList<Vertices>();
    while(temp!=null){
        Double dist = this.distance(vertices, temp);
        if(dist.doubleValue() <= radius.doubleValue()){
            KthNear.add(temp);

        }
    }
    return KthNear;
}
}
