package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import model.Member;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MemberDao mdao;

	public void init() {
		mdao = new MemberDao();
	}
	
    public MemberServlet() {
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
		

        if (request.getParameter("register") != null) {
        	String memName = request.getParameter("memName");
    		String memid = request.getParameter("memId");
    		int memId = Integer.parseInt(memid);
    		String memAddress = request.getParameter("memAddress");
    		String memType = request.getParameter("memType");
    		String memStartdate = request.getParameter("memStartdate");
    		String memExpirydate = request.getParameter("memExpirydate");

    		Member mem = new Member();

    		mem.setMem_name(memName);
    		mem.setMem_id(memId);
    		mem.setMem_address(memAddress);
    		mem.setMem_type(memType);
    		mem.setMem_date(memStartdate);
    		mem.setExpiry_date(memExpirydate);
    		

    		try {
    			mdao.register(mem);
    		} catch (Exception e)
    		{
    			System.out.print(e.getMessage());
    			e.printStackTrace();
    		}
    		response.sendRedirect("Member.jsp?status=yes");//  response goes to view!!
            
        }
        else if (request.getParameter("update") != null) {
        	String memName = request.getParameter("memName");
    		String memid = request.getParameter("memId");
    		int memId = Integer.parseInt(memid);
    		String memAddress = request.getParameter("memAddress");
    		String memType = request.getParameter("memType");
    		String memStartdate = request.getParameter("memStartdate");
    		String memExpirydate = request.getParameter("memExpirydate");

    		Member mem = new Member();

    		mem.setMem_name(memName);
    		mem.setMem_id(memId);
    		mem.setMem_address(memAddress);
    		mem.setMem_type(memType);
    		mem.setMem_date(memStartdate);
    		mem.setExpiry_date(memExpirydate);
    		

    		try {
    			mdao.update(mem);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		response.sendRedirect("Member.jsp?status=yes");//  response goes to view!!
        }
        
        else {
        	response.sendRedirect("Member.jsp?status=no");//  response goes to view!!
        	 
        }
		
	}

}
