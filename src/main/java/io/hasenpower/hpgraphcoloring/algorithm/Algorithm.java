package io.hasenpower.hpgraphcoloring.algorithm;

import io.hasenpower.hpgraphcoloring.model.Graph;
import io.hasenpower.hpgraphcoloring.model.Solution;

public abstract class Algorithm {

    Graph graph;

    public Algorithm(Graph graph) {
        this.graph = graph;
    }

    public abstract Solution solveGraph();
}
