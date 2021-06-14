package tree.bt.checkandprint;

import tree.Node;

import java.util.Stack;

public class MirrorImage {
    public static void main(String[] args)
    {
        // 1st binary tree formation 
        Node root1 = new Node(1);         /*         1         */
        root1.left = new Node(3);         /*     / \     */
        root1.right = new Node(2);         /*     3     2     */
        root1.right.left = new Node(5);     /*         / \     */
        root1.right.right = new Node(4); /*         5     4 */

        // 2nd binary tree formation     
        Node root2 = new Node(1);         /*         1         */
        root2.left = new Node(2);         /*     / \     */
        root2.right = new Node(3);         /*     2     3     */
        root2.left.left = new Node(4);     /* / \         */
        root2.left.right = new Node(5);     /* 4 5         */

        System.out.println(areMirrors(root1, root2));
    }

    private static String areMirrors(Node root1, Node root2) {
        Stack<Node> st1=new Stack<>();
        Stack<Node> st2=new Stack<>();

        while(true){
            while(root1!=null && root2!=null){
                if(root1.data!=root2.data)
                    return "NO";
                st1.push(root1);
                st2.push(root2);
                root1=root1.left;
                root2=root2.right;

            }
            if(!(root1==null && root2==null)){
                return "NO";
            }

            if(!st1.isEmpty() && !st2.isEmpty()){
                root1=st1.pop();
                root2=st2.pop();

                root1=root1.right;
                root2=root2.left;
            }else{
                break;
            }
        }
        return "YES";
    }
}
