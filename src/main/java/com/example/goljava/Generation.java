package com.example.goljava;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class Generation {

    public static final Generation EMPTY = new Generation();

    private final Set<Cell> livingCells = new HashSet<>();
    
    public Generation(final Cell... cells) {
        for (Cell cell : cells) {
            livingCells.add(cell);
        }
    }

    private Generation(Set<Cell> newGeneration) {
        livingCells.addAll(newGeneration);
    }

    public Generation nextGeneration() {
        final Set<Cell> survivors = calculateSurvivors();
        final Set<Cell> willBeBorn = calculateNewBornCells();

        return new Generation(Sets.union(survivors, willBeBorn));
    }

    private Set<Cell> calculateNewBornCells() {
        return livingCells.stream()
                    .flatMap(cell -> cell.getNeighbours().stream())
                    .filter(c -> !livingCells.contains(c))
                    .filter(cell -> livingNeighbours(cell).size() == 3)
                    .collect(Collectors.toSet());
    }

    private Set<Cell> livingNeighbours(final Cell cell) {
        return Sets.intersection(cell.getNeighbours(), livingCells);
    }

    private Set<Cell> calculateSurvivors() {
        return livingCells.stream().filter(cell -> {
                final int livingNeighbourCount = livingNeighbours(cell).size();
                return livingNeighbourCount == 2 || livingNeighbourCount == 3;
            }).collect(Collectors.toSet());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Generation that = (Generation) o;
        return Objects.equals(livingCells, that.livingCells);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livingCells);
    }

    @Override
    public String toString() {
        return "Generation{" +
                "livingCells=" + livingCells +
                '}';
    }
}
