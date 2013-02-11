public class ProjectListForEachLecturer {
	private int projectCount;
	private Project[] projectList;

	public ProjectListForEachLecturer(int projectCount) {
		this.projectCount = projectCount;
		this.projectList = new Project[projectCount];
	}

	public int getProjectCount() {
		return projectCount;
	}

	public Project getProject(int index) {
		return projectList[index];
	}

	public void addProject(Project project, int index) {
		projectList[index] = project;
	}

	public String toString() {
		String tmp = "Total: " + projectCount + "\n";
		for (int i = 0; i < projectCount; i++) {
			tmp = tmp + projectList[i] + "\n";
		}
		return tmp;
	}

	public static void main(String[] args) {
		ProjectListForEachLecturer a = new ProjectListForEachLecturer(5);
		System.out.println(a);
	}
}
