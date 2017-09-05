//import CITS2200.*;
import java.util.*;
import java.util.PriorityQueue;

public class Methods 
{
	
	static public int getShortestPaths(int[][] edgeMatrix, int s) //returns the sum of all shortest paths
	{
		final int INFINITY = Integer.MAX_VALUE;
		int size = edgeMatrix[0].length;
		int[] distance = new int[size];
		boolean[] visited = new boolean[size];
		int sum = 0;
		
		Comp<Node> comparator = new Comp<Node>();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(size*size, comparator);
		
		for (int i = 0; i < size; i++) {
			distance[i] = INFINITY;
			visited[i] = false;
			queue.add(new Node(i, INFINITY));
		}
		
		queue.add(new Node(s, 0));
		
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if (visited[currentNode.index] == true)
				continue;
			distance[currentNode.index] = currentNode.priority;
			visited[currentNode.index] = true;
			
			int[] neighbourSearch = new int[size];
			int neighbourCount = 0;
			for (int i = 0; i < size; i++) {
				if (edgeMatrix[currentNode.index][i] != 0) {
					neighbourSearch[neighbourCount] = i;
					neighbourCount++;
				}
			}
			
			int[] neighbours = new int[neighbourCount];
			
			for (int i = 0; i < neighbourCount; i++) 
			{
				neighbours[i] = neighbourSearch[i];
			}
			
			for (int n : neighbours) 
			{
				if (visited[n] == true)
					continue;
				int cost = currentNode.priority + edgeMatrix[currentNode.index][n];
				if (cost < distance[n]) 
				{
					distance[n] = cost;
					queue.add(new Node(n, cost));
				}
			}			
		}
		for(int i = 0; i<size; i++)
		{
			if(distance[i]>0)
				sum += distance[i];
		}

		return sum;
	}
	
	//returns matrix with retn[1] being the closeness counts and retn[0] being the node numbers
	static double[][] closenessCentrality(int[][] edge,ArrayList<Integer> nodeNames) throws Exception 
	{
		int size = edge[0].length;
		double[][] retn = new double[2][5];
		double[][] closeness = new double[size][2];
		double close;


		for(int i = 0; i<size; i++) // array number 0 -> 65 (edge length)
		{
			close = Math.pow(getShortestPaths(edge, i),-1);
			closeness[i][0] = close; //assign actual node number to its closeness
			closeness[i][1] =  nodeNames.get(i);
		}
		for(int i = 0; i<5; i++) // return 5 top closeness nodes
		{
			double top = 0;
			int topIndex = 0;
			int index = 0;
			for(int j = 0; j<size; j++)
			{
				if(closeness[j][0] > top)
				{
					top = closeness[j][0];
					topIndex = (int) closeness[j][1];
					index = j;
				}
			}
			retn[0][i] = topIndex;
			retn[1][i] = top;
			closeness[index][0] = 0;
		}
		return retn;
	}
	
	static int getKatzShortestPaths(int[][] edge, int start, double alpha) 
	{
		final int INFINITY = Integer.MAX_VALUE;
		int size = edge[0].length;
		int[] distance = new int[size];
		boolean[] visited = new boolean[size];
		int sum = 0;
		
		Comp<Node> comparator = new Comp<Node>();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(size*size, comparator);
		
		for (int i = 0; i < size; i++) 
		{
			distance[i] = INFINITY;
			visited[i] = false;
			queue.add(new Node(i, INFINITY));
		}
		
		queue.add(new Node(start, 0));
		
		while (!queue.isEmpty()) 
		{
			Node currentNode = queue.poll();
			if (visited[currentNode.index] == true)
				continue;
			distance[currentNode.index] = currentNode.priority;
			visited[currentNode.index] = true;
			
			int[] neighbourSearch = new int[size];
			int neighbourCount = 0;
			for (int i = 0; i < size; i++) {
				if (edge[currentNode.index][i] != 0) {
					neighbourSearch[neighbourCount] = i;
					neighbourCount++;
				}
			}
			
			int[] neighbours = new int[neighbourCount];
			
			for (int i = 0; i < neighbourCount; i++) {
				neighbours[i] = neighbourSearch[i];
			}
			
			for (int n : neighbours) {
				if (visited[n] == true)
					continue;
				int cost = currentNode.priority + edge[currentNode.index][n];
				if (cost < distance[n]) {
					distance[n] = cost;
					queue.add(new Node(n, cost));
				}
			}			
		}

		for(int i = 0; i < size; i++)
		{
			int degreeCentrality = 0;
			for(int j = 0; j < size; j++)
			{
				if(edge[i][j] != 0 || edge[j][i] != 0)
					degreeCentrality++;
			}	
			sum += degreeCentrality * Math.pow(alpha, distance[i]);
		}
		return sum;
	}
	

	static double[][] katzCentrality(int[][] edge, ArrayList<Integer> nodeNames)
	{
		double alpha = 0.5;
		int size = edge[0].length;
		double[] katz = new double[size];
		double[][] retn = new double[2][5];
		
		for(int i = 0; i< size; i++)
		{
			katz[i] = getKatzShortestPaths(edge,i,alpha);
		}
		
		for(int i = 0; i< 5; i++) 
		{
			double top = 0;
			int topIndex = 0;
			for(int j = 0; j < size; j++)
			{
				if( katz[j]> top)
				{
					top = katz[j];
					topIndex = j;
				}
			}
			retn[1][i] = top;
			retn[0][i] = nodeNames.get(topIndex);
			katz[topIndex] = 0;
		}
		return retn;
	}
	

	
	private static class Comp<E> implements Comparator<Node> 
	{

		public int compare(Node o1, Node o2) 
		{
			return o1.priority - o2.priority;
		}
		
	}
	
	static private class Node {

		private int index;
		

		private int priority;
		
		private Node(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}
	



}