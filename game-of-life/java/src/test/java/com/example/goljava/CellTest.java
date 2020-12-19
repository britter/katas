package com.example.goljava;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.Test;

public class CellTest {

    @Test
    public void shouldCalculateNeighbours() throws Exception {
        Cell center = new Cell(1, 1);

        final Set<Cell> neighbours = center.getNeighbours();
        assertThat(neighbours, hasItems(
                new Cell(0,0), new Cell(0,1), new Cell(0,2),
                new Cell(1,0),                new Cell(1,2),
                new Cell(2,0), new Cell(2,1), new Cell(2,2)
        ));

        assertThat(neighbours, not(hasItem(center)));
    }
}