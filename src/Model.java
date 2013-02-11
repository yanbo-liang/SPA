public class Model {
	public static LecturerList lecturerList = new LecturerList();
	public static ProjectList projectList = new ProjectList();
	public static StudentList studentList = new StudentList();

	static {
		matchBetweenProjectAndLecturer();
	}

	private static void matchBetweenProjectAndLecturer() {
		int[][] relationBetweenProjectAndLecturer = Data.relationBetweenProjectAndLecturer;
		for (int i = 0; i < relationBetweenProjectAndLecturer.length; i++) {
			Lecturer tmpLecturer = lecturerList.getLecturer(i);
			for (int j = 0; j < relationBetweenProjectAndLecturer[i].length; j++) {
				Project tmpProject = projectList
						.getProject(relationBetweenProjectAndLecturer[i][j]);
				tmpLecturer.getLecturerProjectList().addProject(tmpProject, j);
				tmpProject.setLecturer(tmpLecturer);
			}
		}
	}
	
	public String toString() {
		return lecturerList + "\n" + projectList+"\n"+studentList;
	}
	public static void main(String[] args) {
		Model a = new Model();
		System.out.println(a);
	}
}
