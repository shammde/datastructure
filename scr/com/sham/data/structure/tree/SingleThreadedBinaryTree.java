package com.sham.data.structure.tree;

import com.sham.data.structure.node.Node;

public class SingleThreadedBinaryTree {

    public static Node<Integer> root;

    public void insert(Node<Integer> root, int id){
        Node<Integer> newNode = new Node<Integer>(id);
        Node<Integer> current = root;
        Node<Integer> parent = null;
        while(true){
            parent = current;
            if(id<current.getData()){
                current = current.getLeftChild();
                if(current==null){
                    parent.setLeftChild(newNode);
                    newNode.setRightChild(parent);
                    newNode.setRThread(true);
                    return;
                }
            }else{
                if(current.isRThread()==false){
                    current = current.getRightChild();
                    if(current==null){
                        parent.setRightChild(newNode);
                        return;
                    }
                }else{
                    Node<Integer> temp = current.getRightChild();
                    current.setRightChild(newNode);
                    newNode.setRightChild(temp);
                    newNode.setRThread(true);
                    return;
                }
            }
        }
    }

    public void print(Node<Integer> root){
        //first go to most left node
        Node<Integer> current = leftMostNode(root);


        //now travel using right pointers
        while(current!=null){
            System.out.print(" " + current.getData());
            //check if node has a right thread
            if(current.isRThread())
                current = current.getRightChild();
            else // else go to left most node in the right subtree
                current = leftMostNode(current.getRightChild());
        }
        System.out.println();
    }

    public Node<Integer> leftMostNode(Node<Integer> node){
        if(node==null){
            return null;
        }else{
            while(node.getLeftChild() != null){
                node = node.getLeftChild();
            }
            return node;
        }
    }

    public static void main(String[] args) {
        root = new Node<Integer>(100);
        SingleThreadedBinaryTree st = new SingleThreadedBinaryTree();
        st.insert(root,50);
        st.insert(root,25);
        st.insert(root,7);
        st.insert(root,20);
        st.insert(root,75);
        st.insert(root,99);

        st.print(root);
        //root.printTree();
    }
}
