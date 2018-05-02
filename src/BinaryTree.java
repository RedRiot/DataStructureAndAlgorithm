public class BinaryTree {
    Node root;

    public void addNote(int key, String name) {
        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    public void indOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            indOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode.toString());
            indOrderTraverseTree(focusNode.rightChild);
        }
    }

    public void preOrderTraverseTrww(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode.toString());
            preOrderTraverseTrww(focusNode.leftChild);
            preOrderTraverseTrww(focusNode.rightChild);
        }
    }
    public void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {

            postOrderTraverseTree(focusNode.leftChild);
            postOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode.toString());
        }
    }

    public boolean remove(int key) {
        Node focusNode = root;
        Node parent = root;
        boolean isItAleftChild = true;
        while (focusNode.key != key) {
            if (key < focusNode.key) {

                isItAleftChild = true;
                parent = focusNode;

            } else {

                isItAleftChild = false;
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) {
                return false;
            }
        }
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root) {
                root = null;
            } else if (isItAleftChild) {
                parent.leftChild = null;

            } else parent.rightChild = null;
        } else if (focusNode.rightChild == null) {
            if (focusNode == root) {
                root = focusNode.leftChild;

            } else if (isItAleftChild) {
                parent.leftChild = focusNode.leftChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        } else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            } else if (isItAleftChild) {
                parent.leftChild = focusNode.rightChild;
            } else {
                parent.rightChild = focusNode.leftChild;
            }
        } else {
            Node replacement = getReplacementNode(focusNode);
            if (focusNode == root) {
                root = replacement;
            } else if (isItAleftChild) {
                parent.rightChild = replacement;
            } else {
                replacement.leftChild = focusNode.leftChild;
            }
        }
        return true;
    }

    public Node getReplacementNode(Node replacedNode) {
        Node replacementParent = replacedNode;
        Node replacement = replacedNode;

        Node focusNode = replacedNode.rightChild;
        while (focusNode != null) {
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild;
        }
        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacedNode.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }

    public static void main(String[] args) {
        BinaryTree theTree = new BinaryTree();
        theTree.addNote(50,"BOss");
        theTree.addNote(25,"sdas");
        theTree.addNote(15,"fsd");
        theTree.addNote(30,"gdfgv");
        theTree.addNote(75,"vdscsd");
        theTree.addNote(85,"cxxv");

        theTree.postOrderTraverseTree(theTree.root);
        System.out.println();
        System.out.println(theTree.findNode(85));

    }
}
class  Node{
    int key;
    String name;
    Node leftChild;
    Node rightChild;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

 public String toString() {
     return name + " has a key " + key;
    }
}
