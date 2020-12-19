/*
 * Copyright 2015 Benedikt Ritter
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
package de.britter.fizzbuzz;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setUp() throws Exception {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void shouldReturnString1_ForInputInt1() throws Exception {
        assertEquals("1", fizzBuzz.calculateFizzbuzz(1));
    }

    @Test
    public void shouldReturnString2_ForInputInt2() throws Exception {
        assertEquals("2", fizzBuzz.calculateFizzbuzz(2));
        
    }

    @Test
    public void shouldReturnStringFizz_ForInputInt3() throws Exception {
        assertEquals("Fizz", fizzBuzz.calculateFizzbuzz(3));
    }

    @Test
    public void shouldReturnStringFizz_ForInputInt6() throws Exception {
        assertEquals("Fizz", fizzBuzz.calculateFizzbuzz(6));
    }

    @Test
    public void shouldReturnStringBuzz_ForInput5() throws Exception {
        assertEquals("Buzz", fizzBuzz.calculateFizzbuzz(5));
    }

    @Test
    public void shouldReturnStringBuzz_ForInput10() throws Exception {
        assertEquals("Buzz", fizzBuzz.calculateFizzbuzz(10));
    }

    @Test
    public void shouldReturnStringFizzBuzz_ForInput15() throws Exception {
        assertEquals("FizzBuzz", fizzBuzz.calculateFizzbuzz(15));

    }
}
