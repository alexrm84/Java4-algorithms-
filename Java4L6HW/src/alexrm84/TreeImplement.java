package alexrm84;

import javafx.scene.layout.Priority;

import java.util.Stack;

public class TreeImplement<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> rootNode;

    public Node<E> getRootNode() {
        return rootNode;
    }

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (isEmpty()){
            rootNode=newNode;
            rootNode.setLevel(0);
            return;
        }
        Node<E> current = rootNode;
        int currentLVL = 0;
        Node<E> previous = null;
        while (current!=null){
            previous=current;
            currentLVL++;
            if (current.getValue().equals(value) || currentLVL==4){
                return;
            }
            if (current.shouldLeftChild(value)){
                current=current.getLeftChild();
            }else {
                current=current.getRightChild();
            }
        }
        if (previous.shouldLeftChild(value)){
            previous.setLeftChild(newNode);
            newNode.setLevel(currentLVL);
        }else {
            previous.setRightChild(newNode);
            newNode.setLevel(currentLVL);
        }

    }

    @Override
    public boolean remove(E value) {
        Node<E> current = rootNode;
        Node<E> parent = null;
        while (current!=null){
            if (current.getValue().equals(value)){
                break;
            }
            parent=current;
            if (current.shouldLeftChild(value)){
                current=current.getLeftChild();
            }else {
                current=current.getRightChild();
            }
        }
        if (current==null){
            return false;
        }
        if (isLeaf(current)){
            if (current==rootNode){
                rootNode=null;
            }else if (parent.getLeftChild().equals(current)){
                    parent.setLeftChild(null);
                }else {
                    parent.setRightChild(null);
                }
        }else if (hasOnlySingleChildElement(current)) {
            Node<E> childNode = current.getLeftChild() != null
                    ? current.getLeftChild()
                    : current.getRightChild();
            if (current==rootNode){
                rootNode=childNode;
            }else if (parent.getLeftChild().equals(current)){
                parent.setLeftChild(childNode);
                }else {
                parent.setRightChild(childNode);
            }
        }else {
            Node<E> successor = getSuccessor(current);
            if (current==rootNode){
                rootNode=successor;
            }else if (parent.getLeftChild().equals(current)){
                parent.setLeftChild(successor);
            }else {
                parent.setRightChild(successor);
            }
            successor.setLeftChild(current.getLeftChild());
        }
        return true;
    }

    private Node<E> getSuccessor(Node<E> removeNode){
        Node<E> successor=removeNode;
        Node<E> successorParent= null;
        Node<E> curent = removeNode.getRightChild();
        while (curent!=null){
            successorParent=successor;
            successor=curent;
            curent=curent.getLeftChild();
        }
        if (successor!=removeNode.getRightChild()){
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(removeNode.getRightChild());
        }
        return successor;
    }

    private boolean hasOnlySingleChildElement(Node<E> current){
        return current.getLeftChild()==null || current.getRightChild()==null;
    }

    private boolean isLeaf(Node<E> current){
        return current.getLeftChild()==null && current.getRightChild()==null;
    }

    @Override
    public boolean find(E value) {
        Node<E> current = rootNode;
        while (current!=null){
            if (current.getValue().equals(value)){
                return true;
            }
            if (current.shouldLeftChild(value)){
                current=current.getLeftChild();
            }else {
                current=current.getRightChild();
            }
        }
        return false;
    }

    @Override
    public void display() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(rootNode);
        int nBlanks=64;
        boolean isRowEmpty=false;
        System.out.println("--------------------------------------------------------------");
        while (!isRowEmpty){
            Stack<Node> localStack = new Stack<>();
            isRowEmpty=true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()){
                Node tempNode = globalStack.pop();
                if (tempNode!=null){
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild()!=null || tempNode.getRightChild()!=null){
                        isRowEmpty=false;
                    }
                }else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < nBlanks*2-2; i++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            while (!localStack.isEmpty()){
                globalStack.push(localStack.pop());
            }
            nBlanks/=2;
        }
        System.out.println("--------------------------------------------------------------");
    }

    @Override
    public boolean isEmpty() {
        return rootNode==null;
    }

    @Override
    public void travers(TraversMode traversMode) {
        switch (traversMode){
            case IN_ORDER:
                inOrder(rootNode);
                break;
            case PRE_ORDER:
                preOrder(rootNode);
                break;
            case POST_ORDER:
                postOrder(rootNode);
                break;
            default:
                throw new IllegalArgumentException("Unknown traverse mode    " + traversMode);
        }
    }

    private void inOrder(Node<E> node){
        if (node==null){
            return;
        }
        inOrder(node.getLeftChild());
        System.out.println(node);
        inOrder(node.getRightChild());
    }

    private void preOrder(Node<E> node){
        if (node==null){
            return;
        }
        System.out.println(node);
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
    }

    private void postOrder(Node<E> node){
        if (node==null){
            return;
        }
        inOrder(node.getLeftChild());
        inOrder(node.getRightChild());
        System.out.println(node);
    }
}
