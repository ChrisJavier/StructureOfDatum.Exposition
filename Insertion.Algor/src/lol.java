
public class lol {

	static void insertionSort (int[] A) {
		 int j;
		 for (int i = 1; i < A.length; i++) {
		     int a = A[i];
		     for (j = i - 1; j >=0 && A[j] > a; j--){
		          A[j + 1] = A[j];
		     }
		     A[j + 1] = a;
		 }
		}
	
	public static void main(String agrs[]){
		int A[]={3,2,7,9,5,1};
		
		insertionSort(A);
	}
}
