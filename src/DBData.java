import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBData {
	// create static global variables for connection
	static Connection conn;
	// create static global variables for statement
	static Statement st;

	public static int lecturerCount;
	public static int projectCount;
	public static int studentCount;

	static {
		DBgetSPAData();
	}

	public static void main(String[] args) {
		// insert(); // ������Ӽ�¼
		// update(); // ���¼�¼����
		// delete(); // ɾ����¼
		// DBgetStudent(); // ��ѯ��¼����ʾ
		System.out.println(lecturerCount);
		System.out.println(projectCount);
		System.out.println(studentCount);

	}

	public static void DBgetSPAData() {
		conn = getConnection();
		try {
			String sql = "select * from spa_data";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			rs.next();
			lecturerCount = rs.getInt("lecturer_count");
			projectCount = rs.getInt("project_count");
			studentCount = rs.getInt("student_count");
			conn.close();
		} catch (SQLException e) {
			System.out.println("DBgetSPAData Failed:" + e.getMessage());
		}
	}

	/* �������ݼ�¼���������������ݼ�¼�� */
	public static void insert() {

		conn = getConnection(); // ����Ҫ��ȡ���ӣ������ӵ����ݿ�

		try {
			String sql = "INSERT INTO staff(name, age, sex,address, depart, worklen,wage)"
					+ " VALUES ('Tom1', 32, 'M', 'china','Personnel','3','3000')"; // �������ݵ�sql���

			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����

			int count = st.executeUpdate(sql); // ִ�в��������sql��䣬�����ز������ݵĸ���

			System.out.println("��staff���в��� " + count + " ������"); // �����������Ĵ�����

			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println("��������ʧ��" + e.getMessage());
		}
	}

	/* ���·���Ҫ��ļ�¼�������ظ��µļ�¼��Ŀ */
	public static void update() {
		int[] markList = new Mark(90, 30, 60).getMarkList();
		for (int j = 1; j <= 95; j++) {
			conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�

			try {
				String sql = "update spa_student set student_mark=" + markList[j] + " where student_id =" + j;// �������ݵ�sql���

				st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����

				int count = st.executeUpdate(sql);// ִ�и��²�����sql��䣬���ظ������ݵĸ���

				System.out.println("staff���и��� " + count + " ������"); // ������²����Ĵ�����

				conn.close(); // �ر����ݿ�����

			} catch (SQLException e) {
				System.out.println("��������ʧ��" + e.getMessage());
			}
		}
	}

	/* ��ѯ���ݿ⣬�������Ҫ��ļ�¼����� */
	public static int[][] DBgetStudent() {
		conn = getConnection();
		try {
			String sql = "select student_id,student_mark from spa_student";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println("���Ĳ�ѯ���Ϊ��");
			while (rs.next()) { // �ж��Ƿ�����һ������

				// �����ֶ�����ȡ��Ӧ��ֵ
				int student_id = rs.getInt("student_id");
				int student_mark = rs.getInt("student_mark");

				// ����鵽�ļ�¼�ĸ����ֶε�ֵ
				System.out.println(student_mark);

			}
			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println("��ѯ����ʧ��" + e.getMessage());
		}
	}

	/* ɾ������Ҫ��ļ�¼�������� */
	public static void delete() {

		conn = getConnection(); // ͬ����Ҫ��ȡ���ӣ������ӵ����ݿ�
		try {
			String sql = "delete from staff  where name = 'lili'";// ɾ�����ݵ�sql���
			st = (Statement) conn.createStatement(); // ��������ִ�о�̬sql����Statement����st���ֲ�����

			int count = st.executeUpdate(sql);// ִ��sqlɾ����䣬����ɾ�����ݵ�����

			System.out.println("staff����ɾ�� " + count + " ������\n"); // ���ɾ�������Ĵ�����

			conn.close(); // �ر����ݿ�����

		} catch (SQLException e) {
			System.out.println("ɾ������ʧ��");
		}

	}

	/* get database connection method */
	public static Connection getConnection() {
		// object for database connection
		Connection con = null;
		try {
			// load mysql data driver
			Class.forName("com.mysql.jdbc.Driver");
			// create connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spa", "root", "");
		} catch (Exception e) {
			System.out.println("Database Connection Failed:" + e.getMessage());
		}
		// return an object for database connection
		return con;
	}
}
