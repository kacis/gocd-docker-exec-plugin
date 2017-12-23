package io.bitgrillr.godockerbuildplugin;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import io.bitgrillr.godockerbuildplugin.utils.GoTestUtils;
import org.junit.Test;

public class IntegrationTest {

  @Test
  public void build() throws Exception {
    final int counter = GoTestUtils.runPipeline("test");
    GoTestUtils.waitForPipeline("test", counter);
    final String result = GoTestUtils.getPipelineResult("test", counter);
    assertEquals("Expected success", "Passed", result);
    final String log = GoTestUtils.getPipelineLog("test", 1, "test", "test");
    assertThat("Missing message", log, containsString("Hello World!"));
  }

}
