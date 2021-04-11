import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] resultD = new int[input[0]];
		ArrayList<Integer> finalListD = new ArrayList<Integer>();
		ArrayList<Integer> finalListB = new ArrayList<Integer>();
		ArrayList<Node> dfs = new ArrayList<Main.Node>();
		LinkedList<LinkedNode> bfs = new LinkedList<Main.LinkedNode>();

		// 노드 생성중
		for (int i = 0; i < input[0]; i++) {
			Node newNode = new Node();
			LinkedNode newLinkedNode = new LinkedNode();
			newNode.setNum(i + 1);
			newLinkedNode.setNum(i + 1);
			dfs.add(newNode);
			bfs.add(newLinkedNode);
		}

		// 노드의 입력을 받음
		for (int i = 0; i < input[1]; i++) {
			int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			dfs.get(input2[0]-1).setNexts(input2[1]);
			dfs.get(input2[1]-1).setNexts(input2[0]);
			bfs.get(input2[0]-1).setNexts(input2[1]);
			bfs.get(input2[1]-1).setNexts(input2[0]);
		}
		
		for( int i = 0; i < input[0]; i++) {
			Collections.sort(dfs.get(i).getNexts());
			Collections.sort(bfs.get(i).getNexts());
		}
		
		// dfs실행, bfs실행
		dfs_method(dfs, input[2], resultD, 0);
		bfs_method(bfs, input[2], finalListB);
		
		for(int temp : resultD){
			  finalListD.add(temp);
		}
		while(finalListD.contains((Integer)0)){
		finalListD.remove((Integer)0);
		}
		
		for (int i = 0; i < finalListD.size(); i++) {
			System.out.print(finalListD.get(i) + " ");
		}
		System.out.println();
		for (int i = 0; i < finalListB.size(); i++) {
			System.out.print(finalListB.get(i) + " ");
		}
	}

	//DFS노드
	public static class Node {
		private int num;
		private ArrayList<Integer> nexts = new ArrayList<Integer>();
		private boolean check = false;

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public ArrayList<Integer> getNexts() {
			return nexts;
		}

		public void setNexts(int next) {
			this.nexts.add(next);
		}

		public boolean isCheck() {
			return check;
		}

		public void setCheck(boolean check) {
			this.check = check;
		}
	}

	//BFS노드
	public static class LinkedNode{

		private int num;
		private boolean check = false;
		private LinkedList<Integer> nexts = new LinkedList<Integer>();
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public boolean isCheck() {
			return check;
		}
		public void setCheck(boolean check) {
			this.check = check;
		}
		public LinkedList<Integer> getNexts() {
			return nexts;
		}
		public void setNexts(int nexts) {
			this.nexts.add(nexts);
		}
	}
	
	// DFS
	public static int dfs_method(ArrayList<Node> dfs, int now, int[] result, int tmp) {
		Node nowNode = dfs.get(now - 1);
		int nextLeng = 0;

		if (!nowNode.isCheck()) {
			nowNode.setCheck(true);
			result[tmp] = now;
			tmp++;
			if (nowNode.getNexts().isEmpty()) {

			} else {
				for (int l = 0; l < nowNode.getNexts().size(); l++) {
					tmp = dfs_method(dfs, nowNode.getNexts().get(nextLeng), result, tmp);
					nextLeng++;
				}
			}
		}

		return tmp;
	}

	//BFS
	public static void bfs_method(LinkedList<LinkedNode> bfs, int now, ArrayList<Integer> finalListB) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		LinkedNode here = bfs.get(now-1);
		
		if(!here.isCheck()) {
			here.setCheck(true);
			queue.add(here.getNum());
		}
		
		while(queue.size()!=0) {
			int then = queue.poll();
			here = bfs.get(then-1);
			finalListB.add(then);
			
			Iterator<Integer> iterator = here.getNexts().listIterator();
			while (iterator.hasNext()) {
				int there = iterator.next();
				if (!bfs.get(there-1).isCheck()) {
					bfs.get(there-1).setCheck(true); 
					queue.add(there);
				}
			}
		}
	}

}
