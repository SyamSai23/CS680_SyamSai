package edu.umb.cs680.hw11;

import java.util.List;

public class Manhattan implements DistanceMetric {

    @Override
    public double distance(List<Double> p1, List<Double> p2) {

		double sumOfPOintsDiff = 0.0;
		for(int i=0; i < p1.size(); i++) {
			sumOfPOintsDiff += Math.abs(p1.get(i)-p2.get(i));
		}
		return sumOfPOintsDiff;
    }
	public static void main(String[] args){
		List<Double> p1,p2;
		p1= List.of(2.0,3.0,5.0);
		p2 = List.of(5.0, 7.0,3.0);
		System.out.println(Distance.get(p1,p2));
		System.out.println(Distance.get(p1,p2, new Manhattan()));
//		System.out.println(Distance.get(p1,p2, new Euclidean()));
//		System.out.println(Distance.get(p1,p2, new Cosine()));
//		List<Double> p1,p2,p3;
//		p1 = List.of(0.0, 0.0, 0.08333333333333333);
//		p2  = List.of(0.4, 1.0, 0.0);
//		p3 = List.of(1.0, 0.35294117647058826, 1.0);
//		System.out.println(Distance.get(p1,p3, new Euclidean()));

	}
}



