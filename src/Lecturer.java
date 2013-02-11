public class Lecturer {
	private int id;
	private int availableCount;
	private ProjectListForEachLecturer projectListForEachLecturer;

	public Lecturer(int id, int projectCount) {
		this.id = id;
		this.availableCount = projectCount;
		this.projectListForEachLecturer = new ProjectListForEachLecturer(projectCount);
	}

	public int getID() {
		return id;
	}

	public int getAvailableCount() {
		return availableCount;
	}

	public void getAStudent() {
		availableCount -=1;
	}

	public ProjectListForEachLecturer getLecturerProjectList() {
		return projectListForEachLecturer;
	}

	public String toString() {
		String tmp = "Lecturer: " + id + " Free: " + availableCount;
		return tmp;
	}

	public static void main(String[] args) {
		Lecturer a = new Lecturer(1, 5);
		System.out.println(a);
	}
}
