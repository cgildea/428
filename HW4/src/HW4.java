import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;


public class HW4 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		BufferedReader brPassTwo = null;

		String pathName = "graph.txt";
		int distance = 1002;
		//int distance = 30;
		int number = 30;
		
		int max = 0;
		int vertexMax = 0;
		SimpleGraph<Integer, DefaultWeightedEdge> g = new SimpleWeightedGraph<Integer, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Set<Integer> minCover = new TreeSet<Integer>();
		
		try{
			
			br = new BufferedReader(new FileReader(pathName));
			String input;
			int vertex = 0;
			while ((input = br.readLine()) != null){				
					g.addVertex(vertex);
					vertex++;			
			}

			
			Set<Integer> vertexList = g.vertexSet();
			
			for(int i = 0; i < vertexList.toArray().length; i++){
				
			}

		}
		finally {
			try {
				if (br != null)
					br.close();} 
			catch (IOException ex) {
				ex.printStackTrace();}
		}//End finally
		System.out.println("done create graph");
	}

}
