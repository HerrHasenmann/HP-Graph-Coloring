package io.hasenpower.hpgraphcoloring.algorithm.solving.scoring;

import io.hasenpower.hpgraphcoloring.algorithm.solving.SolvingAlgorithm;
import io.hasenpower.hpgraphcoloring.model.Graph;
import io.hasenpower.hpgraphcoloring.model.Node;
import io.hasenpower.hpgraphcoloring.model.Solution;

import java.util.Comparator;
import java.util.TreeMap;

public class ScoringAlgorithm extends SolvingAlgorithm {

    private Graph graph;
    private Solution solution;
    private TreeMap<Integer, Node> scoreMap;

    public ScoringAlgorithm(Graph graph) {
        super(graph);
        this.graph = graph;
        solution = new Solution(graph);
        scoreMap = calculateScoreMap();

        /**
         * TODO
         * initial scoring
         *
         * get best node -> colorize
         * update scoring
         * repeat till last node is colored
         *
         * solve problem of changing scores -> create Scoring class
         */
    }

    @Override
    public Solution solveGraph() {

        //TODO
        return null;
    }

    private TreeMap<Integer, Node> calculateScoreMap() {
        TreeMap<Integer, Node> scoreMap = new TreeMap<>(Comparator.reverseOrder());
        graph.getNodes().values().forEach(node -> scoreMap.put(calculateScoreOfNode(node), node));

        return scoreMap;
    }

    public int calculateScoreOfNode(Node node) {
        int score = 0;
        int factor = graph.getNodeCount();
        int neighborCount = node.getNeighbors().size();
        int colorizedNeighborsCount = (int) node.getNeighbors().values().stream().filter(solution::isColorized).count();

        score += colorizedNeighborsCount * (factor * factor);
        score += neighborCount * factor;
        score += node.getId();

        return score;
    }
}
