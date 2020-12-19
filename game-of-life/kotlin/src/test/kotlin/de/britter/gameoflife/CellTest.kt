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

class CellTest {

    @Test
    fun should_calculate_all_neighbours() {
        val actual = Cell(1, 1).neighbours()
        val expected = setOf(
                Cell(0, 0), Cell(1, 0), Cell(2, 0),
                Cell(0, 1),                    Cell(2, 1),
                Cell(0, 2), Cell(1, 2), Cell(2, 2)
        )

        assertEquals(8, actual.size)
        assertEquals(actual, expected)
    }

}
