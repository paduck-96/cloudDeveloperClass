import java.util.Arrays;

public class QuickSortMain {
    // 퀵 소트 메서드
    //left는 비교의 시작위치, right는 비교의 반대편 끝
    //data가 정렬할 배열
    public static void quickSort(int left, int right, int [] data){
        System.out.println(Arrays.toString(data));

        // 기준점 설정 - 이론은 임의의 위치(중앙)
        //구현은 왼쪽 기준
        int pivot = left;
        //큰 데이터 찾는 인덱스
        int i = left+1;
        //작은 인덱스 찾는 인덱스는 right
        //추후 자리 교환 때문에 pivot 위치 저장
        int j = pivot;
        
        // 배열의 데이터가 2개 이상인 경우만 수행
        //배열 1개면 left 와 right가 같아짐
        if(left<right){
            for(;i<=right;i++){
                if(data[i]<data[pivot]){
                    j++;
                    int temp = data[j];
                    data[j]=data[i];
                    data[i]=temp;
                }
            }
            // pivot 위치 데이터를 자신의 위치로 이동
            int temp = data[left];
            data[left]=data[j];
            data[j]=temp;
            // pivot의 위치를 비교가 끝난 자리로 수정
            //pivot의 양쪽 부분을 다시 quicksort
            pivot = j;
            quickSort(left, pivot-1, data);
            quickSort(pivot+1,right,data);
        }
    }
    public static void main(String [] args){
        int [] ar = {78,87,23,45,98,27,88};
        quickSort(0, ar.length-1, ar);
        System.out.println("오름차순 정렬");
        System.out.println(Arrays.toString(ar));
        // 정렬 수행하지 않고 하면 논리적인 오류 발생
        System.out.println(Arrays.binarySearch(ar, 27));
    }
}
