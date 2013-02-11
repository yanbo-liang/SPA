public class Student {

	private int id;
	private int mark;
	private StudentPreferenceList studentPreferenceList;
	private Project project;
	private int currentPointer = 0;

	public Student(int id, int mark) {
		this.id = id;
		this.mark = mark;
		this.studentPreferenceList = new StudentPreferenceList();
	}

	public int projectRank(Project test) {
		for (int i = 0; i < Data.projectCount; i++) {
			if (test.equals(studentPreferenceList.getStudentPreference(i))) {
				return i;
			}
		}
		return -1;
	}

	public int id() {
		return id;
	}

	public int Mark() {
		return mark;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Project getTopProject() {
		if (currentPointer < Data.projectCount) {
			Project tmp = studentPreferenceList
					.getStudentPreference(currentPointer);
			currentPointer += 1;
			return tmp;
		} else {
			return null;
		}
	}

	public String toString() {
		String tmp = "Student: " + id + " Mark: " + mark + " " + project
				+ " \tPreference: ";
		for (int i = 0; i < Data.projectCount; i++) {
			tmp = tmp + studentPreferenceList.getStudentPreference(i).getID()
					+ " ";
		}
		return tmp;
	}

	public static void main(String[] args) {
		Student a = new Student(1, 1);
		System.out.println(a);

	}
}
