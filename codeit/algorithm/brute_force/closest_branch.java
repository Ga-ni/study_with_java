package codeit.algorithm.brute_force;

import java.util.List;


public class closest_branch {

    public static double distance(List<Integer> b1, List<Integer> b2){
        return Math.sqrt(Math.pow(b1.get(0) - b2.get(0),2)) + Math.sqrt(Math.pow(b1.get(1) - b2.get(1),2));
    }

    public static List<List<Integer>> closest_pair(List<List<Integer>> coordinates){


        int last_idx = coordinates.size() - 1;
        double min_dist = 0;
        List<Integer> closest1 = coordinates.get(0);
        List<Integer> closest2 = coordinates.get(1);


        for (int i = 0; i < last_idx; i++){
            for (int j = i+1; j <= last_idx; j++){
                List<Integer> store1 = coordinates.get(i);
                List<Integer> store2 = coordinates.get(j);

                if (distance(closest1, closest2) > distance(store1, store2)){
                    closest1 = store1;
                    closest2 = store2;
                }

            }
        }
        return List.of(closest1, closest2);
    }

    public static void main(String[] args){
        List<List<Integer>> test_coordinates = List.of(
                List.of(2, 3),
                List.of(12, 30),
                List.of(40, 50),
                List.of(5, 1),
                List.of(12, 10),
                List.of(3, 4)
        );
        List<List<Integer>> result = closest_pair(test_coordinates);
        System.out.println(result);
    }

}
