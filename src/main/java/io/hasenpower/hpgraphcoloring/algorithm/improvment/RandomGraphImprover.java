package io.hasenpower.hpgraphcoloring.algorithm.improvment;

import io.hasenpower.hpgraphcoloring.model.Graph;
import io.hasenpower.hpgraphcoloring.model.Node;
import io.hasenpower.hpgraphcoloring.model.Solution;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGraphImprover extends  ImprovementAlgorithm {

    public RandomGraphImprover(Graph graph, Solution solution) {
        super(graph, solution);
    }

    @Override
    public Solution improveGraph() {

        List<Integer> existingColors = solution.getColors();

        Collections.shuffle(existingColors);

        existingColors.forEach(this::tryToEliminateColor);

        return solution;
    }

    private void tryToEliminateColor(int color) {

        List<Integer> colorsForReplacement = solution
                .getColors()
                .stream()
                .filter(solutionColor -> color != solutionColor)
                .collect(Collectors.toList());

        solution.getNodeColors()
                .entrySet()
                .parallelStream()
                .filter(nodeIdColorEntry -> nodeIdColorEntry.getValue() == color)
                .map(nodeIdColorEntry-> graph.getNode(nodeIdColorEntry.getKey()))
                .parallel()
                .forEach(node -> tryToChangeColorOfNode(node, colorsForReplacement));
    }

    private void tryToChangeColorOfNode(Node node, List<Integer> colorsForReplacement) {
        colorsForReplacement.parallelStream().filter(color -> solution.isColorFeasibleForNode(node, color)).findAny().ifPresent(color -> changeColorOfNode(node, color));
    }

    private void changeColorOfNode(Node node, Integer color) {

        int nodeColorBeforeChange = solution.getColor(node.getId());

        solution.setColor(node, color);

        if(!solution.isFeasible(node)){
            solution.setColor(node, nodeColorBeforeChange);
        }
    }
}
