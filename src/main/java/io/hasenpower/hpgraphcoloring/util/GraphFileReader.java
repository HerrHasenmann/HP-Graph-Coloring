package io.hasenpower.hpgraphcoloring.util;

import io.hasenpower.hpgraphcoloring.model.Graph;
import io.hasenpower.hpgraphcoloring.model.Node;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GraphFileReader {

    private static final Pattern SUMMARY_PATTERN = Pattern.compile("(p)\\s+(edge\\w*)\\s+(\\d+)\\s+(\\d+)");
    private static final Pattern EDGE_LINE_PATTERN = Pattern.compile("(e)\\s+(\\d+)\\s+(\\d+)");

    private File file;
    private Graph graph;

    public GraphFileReader(File file) {
        this.file = file;
        this.graph = new Graph(file.getName());
    }

    public Graph parseGraph() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            bufferedReader
                    .lines()
//                    .parallel()
                    .filter(line ->
                            line.matches(
                                    EDGE_LINE_PATTERN.pattern()) &&
                                    !line.matches(SUMMARY_PATTERN.pattern()))
                    .map(this::parseEdgeLine)
                    .flatMap(Collection::stream)
                    .forEach(graph::addNode);

            return graph;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Node> parseEdgeLine(String line) {
        List<Node> nodes = new ArrayList<>();

        Matcher matcher = EDGE_LINE_PATTERN.matcher(line);
        if (matcher.find()) {
            Node node1 = graph.getOrCreateNode(Integer.parseInt(matcher.group(2)));
            Node node2 = graph.getOrCreateNode(Integer.parseInt(matcher.group(3)));

            node1.addNeigbor(node2);
            node2.addNeigbor(node1);

            nodes.add(node1);
            nodes.add(node2);
        }

        return nodes;
    }
}
