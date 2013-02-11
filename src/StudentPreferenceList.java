public class StudentPreferenceList {

	private int projectCount;
	private Project[] studentPreferenceList;

	public StudentPreferenceList() {
		this.projectCount = Data.projectCount;
		this.studentPreferenceList = new Project[projectCount];
		RandomGenerator();
	}

	public Project getStudentPreference(int index) {
		return studentPreferenceList[index];
	}

	public void RandomGenerator() {
		int[] random = Data.randomArray(Data.projectCount);
		;
		for (int i = 0; i < projectCount; i++) {
			studentPreferenceList[i] = Model.projectList.getProject(random[i]);
		}
	}

	public int ProjectPosition(Project project) {
		for (int i = 0; i < projectCount; i++) {
			if (studentPreferenceList[i].equals(project))
				return i + 1;
		}
		return -1;
	}

	public String toString() {
		String tmp = "Preference List: \n";
		for (int i = 0; i < projectCount; i++) {
			tmp = tmp + studentPreferenceList[i] + "\n";
		}
		return tmp;
	}

	public static void main(String[] args) {
		StudentPreferenceList a = new StudentPreferenceList();
		System.out.println(a);
	}
}
