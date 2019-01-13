package io.hasenpower.hpgraphcoloring.util;

import io.hasenpower.hpgraphcoloring.model.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GraphFileReaderTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(GraphFileReaderTest.class);
    private List<File> files;

    @BeforeEach
    void setUp() {
        files = new ArrayList<>();
        files.add(new File("graph-files/1-FullIns_3.col"));
        files.add(new File("graph-files/1-Insertions_4.col"));
        files.add(new File("graph-files/DSJC1000.9.col"));
        files.add(new File("graph-files/flat1000_50_0.col"));
    }

    @Test
    void parseGraph() {

        List<Graph> graphList = files.stream().map(file -> {
            GraphFileReader graphFileReader = new GraphFileReader(file);
            return graphFileReader.parseGraph();
        }).collect(Collectors.toList());

        graphList.forEach(graph -> {

            LOGGER.info(graph.toSummaryString());

            assertTrue(graph.getNodeCount() > 0);
        });
    }
}