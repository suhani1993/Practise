import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {

	static int[][] findPairsWithGivenDifference(int[] arr, int k) {
	    int[][] differencePairArr = null;
	    for(int i=0;i<arr.length;i++){
	      for(int j=0;j<arr.length;j++){
	        int temp = arr[i] - arr[j];
	        if(temp == k){
	          if(i == 0){
	        	differencePairArr = new int[5][6];
	          }
	          differencePairArr[i][j] = arr[i];
	          differencePairArr[i][j+1] = arr[j];
	        }
	      }
	    }
	    return differencePairArr;
	  }

	  public static void main(String[] args) {
	    int[] arr = new int[]{0,-1,-2,2,1};
	    int k = 1;
	    int[][] findPairsWithGivenDifferenceArr = findPairsWithGivenDifference(arr, k);
	    System.out.println(Arrays.deepToString(findPairsWithGivenDifferenceArr));
	    
	    
	    //Using arraylist
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(0);
	    list.add(-1);
	    list.add(-2);
	    list.add(2);
	    list.add(1);
	    
	    findPairsWithGivenDifferenceUsingList(list, k);
	  }

	private static void findPairsWithGivenDifferenceUsingList(List<Integer> list, int k) {
		List<List<Integer>> outerList = new ArrayList<List<Integer>>();
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.size();j++){
				if((list.get(i) - list.get(j)) == k){
					List<Integer> integers = new ArrayList<Integer>();
					integers.add(list.get(i));
					integers.add(list.get(j));
					outerList.add(integers);
				}
			}
		}
		System.out.println(outerList);
	}
}
