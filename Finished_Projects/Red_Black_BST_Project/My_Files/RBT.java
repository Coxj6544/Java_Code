/**
 * RBT
 * Red-Black Tree Insert
 * @author James Cox
 */
import java.util.*;
public class RBT {
    public Node root;

    public RBT() {}

    public boolean isRed(Node x) {
        if (x == null) return false;
        return x.getColor() == Node.Color.RED;
    }
    
    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(int x) {
        return nodeContainsData(root, x);
    }

    private boolean nodeContainsData(Node r, int x) {
        while (r != null) {
            if (r.getData() - x < 0) {
                r = r.getLeft();
            } else if (r.getData() - x > 0) {
                r = r.getRight();
            } else {
                return true;
            }
        }
        return false;
    }

    public List<Integer> serializeTree() {
        return serializeTree(root);
    }

    private List<Integer> serializeTree(Node r) {
        if (r == null) return new LinkedList<>();
        int data = r.getData();
        List<Integer> left = serializeTree(r.getLeft());
        List<Integer> right = serializeTree(r.getRight());
        left.add(data);
        left.addAll(right);
        return left;
    }

    public int maxHeight() {
        return maxHeight(root);
    }

    private int maxHeight(Node r) {
        if (r==null) return 0;        
        return 1 + Math.max(maxHeight(r.getLeft()), maxHeight(r.getRight()));
    }




    // ************************************************************************
    // * INSERT INTO RED-BLACK TREE
    // ************************************************************************

    public void insert(int x) {
        root = nodeInsertData(root, x);
        root.setColor(Node.Color.BLACK);
    }

    public Node nodeInsertData(Node r, int x) {
        if (r == null) return new Node(x, Node.Color.RED);
        else{
            if(x < r.getData()){
                r.setLeft(nodeInsertData(r.getLeft(), x));
            } 
            else {
                r.setRight(nodeInsertData(r.getRight(), x));
            }
        }
        return r; 

        // TODO: Add the RBT balancing code here!
    }

    public Node rotateRight(Node h) {
        assert (h != null) && isRed(h.getLeft());
        Node y = h.getLeft();
        Node tempNode = y.getRight();

        y.setRight(h);
        h.setLeft(tempNode);
        return y;
    }
 
    public Node rotateLeft(Node h) {
        assert (h != null) && isRed(h.getRight());
        Node y = h.getRight();
        Node tempNode = y.getLeft();


        y.setLeft(h);
        h.setRight(tempNode);
        return y;
    }

    // flip the colors of a node and its two children
    public void flipColors(Node h) {
        if(h.getColor() == Node.Color.RED){
            h.setColor(Node.Color.BLACK);
        }
        else{
            h.setColor(Node.Color.RED);
        }
        if(h.getLeft() != null){
            if(h.getLeft().getColor() == Node.Color.RED){
                h.getLeft().setColor(Node.Color.BLACK);
            }
            else{
                h.getLeft().setColor(Node.Color.RED);
            }
        }
        if(h.getRight() != null){
            if(h.getRight().getColor() == Node.Color.RED){
                h.getRight().setColor(Node.Color.BLACK);
            }
            else{
                h.getRight().setColor(Node.Color.RED);
            }
        }
    }
}
