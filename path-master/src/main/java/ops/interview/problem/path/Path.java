package ops.interview.problem.path;

/**
 * <p>For this problem, implement the following incomplete class properly. When
 * complete, all unit tests should pass.</p>
 * 
 * <p>Complete the stubbed out cd method. It should provide change directory
 * functionality within the context of this class that represents a path in an
 * abstract file system.</p>
 * 
 * <p>Your implementation should not use any built-in path-related functions.</p>
 * 
 * <p>You should not have to change any of the content in this class except the
 * implementation details of the cd method.</p>
 * 
 * <p>
 * Notes:
 * <ul>
 * <li>Root path is '/'.</li>
 * <li>Path separator is '/'.</li>
 * <li>Parent directory is addressed as "..".</li>
 * </ul>
 * You may assume the following:
 * <ul>
 * <li>The method will be passed relative and absolute paths.</li>
 * <li>The method will NOT be passed any invalid paths.</li>
 * </ul>
 * </p>
 */

public class Path {
	private String path; 


	public Path(String path) {
		this.path = path;

	}

	public String getPath() {
		return path;
	}

	public void cd(String newPath) {	
		
		int lastSlash = path.lastIndexOf("/");
		int secondLastSlash = path.substring(0,lastSlash).lastIndexOf("/");
		
		if (newPath.startsWith("/")) {
			path = newPath;
		}
		else if (newPath.startsWith("../") && !newPath.startsWith("../../")) {
			path = path.substring(0,lastSlash +1) + newPath.substring(3);
		}
		else if (newPath.startsWith("../../") && newPath.length() > 6) {
			path = path.substring(0,secondLastSlash + 1)+ newPath.substring(6);
		}
		else if (newPath.equals("../../")){
			path = path.substring(0, secondLastSlash);
		}
		else {
			path = path + "/" + newPath;
		}
}
}



