package io.hasenpower.hpgraphcoloring.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Graph {

    private String filename;

    /* key: nodeId, value: Node */
    private ConcurrentHashMap<Integer, Node> nodes;

    public Graph() {
        this("unknown");
    }

    public Graph(String filename) {
        this.filename = filename;
        this.nodes = new ConcurrentHashMap<>();
    }

    public Node getNode(int nodeId) {
        return nodes.get(nodeId);
    }

    /**
     * Makes a lookup if the node already exists in the graph, if yes then returns it, else a new {@link Node} will be
     * created. The newly created {@link Node} is not added automatically to the graph.
     *
     * @param nodeId Id of node.
     * @return Node of {@link Graph} or creates a new one.
     */
    public Node getOrCreateNode(int nodeId) {
        if(nodes.containsKey(nodeId)){
            return nodes.get(nodeId);
        }else {
            return new Node(nodeId);
        }
    }

    /**
     * Adds a node which was not already added to the {@link Graph}
     *
     * @param node That should be added.
     */
    public void addNode(Node node) {
        if(!nodes.containsKey(node.getId())) {
            nodes.put(node.getId(), node);
        }
    }

    public int getNodeCount() {
        return nodes.size();
    }

    public ConcurrentHashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public void setNodes(ConcurrentHashMap<Integer, Node> nodes) {
        this.nodes = nodes;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "filename='" + filename + '\'' +
                ", nodes=" + nodes +
                '}';
    }

    /**
     * @return Similar to toString but shows number of nodes instead of all nodes as list.
     */
    public String toSummaryString() {
        return "Graph{" +
                "filename='" + filename + '\'' +
                ", nodeCount=" + getNodeCount() +
                '}';
    }
}
