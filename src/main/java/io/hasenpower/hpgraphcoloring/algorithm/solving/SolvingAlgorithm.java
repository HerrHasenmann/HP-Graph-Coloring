package io.hasenpower.hpgraphcoloring.algorithm.solving;

import io.hasenpower.hpgraphcoloring.model.Graph;
import io.hasenpower.hpgraphcoloring.model.Solution;

public abstract class SolvingAlgorithm {

    Graph graph;

    public SolvingAlgorithm(Graph graph) {
        this.graph = graph;
    }

    public abstract Solution solveGraph();
}
