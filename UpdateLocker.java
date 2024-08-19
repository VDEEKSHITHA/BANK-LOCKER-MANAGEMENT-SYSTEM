package Project;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLocker
 */
@WebServlet("/UpdateStudent")
public class UpdateLocker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateLocker() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?characterEncoding=latin1",
					"root", "Deek2003");
			PreparedStatement st = con.prepareStatement("insert into UpdateStudent values(?, ?, ?, ?, ?, ?, ?, ?)");
			st.setInt(1, Integer.valueOf(request.getParameter("studentId")));
			st.setString(2, request.getParameter("studentName"));
			st.setString(3, request.getParameter("specialization"));
			st.setInt(4, Integer.valueOf(request.getParameter("age")));
			st.setString(5, request.getParameter("contactNumber"));
			st.setString(6, request.getParameter("email"));
			st.setString(7, request.getParameter("address"));

			st.executeUpdate();
			st.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Updated" + "</b></body></html>");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
