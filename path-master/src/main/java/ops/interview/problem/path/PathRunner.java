package ops.interview.problem.path;

public class PathRunner {

	public static void main(String[] args) {
	Path path = new Path("/a/b/c/d");
	
	path.cd("../../x");
	System.out.println(path.getPath());
//	path.cd("openpm/logs");
//	
//System.out.println(path.length());


	}
}


