public class ProjectList {
	private int projectCount;
	private Project[] projectList;
	private int[] projectTypeCount;

	public ProjectList() {
		this.projectCount = Data.projectCount;
		this.projectList = new Project[projectCount];
		this.projectTypeCount = Data.projectTypeCount;
		for (int i = 0; i < projectCount; i++) {
			projectList[i] = new Project(i + 1);
		}
		generateProjectType();
	}

	public Project getProject(int index) {
		return projectList[index];
	}

	private void generateProjectType() {
		for (int i = 0; i < projectTypeCount[0]; i++) {
			projectList[i].setType(1);
		}
		for (int i = projectTypeCount[0]; i < projectTypeCount[0]
				+ projectTypeCount[1]; i++) {
			projectList[i].setType(2);
		}
		for (int i = projectTypeCount[0] + projectTypeCount[1]; i < projectCount; i++) {
			projectList[i].setType(3);
		}
	}

	public String toString() {
		String tmp = "";
		for (int i = 0; i < projectCount; i++) {
			tmp = tmp + projectList[i] + "\n";
		}
		return tmp;
	}
	public static void main(String[] args) {
		ProjectList a = new ProjectList();
		System.out.println(a);
	}
}