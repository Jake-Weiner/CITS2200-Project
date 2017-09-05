import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class centralityTest {

	public static void main (String args[]) 
	{
		//------------------------BEGIN READING FILE 428333-----------------------------
		String fileName428333 = "428333.edges.txt";     //Name of the file
		ArrayList<Integer> nodeNumbersUnique428333 = new ArrayList<Integer>(); //  
		HashMap<Integer,Integer> nodeNumbersHashMap428333 = new HashMap<Integer,Integer>(); // hashmap to store node numbers in the order that they are read in
		int nodeNumberValueInHash=0;
		try{
			//Create object of FileReader
			FileReader inputFile428333 = new FileReader(fileName428333);

			//Instantiate the BufferedReader Class
			BufferedReader bufferReader428333 = new BufferedReader(inputFile428333);

			//Variable to hold the one line data
			String line428333;
			Integer startNode;
			Integer endNode;
			String[] bothNodes;

			// Read file line by line and print on the console
			while ((line428333 = bufferReader428333.readLine()) != null)   
			{
				bothNodes = line428333.split(" ");
				startNode=Integer.parseInt(bothNodes[0]);
				endNode=Integer.parseInt(bothNodes[1]);
				if(!nodeNumbersUnique428333.contains(startNode))
				{
					nodeNumbersUnique428333.add(startNode);
					nodeNumbersHashMap428333.put(startNode, nodeNumberValueInHash);
					nodeNumberValueInHash++;
				}

				if(!nodeNumbersUnique428333.contains(endNode))
				{
					nodeNumbersUnique428333.add(endNode); 
					nodeNumbersHashMap428333.put(endNode, nodeNumberValueInHash);
					nodeNumberValueInHash++;
				}
			}
			//Close the buffer reader
			bufferReader428333.close();
		}
		catch(Exception e)
		{
			System.out.println("Error while reading file line by line:" + e.getMessage());                      
		}

		// AT THIS STAGE ALL NODENUMBERS ARE NOW STORED IN THE HASHMAP WITH A VALUE OF THE ORDER THAT THEY ARE READ IN

		//------------------ THE ADJACENCY MATRIX IS NOW CREATED------------------------------
		int noOfNodes428333=nodeNumbersUnique428333.size();
		int[][] edgeMatrix428333 = new int[noOfNodes428333][noOfNodes428333];

		try{
			//Create object of FileReader
			FileReader inputFile428333 = new FileReader(fileName428333);

			//Instantiate the BufferedReader Class
			BufferedReader bufferReader = new BufferedReader(inputFile428333);

			//Variable to hold the one line data
			String line;
			Integer startNode;
			Integer endNode;
			String[] bothNodes;
			// Read file line by line and print on the console
			while ((line = bufferReader.readLine()) != null)   
			{
				bothNodes = line.split(" ");
				startNode=Integer.parseInt(bothNodes[0]);
				endNode=Integer.parseInt(bothNodes[1]);
				edgeMatrix428333[nodeNumbersHashMap428333.get(startNode)][nodeNumbersHashMap428333.get(endNode)]=1;
			}
			//Close the buffer reader
			bufferReader.close();
		}catch(Exception e){
			System.out.println("Error while reading file line by line:" + e.getMessage());                      
		}

		// -----------MAKE THE ADJACENCY MATRIX UNDIRECTED---------------------------- -
		for (int row=0; row<noOfNodes428333;row++)
		{
			for (int col =0; col<noOfNodes428333 ;col++)
			{
				if (edgeMatrix428333[row][col] == 0 && edgeMatrix428333[col][row]==1)
					edgeMatrix428333[row][col] = 1;
				//System.out.print(edgeMatrix[row][col]);
			}
			//	System.out.println();
		}

		//------------------------BEGIN READING FILE 78813-----------------------------

		String fileName78813="78813.edges.txt";     //Name of the file
		ArrayList<Integer> nodeNumbersUnique78813 = new ArrayList<Integer>(); //  
		HashMap<Integer,Integer> nodeNumbersHashMap78813 = new HashMap<Integer,Integer>(); // hashmap to store node numbers in the order that they are read in
		int nodeNumberValueInHash78813=0;
		try{
			//Create object of FileReader
			FileReader inputFile78813 = new FileReader(fileName78813);

			//Instantiate the BufferedReader Class
			BufferedReader bufferReader78813 = new BufferedReader(inputFile78813);

			//Variable to hold the one line data
			String line78813;
			Integer startNode;
			Integer endNode;
			String[] bothNodes;

			// Read file line by line and print on the console
			while ((line78813 = bufferReader78813.readLine()) != null)   
			{
				bothNodes = line78813.split(" ");
				startNode=Integer.parseInt(bothNodes[0]);
				endNode=Integer.parseInt(bothNodes[1]);
				if(!nodeNumbersUnique78813.contains(startNode))
				{
					nodeNumbersUnique78813.add(startNode);
					nodeNumbersHashMap78813.put(startNode, nodeNumberValueInHash78813);
					nodeNumberValueInHash78813++;
				}

				if(!nodeNumbersUnique78813.contains(endNode))
				{
					nodeNumbersUnique78813.add(endNode); 
					nodeNumbersHashMap78813.put(endNode, nodeNumberValueInHash78813);
					nodeNumberValueInHash78813++;
				}
			}
			//Close the buffer reader
			bufferReader78813.close();
		}
		catch(Exception e)
		{
			System.out.println("Error while reading file line by line:" + e.getMessage());                      
		}

		// AT THIS STAGE ALL NODENUMBERS ARE NOW STORED IN THE HASHMAP WITH A VALUE OF THE ORDER THAT THEY ARE READ IN

		//------------------ THE ADJACENCY MATRIX IS NOW CREATED------------------------------
		int noOfNodes78133=nodeNumbersUnique78813.size();
		int[][] edgeMatrix78813 = new int[noOfNodes78133][noOfNodes78133];

		try{
			//Create object of FileReader
			FileReader inputFile = new FileReader(fileName78813);

			//Instantiate the BufferedReader Class
			BufferedReader bufferReader = new BufferedReader(inputFile);

			//Variable to hold the one line data
			String line;
			Integer startNode;
			Integer endNode;
			String[] bothNodes;
			// Read file line by line and print on the console
			while ((line = bufferReader.readLine()) != null)   
			{
				bothNodes = line.split(" ");
				startNode=Integer.parseInt(bothNodes[0]);
				endNode=Integer.parseInt(bothNodes[1]);
				edgeMatrix78813[nodeNumbersHashMap78813.get(startNode)][nodeNumbersHashMap78813.get(endNode)]=1;
			}
			//Close the buffer reader
			bufferReader.close();
		}catch(Exception e){
			System.out.println("Error while reading file line by line:" + e.getMessage());                      
		}

		// -----------MAKE THE ADJACENCY MATRIX UNDIRECTED---------------------------- -
		for (int row=0; row<noOfNodes78133;row++)
		{
			for (int col =0; col<noOfNodes78133 ;col++)
			{
				if (edgeMatrix78813[row][col] == 0 && edgeMatrix78813[col][row]==1)
					edgeMatrix78813[row][col] = 1;
				//System.out.print(edgeMatrix78813[row][col]);
			}
			//System.out.println();
		}

		//--------------------- RUNNING THE 4 MEASURES OF CENTRALITY------------------

		long startTime1 = System.currentTimeMillis(); // Start Timing
		MyNode[] topFiveDegree428333 = Centrality.centralityLatest(edgeMatrix428333,nodeNumbersUnique428333);

		System.out.println("DEGREE CENTRALILTY - 428333.txt");

		for (int i=0; i<topFiveDegree428333.length;i++)
		{
			System.out.println(i+1 + " Node Number " + topFiveDegree428333[i].getNodeNumber() + " | Degree Centrality " + topFiveDegree428333[i].getEdgeCount());
		}

		long endTime1   = System.currentTimeMillis();
		long totalTime1 = endTime1 - startTime1;
		System.out.println("run time is " +totalTime1 + " ms");
		
		System.out.println();
		
		double[][] closeness = null;
		long startTime5 = System.currentTimeMillis(); // Start Timing
		try {
			
			closeness = Methods.closenessCentrality(edgeMatrix428333, nodeNumbersUnique428333);
			
		}
		catch(Exception e) {
			System.out.println("exception thrown");
		}
		long endTime5   = System.currentTimeMillis();
		

		System.out.println("CLOSENESS CENTRALILTY - 428333.txt");

		for (int i=0; i<topFiveDegree428333.length;i++)
		{
			System.out.println(i+1 + " Node Number " + (int) closeness[0][i] + " | Closeness Centrality " + closeness[1][i]);
		}

		long totalTime5 = endTime5 - startTime5;
		System.out.println("run time is " +totalTime5 + " ms");


		System.out.println();

		long startTime2 = System.currentTimeMillis(); // Start Timing
		MyNode[] topFiveBetweenness428333 = Centrality.betweennessBrandes(edgeMatrix428333,nodeNumbersUnique428333);

		System.out.println("BETWEENNESS CENTRALITY - 428333.txt");

		for(int i=0; i<topFiveBetweenness428333.length;i++)
		{
			System.out.println(i+1 +" Node Number "+ topFiveBetweenness428333[i].getNodeNumber() + " | Betweenness Centrality "+ topFiveBetweenness428333[i].getBetweenness());
		}

		long endTime2   = System.currentTimeMillis();
		long totalTime2 = endTime2 - startTime2;
		System.out.println("run time is " +totalTime2 + " ms");


		System.out.println();
		
		double[][] katz = null;
		long startTime6 = System.currentTimeMillis(); // Start Timing
		try {
			
			katz = Methods.katzCentrality(edgeMatrix428333, nodeNumbersUnique428333);
			
		}
		catch(Exception e) {
			System.out.println("exception thrown");
		}
		long endTime6   = System.currentTimeMillis();
		

		System.out.println("KATZ CENTRALILTY - 428333.txt");

		for (int i=0; i<topFiveDegree428333.length;i++)
		{
			System.out.println(i+1 + " Node Number " + (int) katz[0][i] + " | Closeness Centrality " + katz[1][i]);
		}

		long totalTime6 = endTime6 - startTime6;
		System.out.println("run time is " +totalTime6 + " ms");


		System.out.println();

		long startTime3 = System.currentTimeMillis(); // Start Timing

		MyNode[] topFiveDegree78133 = Centrality.centralityLatest(edgeMatrix78813,nodeNumbersUnique78813);

		System.out.println("DEGREE CENTRALILTY - 788133.txt");


		for (int i=0; i<topFiveDegree78133.length;i++)
		{
			System.out.println(i+1 + " Node Number " + topFiveDegree78133[i].getNodeNumber() + " | Degree Centrality " + topFiveDegree78133[i].getEdgeCount());
		}

		long endTime3   = System.currentTimeMillis();
		long totalTime3 = endTime3 - startTime3;
		System.out.println("run time is " +totalTime3 + " ms");

		System.out.println();
		
		double[][] closeness1 = null;
		long startTime7 = System.currentTimeMillis(); // Start Timing
		try {
			
			closeness1 = Methods.closenessCentrality(edgeMatrix78813,nodeNumbersUnique78813);
			
		}
		catch(Exception e) {
			System.out.println("exception thrown");
		}
		long endTime7   = System.currentTimeMillis();
		

		System.out.println("CLOSENESS CENTRALILTY - 428333.txt");

		for (int i=0; i<topFiveDegree428333.length;i++)
		{
			System.out.println(i+1 + " Node Number " + (int) closeness1[0][i] + " | Closeness Centrality " + closeness1[1][i]);
		}

		long totalTime7 = endTime7 - startTime7;
		System.out.println("run time is " + totalTime7 + " ms");


		System.out.println();

		long startTime4 = System.currentTimeMillis(); // Start Timing

		MyNode[] topFiveBetweenness78813 = Centrality.betweennessBrandes(edgeMatrix78813,nodeNumbersUnique78813);

		System.out.println("BETWEENNESS CENTRALITY - 78813.txt");

		for(int i=0; i<topFiveBetweenness78813.length;i++)
		{
			System.out.println(i+1 +" Node Number "+ topFiveBetweenness78813[i].getNodeNumber() + " | Betweenness Centrality "+ topFiveBetweenness78813[i].getBetweenness());
		}

		long endTime4   = System.currentTimeMillis();
		long totalTime4 = endTime4 - startTime4;
		System.out.println("run time is " +totalTime4 + " ms");
		
		System.out.println();
		
		double[][] katz1 = null;
		long startTime8 = System.currentTimeMillis(); // Start Timing
		try {
			
			katz1 = Methods.katzCentrality(edgeMatrix78813,nodeNumbersUnique78813);
			
		}
		catch(Exception e) {
			System.out.println("exception thrown");
		}
		long endTime8   = System.currentTimeMillis();
		

		System.out.println("KATZ CENTRALILTY - 428333.txt");

		for (int i=0; i<topFiveDegree428333.length;i++)
		{
			System.out.println(i+1 + " Node Number " + (int) katz1[0][i] + " | Closeness Centrality " + katz1[1][i]);
		}

		long totalTime8 = endTime8 - startTime8;
		System.out.println("run time is " +totalTime8 + " ms");


		System.out.println();

	}

}
