/*
 *  See the file "LICENSE.TXT" for the full license governing this code.
 */

/*
 *  See the file "LICENSE.TXT" for the full license governing this code.
 */

package com.aol.one.patch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.databind.node.TextNode;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ReplaceOperationTest {

  @Test
  public void testCreation() throws PatchException {

    TextNode value = new TextNode("fooValue");
    String path = "/foo/bar/zoo";
    ReplaceOperation op = new ReplaceOperation(path, value);
    Assert.assertEquals(Operation.REPLACE, op.op);

    List<String> pathTokens = op.getPathTokens();
    assertThat(pathTokens.size(), is(3));
    assertThat(pathTokens.get(0), is("foo"));
    assertThat(pathTokens.get(1), is("bar"));
    assertThat(pathTokens.get(2), is("zoo"));

    assertTrue(path.equals(op.getPath()));
    assertTrue(value == op.getValue());
  }


}
