package com.qs.algorithms.binarytree;

import java.util.Stack;

public class BinaryTree {

    /***
     * 前序遍历   根节点    左子树   右子树
     * 递归版
     */
    public void  preOrder(Node  root){
        if(root==null){
            System.out.println("你是不是有病，null你调用我的方法干嘛");
            return;
        }
        System.out.println(root.getData().byteValue());
        preOrder(root.getLlfte());
        preOrder(root.getRight());
    }

    /**
     * 非递归遍历   大概遍历根节点，然后把左节点一直放入到栈的数据结构。然后把栈中的元素的取出来遍历柚子树。
     * @param root
     */
    public   void  preOrder2(Node root){

        Stack<Node> stack  =new Stack<Node>();
        while (root!=null||!stack.empty()){
            /*第一步遍历跟结点，然后遍历左子树*/
            if (root!=null){
                System.out.println(root.getData());
                stack.push(root);
                root=root.getLlfte();
            }else {
                /*从栈中取出右结点遍历*/
                root=  stack.pop();
                root=root.getRight();
            }
        }
    }

    /**
     * 递归中序遍历  左子树    根节点    右子树
     *
     */
    public  void    inorderTraverse(Node root){

        if(root==null){
            System.out.println("你是不是有病，null你调用我的方法干嘛");
            return;
        }
        inorderTraverse(root.getLlfte());
        System.out.println(root.getData().byteValue());
        inorderTraverse(root.getRight());

    }
    //非递归算法的中序遍历
    public void inorderTraverse2(Node root){
        System.out.println("中根次序遍历（非递归）：");
        Stack<Node> stack = new Stack<Node>();//创建空栈

        while(root!=null||!stack.isEmpty()){//p非空或栈为空
            if(root!=null){
                stack.push(root);//p节点入栈
                root=root.getLlfte();//进入左子树
            }else{//p为空栈非空
                System.out.print("^ ");
                root= stack.pop();//p指向出栈节点
                System.out.print(root.data.toString()+" ");//访问节点
                root=root.right;  //进入右子树
            }
        }
        System.out.println("^");
    }
    /**
     * 递归后序遍历  左子树       右子树  根节点
     *
     */
    public  void    postorder(Node root){

        if(root==null){
            System.out.println("你是不是有病，null你调用我的方法干嘛");
            return;
        }
        postorder(root.getLlfte());
        postorder(root.getRight());
        System.out.println(root.getData().byteValue());

    }
    public void postorderTrave(Node  root){
        System.out.println("后根次序遍历（非递归）：");
        Stack<Node> stack = new Stack<Node>();
        //待操作栈
        Stack<Node> output = new Stack<Node>();

        System.out.print("^ ");
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                output.push(root); //进入待操作栈
                root=root.right; //先进入右子树
            }else{
                output.push(new Node()); //将null入待操作栈
                root = stack.pop();
                root = root.getLlfte();
            }
        }
        //依次出栈
        while(!output.isEmpty()){
            Node node = output.pop();
            if(node.getData()==null)
                System.out.print("^ ");
            else
                System.out.print(node.data.toString()+" ");
        }
        System.out.println();
    }

    public  class  Node{
        private  Integer  data;
        private   Node    llfte;
        private   Node     right;
        public Integer getData() {
            return data;
        }

        public void setData(Integer data) {
            this.data = data;
        }

        public Node getLlfte() {
            return llfte;
        }

        public void setLlfte(Node llfte) {
            this.llfte = llfte;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

}
