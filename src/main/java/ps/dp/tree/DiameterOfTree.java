package ps.dp.tree;

public class DiameterOfTree {
    int result = Integer.MIN_VALUE;

    public static void main(String[] args) {


        DiameterOfTree mps = new DiameterOfTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        //Correction path should be length of path not the no vertices
        //so answer will be result-1
        System.out.println("maximum path sum is : " +
                (mps.diameter(root) - 1));

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
