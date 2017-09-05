import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Centrality {

	public static MyNode[] centralityLatest(int[][] edgeMatrix,ArrayList<Integer> nodeNumbersUnique)
	{

		// CREATE ARRAY OF NODES EACH ASSIGNED THE NUMBER OF EDGES CONNECTED TO THEM
		int noOfNodes = edgeMatrix.length;
		MyNode[] nodes = new MyNode[noOfNodes];  // creates an array of Nodes 
		for (int start=0; start<noOfNodes;start++)
		{
			int count=0;
			for(int end =0; end<noOfNodes;end++)
			{
				if(edgeMatrix[start][end]==1) // if there is a link between 2 nodes
					count++;
			}
			nodes[start] = new MyNode("Degree",count,nodeNumbersUnique.get(start));
		}
		
		MyNode[] topFive = new MyNode[5];
		int largestIndex=0; // largest node index is 0
		for (int i =0; i<5; i++)
		{
			for (int  j=1; j<noOfNodes;j++)
			{
				if(nodes[largestIndex].getEdgeCount()<nodes[j].getEdgeCount())
				{
					largestIndex = j;
				}
			}
			topFive[i] = new MyNode("Degree",nodes[largestIndex].getEdgeCount(),nodes[largestIndex].getNodeNumber());
			nodes[largestIndex].setEdgeCount(0);
			largestIndex = 0;
		}
		return topFive;
	}

	public static MyNode[] betweennessBrandes (int[][]edgeMatrix, ArrayList<Integer> nodeNumbersUnique)
	{

		//Brandes Algorithm 
		LinkedList<Integer> queue = new LinkedList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();

		int noOfVertices = edgeMatrix.length;
		ArrayList<Integer>[] arrayList = (ArrayList<Integer>[]) new ArrayList[noOfVertices];
		float[] betweennessArray = new float[noOfVertices];


		int w=0;
		int v=0;

		for (int s=0; s<noOfVertices;s++) // big for loop
		{
			float[] sigma = new float[noOfVertices];
			int[] d = new int[noOfVertices];
			float[] delta = new float[noOfVertices];
			sigma[s] = 1;
			while (!stack.empty())
			{
				stack.pop();
			}
			for(w=0; w<noOfVertices;w++)
			{
				arrayList[w] = new ArrayList<Integer>(); 
			}
			for (int i=0; i<noOfVertices;i++)
			{
				d[i] =-1;
			}
			d[s]=0; // might need to get rid of
			while (!queue.isEmpty())
			{
				queue.remove();
			}
			queue.add(s);

			while(!queue.isEmpty())
			{
				v = queue.remove();
				stack.push(v);
				for (w=0; w<noOfVertices;w++)
				{
					if (edgeMatrix[v][w]==1)
					{
						if(d[w]<0)
						{
							queue.add(w);
							d[w] = d[v] + 1;
						}

						if(d[w] ==(d[v]+1))
						{
							sigma[w] = sigma[w] + sigma[v];
							arrayList[w].add(v);
						}
					}
				}
			}

			delta = new float[noOfVertices];

			while(!stack.empty())
			{
				w = stack.pop();
				Iterator<Integer> myIterator = arrayList[w].iterator();
				while(myIterator.hasNext())
				{
					v = myIterator.next();
					delta[v] =  delta[v] + (sigma[v]/sigma[w])  * (1+delta[w]);
				}
				if(w != s)
					betweennessArray[w] = betweennessArray[w] + delta[w];
			}
		}
		MyNode[] betweenness= new MyNode[5];
		float largest = betweennessArray[0];
		int largestIndex=0;
		for (int i =0; i<5; i++)
		{
			for (int  j=1; j<betweennessArray.length;j++)
			{
				if(largest<betweennessArray[j])
				{
					largestIndex = j;
					largest=betweennessArray[j];
				}
			}
			betweenness[i] = new MyNode("Betweenness",largest,nodeNumbersUnique.get(largestIndex));
			betweennessArray[largestIndex]=0;
			largest=0;
			largestIndex = 0;	
		}
		return betweenness;
	}
}
