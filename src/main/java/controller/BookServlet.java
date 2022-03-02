package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.text.SimpleDateFormat;

import dao.BorrowDao;
import model.Borrow;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BorrowDao borrowDao;
    
	public void init() {
		borrowDao = new BorrowDao();
	}
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("issue") != null) {
    		String book_id = request.getParameter("bookId");
    		int bookId = Integer.parseInt(book_id);
    		String member_id = request.getParameter("memberId");
    		int memberId = Integer.parseInt(member_id);
    		String author = request.getParameter("author");
    		String price = request.getParameter("price");
    		String available = request.getParameter("available");
    		String title = request.getParameter("titile");
    		String dueDate = request.getParameter("dueDate");
    		

    		Borrow borrow = new Borrow();
    		borrow.setBook_id(bookId);
    		borrow.setMember_id(memberId);
    		Date date = new Date();
    	    SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
    	    String issueDate = formatter.format(date);
    		borrow.setIssue_date(issueDate);
    		borrow.setDue_date(dueDate);
    		borrow.setReturn_date(dueDate);

    		try {
    			borrowDao.issue(borrow);
    		} catch (Exception e)
    		{
    			System.out.print(e.getMessage());
    			e.printStackTrace();
    		}
    		response.sendRedirect("Book.jsp?status=yes");//  response goes to view!!
            
        }
        else if (request.getParameter("update") != null) {
        	
        }
        else if(request.getParameter("delete") != null){
        	
        }
        else {
        	response.sendRedirect("Book.jsp?status=no");//  response goes to view!!
        	 
        }
		

	}

}
