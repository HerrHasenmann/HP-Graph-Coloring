package io.hasenpower.hpgraphcoloring.util;

import io.hasenpower.hpgraphcoloring.model.Solution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrettyPrinter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrettyPrinter.class);

    public static void print(Solution solution) {
        LOGGER.info(solution.getGraph().toSummaryString());
        LOGGER.info("Chromatic Number: " + solution.getCromaticNumber());
        LOGGER.info("Is feasible: " + solution.isFeasible());
    }
}
