import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: inti
 * Date: 6/15/13
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Node {
    public Node(String className) {
        parent = null;
        this.className = className;
        children = new ArrayList<Node>();
    }

    public Node addChild(String clazz) {
//        if (className.equals("java/lang/Object"))
//            System.out.println();
        Node node = new Node(clazz);
        int index = children.indexOf(node);
        if (index != -1) {
            return children.get(index);
        }
        children.add(node);
        node.parent = this;
        return node;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (className != null ? !className.equals(node.className) : node.className != null) return false;

        return true;
    }


    String className;
    ArrayList<Node> children;
    Node parent;
    boolean included;
}
