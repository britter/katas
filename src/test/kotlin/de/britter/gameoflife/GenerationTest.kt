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

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GenerationTest {

    val empty = generationOf()

    val static = generationOf(
            Cell(0, 0), Cell(1, 0),
            Cell(0, 1), Cell(1, 1)
    )

    @Test
    fun empty_generation_should_stay_empty() {
        assertEquals(empty, empty.evolve())
    }

    @Test
    fun static_generation_should_stay_the_same() {
        assertEquals(static, static.evolve())
    }

    @Test
    fun single_cell_will_die() {
        assertEquals(empty, generationOf(Cell(1, 1)).evolve())
    }

    @Test
    fun overpopulated_cell_will_die() {
        val theCell = Cell(1, 1)

        assertTrue(!generationOf(
                                  Cell(1, 0),
                Cell(0, 1), theCell, Cell(2, 0),
                                  Cell(1, 2)
        ).evolve().contains(theCell))
    }

    @Test
    fun new_cell_is_born_if_there_are_three_living_neighbours() {
        val theCell = Cell(1, 1)

        val nextGen = generationOf(
                Cell(1, 0),
                Cell(0, 1), Cell(2, 0)
        ).evolve()

        assertTrue(nextGen.contains(theCell), nextGen.toString())
    }
}
