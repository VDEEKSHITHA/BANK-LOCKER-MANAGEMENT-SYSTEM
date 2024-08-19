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
@WebServlet("/AddLocker")
public class AddLocker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLocker() {
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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/locker?characterEncoding=latin1",
					"root", "Deek2003");
			PreparedStatement st = con.prepareStatement("insert into AddLocker values(?, ?, ?, ?, ?, ?, ?, ?)");
			st.setInt(1, Integer.valueOf(request.getParameter("lockerrId")));
			st.setString(2, request.getParameter("lockerName"));
			st.setString(3, request.getParameter("size"));
			st.setString(4, request.getParameter("category"));
			st.setString(5, request.getParameter("jewelsType"));
			st.setString(6, request.getParameter("documentsType"));
			st.setString(7, request.getParameter("contactNumber"));
			st.setString(8, request.getParameter("email"));

			st.executeUpdate();
			st.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Inserted" + "</b></body></html>");
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
