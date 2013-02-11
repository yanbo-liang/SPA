public class Data {
	public static final int studentCount = 100;
	public static final int lecturerCount = 30;
	public static int projectTypeCount[] = setProjectTypeCount();
	public static int projectCount = setProjectCount();
	public static int[] projectCountForEachLecturer = setProjectCountForEachLecturer();
	public static int[][] relationBetweenProjectAndLecturer = relationBetweenProjectAndLecturer();

	private static int[] setProjectTypeCount() {
		int[] typeCount = new int[3];
		double tmp = ((double) Data.studentCount) / 4 * 1.5;
		typeCount[0] = (int) (tmp * 1);
		typeCount[1] = (int) (tmp * 2);
		typeCount[2] = (int) (tmp*1);
		return typeCount;
	}

	private static int setProjectCount() {
		int tmp = projectTypeCount[0] + projectTypeCount[1] + projectTypeCount[2];
		return tmp;
	}

	private static int[] setProjectCountForEachLecturer() {
		int[] eachLecturer = new int[lecturerCount];
		double tmp = (double) projectCount / (double) lecturerCount;
		int average = (int) (tmp + 1);
		for (int i = 0; i < lecturerCount; i++) {
			eachLecturer[i] = average;
		}
		int value = lecturerCount * average - projectCount;
		while (value != 0) {
			int a = (int) (Math.random() * lecturerCount);
			if (eachLecturer[a] < average + 2 && eachLecturer[a] > average - 2) {
				eachLecturer[a] -= 1;
				value -= 1;
			}
		}
		for (int i = 0; i < lecturerCount; i++) {
			int a = (int) (Math.random() * lecturerCount);
			int b = (int) (Math.random() * lecturerCount);
			if (eachLecturer[a] < average + 2 && eachLecturer[b] > average - 2) {
				eachLecturer[a] += 1;
				eachLecturer[b] -= 1;
			}
		}
		return eachLecturer;
	}

	private static int[][] relationBetweenProjectAndLecturer() {
		int[][] relation = new int[lecturerCount][];
		int[] random = randomArray(projectCount);
		int k = 0;
		for (int i = 0; i < lecturerCount; i++) {
			relation[i] = new int[projectCountForEachLecturer[i]];
		}
		for (int i = 0; i < lecturerCount; i++) {
			for (int j = 0; j < relation[i].length; j++) {
				relation[i][j] = random[k];
				k += 1;
			}
		}
		return relation;
	}

	public static int[] randomArray(int count) {
		int[] random = new int[count];
		for (int i = 0; i < count; i++) {
			random[i] = i;
		}
		for (int i = 0; i < count; i++) {
			int tmp = random[i];
			int j = (int) (Math.random() * count);
			tmp = random[i];
			random[i] = random[j];
			random[j] = tmp;
		}
		return random;
	}
}
