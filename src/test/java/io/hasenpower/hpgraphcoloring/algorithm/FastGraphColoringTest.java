package io.hasenpower.hpgraphcoloring.algorithm;

import io.hasenpower.hpgraphcoloring.model.Graph;
import io.hasenpower.hpgraphcoloring.model.Solution;
import io.hasenpower.hpgraphcoloring.util.GraphFileReader;
import io.hasenpower.hpgraphcoloring.util.PrettyPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

class FastGraphColoringTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FastGraphColoringTest.class);
    private Graph graph;

    @BeforeEach
    void setUp() {
        File file = new File("graph-files/r1000.1c.col");
//        File file = new File("graph-files/1-FullIns_3.col");
//        File file = new File("graph-files/1-FullIns_4.col");
        GraphFileReader graphFileReader = new GraphFileReader(file);
        graph = graphFileReader.parseGraph();
    }

    @Test
    void solveGraph() {
        FastGraphColoring fastGraphColoring = new FastGraphColoring(graph);
        Solution solution = fastGraphColoring.solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);

        solution = new FastGraphColoring(graph).solveGraph();
        PrettyPrinter.print(solution);
    }
}