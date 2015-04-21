List<Boolean> markedVertex= new ArrayList<Boolean>();
        List<Integer> vertexList= new ArrayList<Integer>();
        Set<Integer> vertexSet = g.vertexSet();
        for(int i =0; i < vertexSet.size(); i++){
            Boolean e=false;
            markedVertex.add(i,e);
            vertexList.add(i);
        }
        int loopCount = vertexSet.size();
        for(int z = 0; z < loopCount; z++){
            int numEdge = 0;
            int vertex = -1;
            for(int i = 0; i < vertexSet.size(); i++){
                if(!markedVertex.get(i)){
                    Set<DefaultWeightedEdge> edge = g.edgesOf(i);
                    Iterator<DefaultWeightedEdge> edgeItr = edge.iterator();
                    int count = 0;
                    while(edgeItr.hasNext()){
                        DefaultWeightedEdge e = edgeItr.next();
                        double edgeWeight = g.getEdgeWeight(e);
                        if (edgeWeight <= distance){
                            count++;}
                    }
                    if (count >numEdge){
                        numEdge = count;
                        vertex = i;}
                }
            }
            if(vertex!=-1){
                markedVertex.set(vertex,true);
                minCover.add(vertex);
                Set<DefaultWeightedEdge> edge = g.edgesOf(vertex);
                Iterator<DefaultWeightedEdge> edgeItr = edge.iterator();
                loopCount--;
                while(edgeItr.hasNext()){
                    DefaultWeightedEdge e = edgeItr.next();
                    double edgeWeight = g.getEdgeWeight(e);
                    if (edgeWeight <= distance){
                        int source = g.getEdgeSource(e);
                        int target = g.getEdgeTarget(e);
                        markedVertex.set(source, true);
                        markedVertex.set(target, true);
                        loopCount--;
                    }
                }
            }
        }