package sg;

public class SegmentTreeRangeMin {
    static STNode constructSegmentTree(int[] A, int l, int r) {
        if (l == r) {
            STNode node = new STNode();
            node.leftIndex = l;
            node.rightIndex = r;
            node.min = A[l];
            return node;
        }
        int mid = (l + r) / 2;
        STNode leftNode = constructSegmentTree(A, l, mid);
        STNode rightNode = constructSegmentTree(A, mid + 1, r);
        STNode root = new STNode();
        root.leftIndex = leftNode.leftIndex;
        root.rightIndex = rightNode.rightIndex;
        root.min = Math.min(leftNode.min, rightNode.min);
        root.leftNode = leftNode;
        root.rightNode = rightNode;
        return root;
    }

    static int getMin(STNode root, int l, int r) {
        if (root.leftIndex >= l && root.rightIndex <= r) {
            return root.min;
        }
        if (root.rightIndex < l || root.leftIndex > r) {
            return Integer.MAX_VALUE;
        }
        return Math.min(getMin(root.leftNode, l, r), getMin(root.rightNode, l, r));
    }

    /**
     * @param root
     * @param index    index of number to be updated in original array
     * @param newValue
     * @return difference between new and old values
     */
    static int updateValueAtIndex(STNode root, int index, int newValue) {
        int min = 0;
        if (root.leftIndex == root.rightIndex && index == root.leftIndex) {
            // We actually reached to the leaf node to be updated
            min = newValue;
            root.min = newValue;
            return min;
        }
        int mid = (root.leftIndex + root.rightIndex) / 2;
        if (index <= mid) {
            min = updateValueAtIndex(root.leftNode, index, newValue);
        } else {
            min = updateValueAtIndex(root.rightNode, index, newValue);
        }
        root.min = Math.min(min, root.min);
        return min;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;
        STNode root = constructSegmentTree(arr, 0, arr.length - 1);
        System.out.println(getMin(root, 3, 5));
    }

    public static class STNode {
        int leftIndex;
        int rightIndex;
        int min;
        STNode leftNode;
        STNode rightNode;
    }
}

