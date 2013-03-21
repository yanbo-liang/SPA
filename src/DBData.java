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
		// insert(); // 插入添加记录
		// update(); // 更新记录数据
		// delete(); // 删除记录
		// DBgetStudent(); // 查询记录并显示
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

	/* 插入数据记录，并输出插入的数据记录数 */
	public static void insert() {

		conn = getConnection(); // 首先要获取连接，即连接到数据库

		try {
			String sql = "INSERT INTO staff(name, age, sex,address, depart, worklen,wage)"
					+ " VALUES ('Tom1', 32, 'M', 'china','Personnel','3','3000')"; // 插入数据的sql语句

			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象

			int count = st.executeUpdate(sql); // 执行插入操作的sql语句，并返回插入数据的个数

			System.out.println("向staff表中插入 " + count + " 条数据"); // 输出插入操作的处理结果

			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println("插入数据失败" + e.getMessage());
		}
	}

	/* 更新符合要求的记录，并返回更新的记录数目 */
	public static void update() {
		int[] markList = new Mark(90, 30, 60).getMarkList();
		for (int j = 1; j <= 95; j++) {
			conn = getConnection(); // 同样先要获取连接，即连接到数据库

			try {
				String sql = "update spa_student set student_mark=" + markList[j] + " where student_id =" + j;// 更新数据的sql语句

				st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

				int count = st.executeUpdate(sql);// 执行更新操作的sql语句，返回更新数据的个数

				System.out.println("staff表中更新 " + count + " 条数据"); // 输出更新操作的处理结果

				conn.close(); // 关闭数据库连接

			} catch (SQLException e) {
				System.out.println("更新数据失败" + e.getMessage());
			}
		}
	}

	/* 查询数据库，输出符合要求的记录的情况 */
	public static int[][] DBgetStudent() {
		conn = getConnection();
		try {
			String sql = "select student_id,student_mark from spa_student";
			st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println("最后的查询结果为：");
			while (rs.next()) { // 判断是否还有下一个数据

				// 根据字段名获取相应的值
				int student_id = rs.getInt("student_id");
				int student_mark = rs.getInt("student_mark");

				// 输出查到的记录的各个字段的值
				System.out.println(student_mark);

			}
			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println("查询数据失败" + e.getMessage());
		}
	}

	/* 删除符合要求的记录，输出情况 */
	public static void delete() {

		conn = getConnection(); // 同样先要获取连接，即连接到数据库
		try {
			String sql = "delete from staff  where name = 'lili'";// 删除数据的sql语句
			st = (Statement) conn.createStatement(); // 创建用于执行静态sql语句的Statement对象，st属局部变量

			int count = st.executeUpdate(sql);// 执行sql删除语句，返回删除数据的数量

			System.out.println("staff表中删除 " + count + " 条数据\n"); // 输出删除操作的处理结果

			conn.close(); // 关闭数据库连接

		} catch (SQLException e) {
			System.out.println("删除数据失败");
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
