package graph.traverse;

import java.util.*;

// 399. Evaluate Division
public class Solution399 {
    private double path = 1;
    private boolean resGot = false;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Object[]>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> pair = equations.get(i);
            double value = values[i];
            String from = pair.get(0);
            String to = pair.get(1);

            List<Object[]> list1 = graph.get(from);
            if(list1 == null){
                list1 = new ArrayList<>();
                graph.put(from, list1);
            }
            list1.add(new Object[]{to, value});

            List<Object[]> list2 = graph.get(to);
            if(list2 == null){
                list2 = new ArrayList<>();
                graph.put(to, list2);
            }
            list2.add(new Object[]{from, 1 / value});
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String first = query.get(0);
            String second = query.get(1);

            path = 1;
            resGot = false;

            if(graph.containsKey(first)) {
                if(first.equals(second)){
                    res[i] = 1;
                } else {
                    Set<String> visited = new HashSet<>();
                    visited.add(first);
                    dfs(first, second, graph, visited);
                    if(resGot){
                        res[i] = path;
                    } else {
                        res[i] = -1;
                    }
                }
            } else {
                res[i] = -1;
            }
        }

        return res;
    }

    private void dfs(String node, String dest, Map<String, List<Object[]>> graph, Set<String> visited) {
        List<Object[]> children = graph.get(node);
        for(Object[] child : children){
            String nextNode = (String)child[0];
            if(visited.contains(nextNode)){
                continue;
            }

            double value = (Double)child[1];
            path *= value;
            visited.add(nextNode);

            if(nextNode.equals(dest)) {
                resGot = true;
                return;
            } else {
                dfs(nextNode, dest, graph, visited);
                if(resGot){
                    return;
                }
            }

            path /= value;
            visited.remove(nextNode);
        }
    }
}


class Solution399_attempt_rupanduan {
    private double path = 1;
    private boolean resGot = false;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Object[]>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> pair = equations.get(i);
            double value = values[i];
            String from = pair.get(0);
            String to = pair.get(1);

            List<Object[]> list1 = graph.get(from);
            if(list1 == null){
                list1 = new ArrayList<>();
                graph.put(from, list1);
            }
            list1.add(new Object[]{to, value});

            List<Object[]> list2 = graph.get(to);
            if(list2 == null){
                list2 = new ArrayList<>();
                graph.put(to, list2);
            }
            list2.add(new Object[]{from, 1 / value});
        }

        double[] res = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String first = query.get(0);
            String second = query.get(1);

            path = 1;
            resGot = false;

            if(graph.containsKey(first)) {
                if(first.equals(second)){
                    res[i] = 1;
                } else {
                    Set<String> visited = new HashSet<>();
                    dfs(first, second, graph, visited);
                    if(resGot){
                        res[i] = path;
                    } else {
                        res[i] = -1;
                    }
                }
            } else {
                res[i] = -1;
            }
        }

        return res;
    }

    private void dfs(String node, String dest, Map<String, List<Object[]>> graph, Set<String> visited) {
        if(visited.contains(node)){
            return;
        }
        if(node.equals(dest)){
            resGot = true;
            return;
        }
        visited.add(node);

        List<Object[]> children = graph.get(node);
        for(Object[] child : children){
            String nextNode = (String)child[0];
            double value = (Double)child[1];
            path *= value;

            dfs(nextNode, dest, graph, visited);
            if(resGot){
                return;
            }
            path /= value;
        }
    }
}
