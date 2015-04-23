import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



public class TheFunEndsHere {

	public static void main(String[] args) {
		File f =new File("/Users/Cody/downloads/graph.txt");
		
		BufferedReader in = null;
		try{
			in = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(f)));		
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		int c;
		char[] digit = new char[5];
		int digCount = 0;
		int keyVertice = -1;
		int valueVertice = -1;
		int weightValue = -1;
		
		boolean key = true;
		boolean value = false;
		boolean weight = false;
		Vertex v = null;
		Vertex vAdj = null;
		List<Edge> adjacentEdges = new ArrayList<>();
		Boolean [] vertexCover = new Boolean[10648];
		List<Vertex> vertexList = new ArrayList<>();
		
		
		try {
			while ((c = in.read()) != -1){
				char character = (char) c;
				
				if(key){
					
					if(Character.isDigit(character)){
						if(adjacentEdges.size() > 0){
							v.adjacencies = adjacentEdges.toArray(new Edge[adjacentEdges.size()]);
							vertexList.add(v);
							adjacentEdges = new ArrayList<>();
						}
						digit[digCount] = character;
						digCount++;
					}
					else if(character == '['){
						

						if(digCount > 0){
							
							keyVertice = Integer.parseInt(String.valueOf(digit, 0, digCount));
							v = new Vertex(String.valueOf(keyVertice));
							digCount = 0;
						}
						
						key = false;
						value = true;
					}
				}
				else if (value){
					if(Character.isDigit(character)){
						digit[digCount] = character;
						digCount++;
					}
					else if(character == ','){
						valueVertice = Integer.parseInt(String.valueOf(digit, 0 , digCount));
						vAdj = new Vertex(String.valueOf(valueVertice));
						digCount = 0;
						
						value = false;
						weight = true;
					}
				}
				else if(weight){
					if(Character.isDigit(character)){
						digit[digCount] = character;
						digCount++;
					}
					else if(character == ']'){
						weightValue = Integer.parseInt(String.valueOf(digit, 0, digCount));
						 adjacentEdges.add(new Edge(vAdj , weightValue));
						 
						 digCount=0;
						 weight = false;
						 key = true;
						 
//						 System.out.println("Key: "+ keyVertice);
//						 System.out.println("Value: "+ valueVertice);
//						 System.out.println("Weight: "+ weightValue);
						 
						 
					}
				}
//				v.adjacencies = new Edge[adjacentEdges.size()];
//				v.adjacencies = adjacentEdges.toArray(new Edge[adjacentEdges.size()]);
//				System.out.println("Adjacency List for " +v.toString()+" : "+v.adjacencies.toString());
			}
			v.adjacencies = adjacentEdges.toArray(new Edge[adjacentEdges.size()]);
			vertexList.add(v);
			
			
			System.out.println(v.minDistance);
			
			//computePaths(v);
			//System.out.println(v.minDistance);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				double weight = e.weight;
				double distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static class Edge {
		public final Vertex target;
		public final double weight;

		public Edge(Vertex argTarget, double argWeight) {
			target = argTarget;
			weight = argWeight;
		}
		public double getWeight(){
			return weight;
		}
	}

	public static class Vertex implements Comparable<Vertex> {
		public final String name;
		public Edge[] adjacencies;
		public double minDistance = Double.POSITIVE_INFINITY;
		public Vertex previous;

		public Vertex(String argName) {
			name = argName;
		}

		public String toString() {
			return name;
		}

		public int compareTo(Vertex other) {
			return Double.compare(minDistance, other.minDistance);
		}

	}

}
