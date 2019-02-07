package io.hasenpower.hpgraphcoloring.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    /* key: nodeId, value: color */
    private HashMap<Integer, Integer> nodeColors;
    private Graph graph;

    public Solution(Graph graph) {
        this.nodeColors = new HashMap<>();
        this.graph = graph;
    }

    public void setColor(int nodeId, int color) {
        nodeColors.put(nodeId, color);
    }

    public void setColor(Node node, int color) {
        nodeColors.put(node.getId(), color);
    }

    public int getColor(int nodeId) {
        if(nodeColors.get(nodeId) == null) {
            return -1;
        } else {
            return nodeColors.get(nodeId);
        }
    }

    private int getColor(Node node) {
        return getColor(node.getId());
    }

    public List<Integer> getColors() {
        return new ArrayList<>(nodeColors.values());
    }

    /**
     * Filter all nodes and return only the nodes with the specified color.
     *
     * @param color represented by an Integer
     * @return List od nodes with specified color
     */
    public List<Node> getNodesWithColor(int color) {
        return nodeColors
                .entrySet()
                .stream()
                .filter(nodeColorEntry -> nodeColorEntry.getValue() == color)
                .map(Map.Entry::getKey)
                .map(graph::getNode)
                .collect(Collectors.toList());
    }


    public HashMap<Integer, Integer> getNodeColors() {
        return nodeColors;
    }

    public void setNodeColors(HashMap<Integer, Integer> nodeColors) {
        this.nodeColors = nodeColors;
    }

    public boolean isFeasible() {

        return graph.getNodes().values().stream().allMatch(this::isFeasible);
    }

    public boolean isFeasible(Node node) {
        return node.getNeighbors().values().stream().noneMatch(neighborNode -> getColor(neighborNode) == getColor(node));
    }

    public boolean isColorFeasibleForNode(Node node, int color) {
        return node.getNeighbors().values().stream().noneMatch(neighborNode -> getColor(neighborNode) == color);
    }

    public long getCromaticNumber() {
        return nodeColors.values().stream().distinct().count();
    }

    public Graph getGraph() {
        return graph;
    }


    @Override
    public String toString() {
        return "Solution{" +
                "nodeColors=" + nodeColors +
                ", graph=" + graph +
                '}';
    }

    public boolean isColorized(Node node) {
        return nodeColors.containsKey(node.getId());
    }
}
