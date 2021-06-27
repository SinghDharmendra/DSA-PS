package ps.dp.tree;

public class DiameterOfTree {
    int result = Integer.MIN_VALUE;

    public static void main(String[] args) {

        DiameterOfTree mps = new DiameterOfTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        System.out.println("maximum path sum is : " +
                mps.diameter(root));

    }

    public int diameter(TreeNode root) {
        solve(root);
        return result;
    }

    public int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = solve(root.left);
        int right = solve(root.right);
        //System.out.println("left"+left+"right"+right+"val"+root.val);
        int tmp = Math.max(left, right) + 1;

        //System.out.println("temp"+tmp);
        int ans = Math.max(tmp,left + right + 1);
        //System.out.println("ans"+ans);
        result = Math.max(result, ans);
        return tmp;
    }
}
