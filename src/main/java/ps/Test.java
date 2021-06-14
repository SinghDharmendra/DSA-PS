package ps;

public class Test {
    public static void main(String[] args) {
        int[] a1={-1,1,3,5,7,9};
        int[] a2={-2,2,3,4,5,6};

        int [] r=mergeArrays(a1,a2);

        for(int in:r){
            System.out.println(in);
        }


        boolean g=("hello"=="he"+"llo");
        System.out.println(g);


    }


    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int l1 = arr1.length;
        int l2 = arr2.length;

        int[] result = new int[l1 + l2];


        int i = 0, j = 0, k = 0;

        while (i < l1 && j < l2) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < l1) {
            result[k++] = arr1[i++];
        }


        while (j < l2) {
            result[k++] = arr2[j++];
        }


        return result;

    }


}
