package ops.interview.test.path;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ops.interview.problem.path.Path;

public class TestPath {
	Path path;

	@Before
	public void setUp() {
		path = new Path("/a/b/c/d");   //original
	}
	
	@Test
	public void testRootDirectoryAbsolutePath() {   //case 1
		path.cd("/d/c/b/a/x");
		assertEquals("/d/c/b/a/x", path.getPath());
	}
	
	@Test
	public void testChildDirectoryRelativePath() {   //case 2
		path.cd("x");
		assertEquals("/a/b/c/d/x", path.getPath());
	}

	@Test
	public void testParentDirectoryOnce() {            //case 3
		path.cd("../x");
		assertEquals("/a/b/c/x", path.getPath());
	}
	
	@Test
	public void testParentDirectoryTwice() {         //case 4
		path.cd("../../x");
		assertEquals("/a/b/x", path.getPath());
	}
	
	@Test 
	public void testComplexPath() {                //case 5
		path.cd("../../");
		assertEquals("/a/b", path.getPath());
		path.cd("openpm/logs");
		assertEquals("/a/b/openpm/logs", path.getPath());
	}
	
	
}
