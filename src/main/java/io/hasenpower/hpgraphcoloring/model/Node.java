package io.hasenpower.hpgraphcoloring.model;

import java.util.HashMap;

public class Node {

    private int id;

    /* key: nodeId, value: Node */
    private HashMap<Integer, Node> neighbors;

    public Node(int id) {
        this.id = id;
        this.neighbors = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method for adding neighbor references. Multiple adding does not effect the number of neighbors and will be ignored
     *
     * @param node Neighbor of node, connected over an edge.
     */
    public void addNeigbor(Node node) {
        if(!neighbors.containsKey(node.getId())){
            neighbors.put(node.getId(), node);
        }
    }

    public HashMap<Integer, Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(HashMap<Integer, Node> neighbors) {
        this.neighbors = neighbors;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                '}';
    }
}
