package ps.bs;

import java.util.Arrays;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        int pages[] = {12, 34, 67, 90};
        int students=2;
        Arrays.sort(pages);
        int len = pages.length;
        int start = pages[len-1];
        int end = Arrays.stream(pages).sum();
        System.out.println("start"+start+"end"+end);
        int max=findMaxDiff(pages,start,end,students,len);
        System.out.println("Max pages assigned to one"+max);
    }

    private static int findMaxDiff(int[] pages, int start, int end, int m,int len) {
        int res=-1;
        while(start<=end){
            int mid= start  + (end-start)/2;
            System.out.println("mid"+mid);
            if(isValid(pages,mid,m)){
                res=mid;
                end=mid-1;

            }else{
                start=mid+1;
            }
        }
        return  res;
    }

    private static boolean isValid(int[] pages, int mid, int m) {
        int st=1;
        int sum=0;

        for(int i = 0; i<pages.length; i++){
            sum+=pages[i];
            if(sum> mid){
                st++;
                sum=pages[i];
                if(st>m)
                    return false;
            }
        }
        return true;
    }
}
