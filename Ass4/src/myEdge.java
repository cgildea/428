

public class myEdge{
	double weight;
	int source;
	int target;
	
	public myEdge(int a, int b, double c){
		source = a;
		target = b;
		weight = c;
	}

//	@Override
//	public int compareTo(Object arg0) {
//		myEdge edge1 = (myEdge)arg0;
//		if(this.weight<edge1.weight) return -1;
//		else if(this.equals(edge1)) return 0;
//		else return 1;
//		
//	}
//	@Override
//	public boolean equals(Object arg0){
//		myEdge edge1 = (myEdge)arg0;
//		return(this.weight==edge1.weight&&this.target==edge1.target&&this.source==edge1.source);
//	}
	
}
