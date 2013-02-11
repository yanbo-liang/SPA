public class Algorithm {
	private LecturerList lecturerList = Model.lecturerList;
	private ProjectList projectList = Model.projectList;
	private StudentList studentList = Model.studentList;

	public void core() {

		while (studentList.checkFreeStudent()) {
			Student freeStudent = studentList.getFreeStudent();
			Project topProject = freeStudent.getTopProject();
			if (!topProject.checkPartlyAvailable()) {
				topProject.setStudent(freeStudent);
				freeStudent.setProject(topProject);
			} else {
				if (topProject.newStudensIsPreferred(freeStudent)) {
					topProject.freeCurrentStudent();
					topProject.setStudent(freeStudent);
					freeStudent.setProject(topProject);
				}
			}
		}

		System.out.println(studentList);
	}

	public void core1() {

		while (studentList.checkFreeStudent()) {
			Student freeStudent = studentList.getFreeStudent();
			Project topProject = freeStudent.getTopProject();
			if (topProject.checkAvailable()) {
				topProject.setStudent(freeStudent);
				freeStudent.setProject(topProject);
				topProject.getLecturer().getAStudent();
			} else if (topProject.checkPartlyAvailable()) {
				if (topProject.newStudensIsPreferred(freeStudent)) {
					topProject.freeCurrentStudent();
					topProject.setStudent(freeStudent);
					freeStudent.setProject(topProject);
				}
			}
		}
		System.out.println(studentList);
	}

	public double averageRank() {
		double flag = 0;
		for (int i = 0; i < Data.studentCount; i++) {
			Student tmpStudent = studentList.getStudent(i);
			if (tmpStudent.projectRank(tmpStudent.getProject()) > flag) {
				flag = tmpStudent.projectRank(tmpStudent.getProject());
				System.out.println(tmpStudent);
			}
		}

		return flag;
	}

	public int StableTest() {
		int flag = 0;
		for (int i = 0; i < Data.studentCount; i++) {
			Student tmpStudent = studentList.getStudent(i);
			for (int j = 0; j < Data.projectCount; j++) {
				Project tmpProject = projectList.getProject(j);
				if (tmpProject.getStudent() != null) {
					if (tmpStudent.getProject().equals(tmpProject)) {

					} else {
						if (tmpStudent.projectRank(tmpProject) < tmpStudent.projectRank(tmpStudent.getProject())) {
							// System.out.println("s-p A" +
							// tmpStudent.projectRank(tmpProject));
							// System.out.println("s-p B" +
							// tmpStudent.projectRank(tmpStudent.getProject()));
							if (tmpProject.studentRank(tmpStudent) < tmpProject.studentRank(tmpProject.getStudent())) {
								flag++;
								// System.out.println(tmpProject);
								// System.out.println(tmpStudent);
								// System.out.println("p-s" +
								// tmpProject.studentRank(tmpStudent));
								// System.out.println("p-s" +
								// tmpProject.studentRank(tmpProject.getStudent()));

							}
						}

					}
				}
			}

		}
		return flag;

	}
}
