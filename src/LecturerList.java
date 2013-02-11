public class LecturerList {
	private int lecturerCount;
	private Lecturer[] lecturerList;
	private int[] projectCountForEachLecturer;

	public LecturerList() {
		this.lecturerCount = Data.lecturerCount;
		this.lecturerList = new Lecturer[lecturerCount];
		this.projectCountForEachLecturer = Data.projectCountForEachLecturer;
		for (int i = 0; i < lecturerCount; i++) {
			lecturerList[i] = new Lecturer(i+1, projectCountForEachLecturer[i]);
		}
	}

	public Lecturer getLecturer(int index) {
		return lecturerList[index];
	}

	public String toString() {
		String tmp = "";
		for (int i = 0; i < lecturerCount; i++) {
			tmp += lecturerList[i]+" "+lecturerList[i].getLecturerProjectList();
		}
		return tmp;
	}

	public static void main(String[] args) {
		LecturerList lecturerList = new LecturerList();
		System.out.println(lecturerList);
	}
}
