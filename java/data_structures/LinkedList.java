package data_structures;



public class LinkedList {
    private Node head;
    private Node tail;


    public LinkedList() {
        System.out.println("empty Linked list is generated");
    }
    public Node getHead(){
        return this.head;
    }
    public void setHead(Node head){
        this.head=head;
    }
    public Node getTail(){
        return this.tail;
    }
    public void setTail(Node tail){
        this.tail=tail;
    }

    public void addAtEnd(String data){           //add a node at thee tail end
        System.out.println("\n adding a new node at the end of the tail");
        Node node = new Node(data);
        if(this.head==null){                //check if LL is empty
            this.head=this.tail=node;
            //System.out.println("the linked list is empty so new node is head and tail - "+node.getData());
        }else{
            this.tail.setNext(node);        //add  node to the tail
            this.tail=node;                 // make new node tail
            //System.out.println("new node is added to the tail and new node is the tail - "+ node.getData());
        }
    }

    public void addAtBegin(String data){
        System.out.println("\n adding new node at beginning");
        Node node = new Node(data);
        if(this.head==null){
            this.head =this.tail=node;
            //System.out.println("the head and tail is new node - "+node.getData());
        }else{
            node.setNext(this.head);   //head node is set as the next of new node
            this.head=node;             //new node is set as the head
            //System.out.println("node is added at the beginnning");
        }
    }
    public void display(){
        Node temp;
        temp=this.head;
        while(temp!=null){
            System.out.print(temp.getData()+" => ");
            temp=temp.getNext();
        }
        System.out.println();
    }

    public Node find(String data){
        Node temp;
        Node nodeFound=null;
        temp=this.head;
        while(temp!=null){
            if(temp.getData().equals(data)){
                nodeFound=temp;
                System.out.println("node found");
                break;
            }else temp=temp.getNext();
        }
        return nodeFound;
    }

    public void insert( String data, String dataBefore){        //data is new node, dataBefore is the nodeBefore the new node after insert
        Node node = new Node(data);
        System.out.println("inserting node "+data+ " after "+ dataBefore+" node");
        Node nodeBefore = this.find(dataBefore);
        if(nodeBefore!=null){
            node.setNext(nodeBefore.getNext());
            nodeBefore.setNext(node);
            if(nodeBefore==this.tail){
                this.tail=node;
            }
        }else System.out.println("nodeBefore is not found in linkedList");
    }
    public void delete(String data){
        
        Node node = this.find(data);
        if(node==null) System.out.println("node not found");
        else if(node==this.head){        //if node to delete is the head node
            this.head=node.getNext();
            node.setNext(null);
            if(this.tail==node) tail=null;
        }else {
            Node nodeBefore=null;
            Node temp =this.head;
            while(temp!=null){
                if(temp.getNext()==node){
                    nodeBefore=temp;
                    break;
                }temp=temp.getNext();
            }
            nodeBefore.setNext(node.getNext());
            node.setNext(null);
            if(node==this.tail) this.tail=nodeBefore;
        }
    }

    
}
