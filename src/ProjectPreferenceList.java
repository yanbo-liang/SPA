public class ProjectPreferenceList {
	// Research Project
	// 100-1
	private static int[] type1 = null;
	// Problem Solving Project
	// 69-50 100-70 49-1
	private static int[] type2 = null;
	// Software Development Project
	// 49-1 69-50 100-70
	private static int[] type3 = null;

	public static int[] projectPreferenceList(int type) {
		if (type == 1) {
			return projectPreferenceListType1();
		} else if (type == 2) {
			return projectPreferenceListType2();
		} else if (type == 3) {
			return projectPreferenceListType3();
		}
		return null;
	}

	private static int[] projectPreferenceListType1() {
		if (type1 == null) {
			type1 = new int[100];
			for (int i = 0; i < 100; i++) {
				type1[i] = 100 - i;
			}
		}
		return type1;
	}

	private static int[] projectPreferenceListType2() {
		if (type2 == null) {
			type2 = new int[100];
			for (int i = 0; i < 20; i++) {
				type2[i] = 69 - i;
			}
			for (int i = 20; i < 51; i++) {
				type2[i] = 120 - i;
			}
			for (int i = 51; i < 100; i++) {
				type2[i] = 100 - i;
			}
		}
		return type2;
	}

	private static int[] projectPreferenceListType3() {
		if (type3 == null) {
			type3 = new int[100];
			for (int i = 0; i < 49; i++) {
				type3[i] = 49 - i;
			}
			for (int i = 49; i < 69; i++) {
				type3[i] = 118 - i;
			}
			for (int i = 69; i < 100; i++) {
				type3[i] = 169 - i;
			}
		}
		return type3;
	}
}
