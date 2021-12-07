package data_structures;

public class Node {
    private String data;
    private Node next;
    public Node(String data) {
        this.data = data;
       // System.out.println("new node is generated without next with value-"+ data);
     }

    public Node(String data, Node next) {
        this.data = data;
        this.next = next;
       // System.out.println("new node and next are created- "+data+" - "+ next.data);
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    
}
