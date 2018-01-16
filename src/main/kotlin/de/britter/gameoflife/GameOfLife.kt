/*
 * Copyright 2018 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.britter.gameoflife

data class Cell(val x: Int, val y: Int) {
    fun neighbours(): Set<Cell> {
        val neighbours = mutableSetOf<Cell>()
        for (x in this.x - 1..this.x + 1) {
            for (y in this.y - 1..this.y + 1) {
                val neighbour = Cell(x, y)
                if (neighbour != this) {
                    neighbours.add(neighbour)
                }
            }
        }
        return neighbours;
    }
}

fun generationOf() = Generation(setOf())

fun generationOf(vararg cells: Cell) = Generation(cells.toSet())

data class Generation(private val aliveCells: Set<Cell>) {

    private fun livingNeighbours(cell: Cell) = cell.neighbours().intersect(aliveCells)

    private fun willSurvive(): Set<Cell> {
        return aliveCells.filter {
            val livingNeighbourCount = livingNeighbours(it).size
            livingNeighbourCount == 2 || livingNeighbourCount == 3
        }.toSet()
    }

    private fun canBeBorn(): Set<Cell> = aliveCells.flatMap { it.neighbours() }.toSet().minus(aliveCells)

    private fun willBeBorn(): Set<Cell> = canBeBorn().filter { livingNeighbours(it).size == 3 }.toSet()

    fun evolve() = Generation(willSurvive().union(willBeBorn()))

    fun contains(cell: Cell) = aliveCells.contains(cell)
}

