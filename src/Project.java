public class Project {

	private int id;
	private int type;
	private Lecturer lecturer;
	private Student student;

	public Project(int id) {
		this.id = id;
	}

	public void freeCurrentStudent() {
		student.setProject(null);
	}

	public int studentRank(Student test) {
		int[] projectPreferenceList = ProjectPreferenceList
				.projectPreferenceList(type);
		for (int i = 0; i < 100; i++) {
			if (test.Mark() == projectPreferenceList[i]) {
				return i;
			}
		}
		return -1;
	}

	public boolean newStudensIsPreferred(Student newStudent) {
		int[] projectPreferenceList = ProjectPreferenceList
				.projectPreferenceList(type);
		int newStudentRank = 0;
		int studentRank = 0;
		for (int i = 0; i < 100; i++) {
			if (newStudent.Mark() == projectPreferenceList[i]) {
				newStudentRank = i;
			}
			if (student.Mark() == projectPreferenceList[i]) {
				studentRank = i;
			}
		}
		if (newStudentRank < studentRank) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean checkAvailable() {
		if (student == null && lecturer.getAvailableCount() > 0) {
			return true;
		}
		return false;
	}

	public Boolean checkPartlyAvailable() {
		if (student != null) {
			return true;
		}
		return false;
	}

	public int getID() {
		return id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String toString() {
		String tmp = "(Project: " + id + " Type: " + type + " <" + lecturer
				+ ">)";
		return tmp;
	}

	public static void main(String[] args) {
		Project a = new Project(1);
		System.out.println(a);
	}
}
