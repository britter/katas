package com.example.goljava;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class GenerationTest {

    private Generation staticGeneration = new Generation(new Cell(0, 0), new Cell(0, 1), 
                                                         new Cell(1, 0), new Cell(1, 1));

    @Test
    public void emptyGeneration_shouldNotEvolve() throws Exception {
        assertEquals(Generation.EMPTY, Generation.EMPTY.nextGeneration());
    }

    @Test
    public void generationWithOneCell_shouldEvolveToEmpty() throws Exception {
        assertEquals(Generation.EMPTY, new Generation(new Cell(0, 0)).nextGeneration());
    }

    @Test
    public void staticGeneration_shouldNotEvolve() throws Exception {
        assertEquals(staticGeneration, staticGeneration.nextGeneration());
    }

    @Test
    public void generationWithThreeCell_shouldEvolveIntoStaticGeneration() throws Exception {
        final Generation evolvingGeneration = new Generation(new Cell(0, 0),
                                                             new Cell(1, 0), new Cell(1, 1));

        assertEquals(staticGeneration, evolvingGeneration.nextGeneration());
    }
}
