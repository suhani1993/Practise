import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestPascal {

	public static void main(String[] args) {
		
		printPascalArr(3);

	}

	private static void printPascalArr(int numRows) {

	/*	Using array*/
//	private static void printPascalArr(int no) {
//		int arr[][] = new int[no][no];
//		for(int row=0;row<no;row++){
//			for(int col=0;col<=row;col++){
//				if(row == col || col == 0){
//					arr[row][col] = 1;
//				}else{
//					arr[row][col]=arr[row-1][col-1] + arr[row-1][col];
//				}
//				System.out.print(arr[row][col]);
//			}
//			System.out.println();
//		}
		
		
		/*Using ArrayList*/
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for(int i=0;i<numRows;i++){
			List<Integer> innerList = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				if(j==0 || j==i){
					innerList.add(1);
				}else{
					List<Integer> tempList = (ArrayList<Integer>) list.get(i-1);
					innerList.add(tempList.get(j-1) + tempList.get(j));
				}
			}
			list.add(innerList);
		}
		
		Iterator<List<Integer>> iterator = list.iterator();
		while (iterator.hasNext()) {
			List<Integer> next = iterator.next();
			System.out.println(next);
		}
		
		List list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		int indexOf = list1.indexOf(2);
		System.out.println("indexof :: " + indexOf);
	}
}
