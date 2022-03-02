package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PublisherDao;
import model.Publisher;

/**
 * Servlet implementation class PublisherServlet
 */
@WebServlet("/PublisherServlet")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublisherDao pdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PublisherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Publisher> publisher = new ArrayList<Publisher>();
		try {
			publisher = pdao.getPublishers();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("publisher", publisher);
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("Publisher.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("register") != null) {
			String pubName = request.getParameter("pubName");
			String pubAddress = request.getParameter("pubAddress");

			Publisher pub = new Publisher();

			pub.setPub_name(pubName);
			pub.setPub_address(pubAddress);

			try {
				pdao.register(pub);
			} catch (Exception e) {
				System.out.print(e.getMessage());
				e.printStackTrace();
			}
			response.sendRedirect("PublisherServlet");// response goes to view!!

		} else if (request.getParameter("update") != null) {
			String pubName = request.getParameter("pubName");
			String pub_Id = request.getParameter("pubId");
			int pubId = Integer.parseInt(pub_Id);
			String pubAddress = request.getParameter("pubAddress");

			Publisher pub = new Publisher();

			pub.setPub_name(pubName);
			pub.setPub_id(pubId);
			pub.setPub_address(pubAddress);

			try {
				pdao.update(pub);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect("PublisherServlet");// response goes to view!!
		}

		else {
			response.sendRedirect("PublisherServlet");// response goes to view!!

		}
	}

}
