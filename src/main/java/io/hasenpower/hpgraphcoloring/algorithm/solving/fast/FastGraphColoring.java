package io.hasenpower.hpgraphcoloring.algorithm.solving.fast;

import io.hasenpower.hpgraphcoloring.algorithm.solving.SolvingAlgorithm;
import io.hasenpower.hpgraphcoloring.model.Graph;
import io.hasenpower.hpgraphcoloring.model.Node;
import io.hasenpower.hpgraphcoloring.model.Solution;

import java.util.*;

public class FastGraphColoring extends SolvingAlgorithm {

    private Graph graph;
    private Solution solution;

    public FastGraphColoring(Graph graph) {
        super(graph);
        this.graph = graph;
        solution = new Solution(graph);
    }

    @Override
    public Solution solveGraph() {

        List<Node> nodes = new ArrayList<>(graph.getNodes().values());
        Collections.shuffle(nodes);

        nodes.forEach(this::colorize);

        return solution;
    }

    private void colorize(Node node) {

        List<Integer> existingColors = solution.getColors();

        boolean coloredWithExistingColor = existingColors.stream().anyMatch(color -> {
            solution.setColor(node, color);
            return solution.isFeasible(node);
        });

        if(!coloredWithExistingColor){
            int newColor = existingColors.stream().max(Comparator.naturalOrder()).orElse(0) + 1;
            solution.setColor(node, newColor);
        }

    }


}
