package edu.umb.cs680.hw11;

import java.util.List;

public class Cosine implements DistanceMetric {

    @Override
    public double distance(List<Double> p1, List<Double> p2) {
//  To calculate Cosine Similarity  , cosine Distance = (x,y) = X.Y / ||X|| ||Y|| .
        double dotProduct = 0.0;
//         ||X|| ||Y||
        double normP1 = 0.0;
        double normP2 = 0.0;
        for(int i=0; i < p1.size(); i++) {
            dotProduct += p1.get(i) * p2.get(i);
            normP1 += Math.pow(p1.get(i) ,2);
            normP2 += Math.pow(p2.get(i), 2);
        }
        return dotProduct / (Math.sqrt(normP1) * Math.sqrt(normP2));
    }
}
