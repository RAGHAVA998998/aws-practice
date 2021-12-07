package data_structures;

public class Tester {
    public static void main(String[] args) {
        LinkedList LL = new LinkedList();
        LL.addAtEnd("11");
        LL.addAtEnd("13");
        LL.addAtEnd("18");
        LL.addAtEnd("34");
        LL.addAtEnd("46");
        operate(LL);
        LL.display();

}


public static void operate(LinkedList list){
    Node temp= list.getHead();
    while (temp.getNext().getNext()!=null) {
        temp.setData(temp.getNext().getData());
        temp=temp.getNext();
    }
}
}
