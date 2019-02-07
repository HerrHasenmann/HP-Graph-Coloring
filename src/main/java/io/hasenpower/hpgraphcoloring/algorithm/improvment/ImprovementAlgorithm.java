package io.hasenpower.hpgraphcoloring.algorithm.improvment;

import io.hasenpower.hpgraphcoloring.model.Graph;
import io.hasenpower.hpgraphcoloring.model.Solution;

public abstract class ImprovementAlgorithm {

    Graph graph;
    Solution solution;

    public ImprovementAlgorithm(Graph graph, Solution solution) {
        this.graph = graph;
        this.solution = solution;
    }

    public abstract Solution improveGraph();
}
