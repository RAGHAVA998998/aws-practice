package Graph;

import java.util.List;

import java.util.LinkedList;

public class Vertices {
    String data;
    Double distance;
    Double x;
    Double y;
    
    List Llist =new LinkedList<String>();
    public Vertices(String data) {
        this.data = data;
    }
    public Vertices(String data, Double x, Double y) {
        this.data = data;
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.data;
    }
    
}
