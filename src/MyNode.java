import java.util.ArrayList;


public class MyNode {

	private int edgeCount;
	private int nodeNumber;
	private int currentDistance;
	//private ArrayList<Node> previousNode;
	private int previousNode;
	private float betweenness;
	public MyNode(String type, int a, int b)
	{
		if (type.equals("Degree"))
		{
			edgeCount =  a;
			nodeNumber = b;
		}
		if (type.equals("Betweenness"))
		{
			currentDistance= Integer.MAX_VALUE;
			previousNode = a;
			nodeNumber = b;
		}
	}

	public MyNode(String type, float a, int b)
	{
		if (type.equals("Betweenness"))
		{	
			betweenness = a;
			nodeNumber = b;
		}
	}

	public int getEdgeCount() {
		return edgeCount;
	}

	public void setEdgeCount(int edgeCount) {
		this.edgeCount = edgeCount;
	}

	public int getNodeNumber() {
		return nodeNumber;
	}

	public void setNodeNumber(int nodeNumber) {
		this.nodeNumber = nodeNumber;
	}

	public int getCurrentDistance() {
		return currentDistance;
	}

	public void setCurrentDistance(int currentDistance) {
		this.currentDistance = currentDistance;
	}

	public int getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(int previousNode) {
		this.previousNode = previousNode;
	}

	public float getBetweenness() {
		return betweenness;
	}

	public void setBetweenness(float betweenness) {
		this.betweenness = betweenness;
	}
}
