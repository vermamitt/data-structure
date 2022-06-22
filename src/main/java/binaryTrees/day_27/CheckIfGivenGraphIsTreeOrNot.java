package binaryTrees.day_27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfGivenGraphIsTreeOrNot {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(Arrays.asList(1));
        graph.add(Arrays.asList(2, 3));
        graph.add(Arrays.asList(1, 4));
        graph.add(Arrays.asList(2, 3));
        graph.add(Arrays.asList(1, 4));
        boolean isTree = isTree(graph, 5);
        System.out.println("isTree = " + isTree);
        List<List<Integer>> graph1 = new ArrayList<>();
        graph1.add(Arrays.asList(1, 2));
        graph1.add(Arrays.asList(0));
        graph1.add(Arrays.asList(0));
        System.out.println("isTree = " + isTree(graph1, 3));
    }

    private static boolean isTree(List<List<Integer>> graph, int size) {
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            visited.add(false);
        }
        boolean isCyclic = isCyclic(0, -1, graph, visited);
        if (isCyclic) return false;
        for (boolean e : visited) {
            if (!e) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCyclic(int start, int parent, List<List<Integer>> graph, List<Boolean> visited) {
        if (!visited.get(start)) {
            visited.set(start, true);
        }
        for (int e : graph.get(start)) {
            if (!visited.get(e)) {
                if (isCyclic(e, start, graph, visited)) {
                    return true;
                }
            } else if (e != parent) {
                return true;
            }
        }
        return false;
    }
}
