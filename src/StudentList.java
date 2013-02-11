public class StudentList {

	private int studentCount;
	private Student[] studentList;
	private int[] markList = new Mark(90, 30, 60).getMarkList();
	private Student freeStudent;

	public StudentList() {
		this.studentCount = Data.studentCount;
		this.studentList = new Student[studentCount];
		for (int i = 0; i < studentCount; i++) {
			studentList[i] = new Student(i + 1, markList[i]);
		}
	}

	public Student getStudent(int index) {
		return studentList[index];
	}

	public boolean checkFreeStudent() {
		for (int i = 0; i < studentCount; i++) {
			if (studentList[i].getProject() == null) {
				freeStudent = studentList[i];
				return true;
			}
		}
		return false;
	}

	public Student getFreeStudent() {
		return freeStudent;
	}

	public String toString() {
		String tmp = "";
		for (int i = 0; i < studentCount; i++) {
			tmp = tmp + studentList[i] + "\n";
		}
		return tmp;
	}

	public static void main(String[] args) {
		StudentList a = new StudentList();
		System.out.println(a);
	}
}
