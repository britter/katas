package de.codecentric.diamondkata;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class DiamondTest {

  @Property
  public void oddNumberOfRows(@InRange(minChar = 'a', maxChar = 'z') char buchstabe) {
    assertTrue(String.valueOf(buchstabe), diamond(buchstabe).size() % 2 == 1);
  }

  @Property
  public void oddNumberOfColumns(@InRange(minChar = 'a', maxChar = 'z') char buchstabe) {
    assertTrue(String.valueOf(buchstabe), diamond(buchstabe).get(0).length() % 2 == 1);
  }

  @Property
  public void numberOfRowsDerivedFromCharacterIndex(@InRange(minChar = 'a', maxChar = 'z') char buchstabe) {
    assertEquals(2 * index(buchstabe) + 1, diamond(buchstabe).size());
  }

  @Property
  public void numberOfColumnsDerivedFromCharacterIndex(@InRange(minChar = 'a', maxChar = 'z') char buchstabe) {
    assertEquals(2 * index(buchstabe) + 1, diamond(buchstabe).get(0).length());
  }

  private List<String> diamond(char buchstabe) {
    return charactersPerLine(buchstabe).stream()
                                       .map(s -> nTimes(charactersPerLine(buchstabe).size(), s))
                                       .collect(toList());
  }

  private List<String> charactersPerLine(char buchstabe) {
    List<String> result = new ArrayList<String>();
    for (char c = 'a' ; c <= buchstabe; c++) {
      result.add(String.valueOf(c));
    }
    for (char c = (char) (buchstabe - 1); c >= 'a'; c--) {
      result.add(String.valueOf(c));
    }
    return result;
  }

  private String nTimes(int n, String s) {
    return range(0, n)
            .mapToObj(i -> s)
            .collect(joining());
  }

  private int index(char buchstabe) {
    return buchstabe - 'a';
  }

}
