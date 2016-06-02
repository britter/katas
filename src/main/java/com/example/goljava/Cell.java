package com.example.goljava;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cell {

    public final int x;
    public final int y;

    public Cell(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Set<Cell> getNeighbours() {
        Set<Cell> neighbours = new HashSet<>();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                final Cell newCell = new Cell(i, j);
                if(!newCell.equals(this)) {
                    neighbours.add(newCell);
                }
            }
        }
        return neighbours;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
