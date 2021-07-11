package ps.bs;

public class FindFirstOccuranceOf1InSortedArrayOF01 {
    public static void main(String[] args) {
        int in[]={0, 0, 0, 1, 1, 1};
        int idx=findFirstIndex(in);
        System.out.println("First occurance:"+idx);
    }

    private static int findFirstIndex(int[] in) {
        int start=0, end=1;
        while(in[end]==0){
            start=end;
            end=end*2;
        }
       return  bsForFirstOccurabnce(in, start,end,1);
    }

    private static int bsForFirstOccurabnce(int[] in, int start, int end,int ele) {
        if(end<start){
            return -1;
        }
        int res=-1;
        while(end>=start){
            int mid=start+(end-start)/2;
            if(in[mid]==ele){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
    }
}
