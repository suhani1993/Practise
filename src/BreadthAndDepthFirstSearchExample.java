import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * 
 * @author Suhani
 * It is a graph algorithm. It is traversal algorithm.
 * In a graph starting from a node,
 * that node is added in queue as well as 
 * it's children/connected nodes are also added in queue.
 * After all the children added in queue, any one child's children then added in queue then the other one's and so on.
 *       3  5
 *       | /
 *       |/
 * 1 -- 2 -- 4
 * 
 * when starting from 1, it's child is 2 then 2's children are 3, 4, 5.
 * 
 * Queue filled by :: 1,2,3,5,4
 * 
 *
 */
public class BreadthAndDepthFirstSearchExample {

	Queue<Node> queue;
	Stack<Node> stack;
	BreadthAndDepthFirstSearchExample(){
		queue = new LinkedList<Node>();
		stack = new Stack<Node>();
	}
	public static void main(String[] args) {
		BreadthAndDepthFirstSearchExample searchExample = new BreadthAndDepthFirstSearchExample();
		Node node10 = searchExample.new Node(10);
		Node node20 = searchExample.new Node(20);
		Node node30 = searchExample.new Node(30);
		Node node40 = searchExample.new Node(40);
		Node node50 = searchExample.new Node(50);
		Node node60 = searchExample.new Node(60);
		Node node70 = searchExample.new Node(70);
		
		
		/*  
		 * 50 ---  70
		 *  |     /
		 *  |    /
		 *  |   60
		 *  |  / |    
		 *  | /  |    
		 * 20 -- 30
		 *  | \  
		 *  |  \
		 * 40 -- 10
		 * 
		 */
		node40.addNeighbours(node10);
		node40.addNeighbours(node20);
		node30.addNeighbours(node60);
		node20.addNeighbours(node10);
		node20.addNeighbours(node30);
		node20.addNeighbours(node60);
		node20.addNeighbours(node50);
		node60.addNeighbours(node70);
		node50.addNeighbours(node70);
		
//		searchExample.bfs(node40);
//		System.out.println();
//		searchExample.dfs(node40);
//		searchExample.dfsusingQueue(node40);
		searchExample.dfsUsingStack(node40);
	}
	
	/*
	 * DFS using stack
	 */
	private void dfsUsingStack(Node node) {
		stack.push(node);
		node.isVisited=true;
		while(!stack.isEmpty()){
			Node removedNode = stack.pop();
			System.out.print(removedNode.value + " ");
			for (int i = 0; i < removedNode.getNeighbours().size(); i++) {
				Node neighbour = removedNode.getNeighbours().get(i);
				if(neighbour != null && !neighbour.isVisited){
					stack.push(neighbour);
					neighbour.isVisited=true;
				}
			}
		}
	}
	/*
	 * DFS traversal with recursion
	 */
	private void dfs(Node node) {
		node.isVisited = true;
		System.out.print(node.value + " ");
		for (int i = 0; i < node.getNeighbours().size(); i++) {
			if(!node.getNeighbours().get(i).isVisited){
				dfs(node.getNeighbours().get(i));
			}
		}
	}
	
	/*
	 * DFS using queue
	 */
	private void dfsusingQueue(Node node){
		queue.add(node);
		node.isVisited = true;
		Node removedNode = queue.remove();
		System.out.print(removedNode.value + " ");
		List<Node> neighbours = removedNode.getNeighbours();
		for (int i = 0; i < neighbours.size(); i++) {
			Node childNode = neighbours.get(i);
			if(childNode != null && !childNode.isVisited){
				dfsusingQueue(childNode);
			}
		}
	}
	
	/*
	 * BFS traversal with recursion
	 */
	public void bfs(Node node){
		queue.add(node);
		node.isVisited = true;
		while(!queue.isEmpty()){
			Node removedNode = queue.remove();
			System.out.print(removedNode.value + " ");
			List<Node> neighbours = removedNode.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				Node neighbour = neighbours.get(i);
				if(neighbour != null && !neighbour.isVisited){
					queue.add(neighbour);
					neighbour.isVisited=true;
				}
			}
		}
	}
	
	class Node{
		int value;
		List<Node> neighbours;
		boolean isVisited;
		public List<Node> getNeighbours() {
			return neighbours;
		}
		public void addNeighbours(Node node) {
			neighbours.add(node);
		}
		
		Node(int value){
			this.value = value;
			this.neighbours = new ArrayList<Node>();
			isVisited = false;
		}
	}
}
