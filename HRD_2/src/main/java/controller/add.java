package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public add() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sno = request.getParameter("sno");
		int ekor = Integer.parseInt( request.getParameter("ekor"));
		int emath = Integer.parseInt(request.getParameter("emath"));
		int eeng = Integer.parseInt(request.getParameter("eeng"));
		int ehist = Integer.parseInt(request.getParameter("ehist"));
		
		Dto dto = new Dto(sno, ekor, emath, eeng, ehist);
		Dao dao = new Dao();
		boolean result = dao.add(dto);
		if(result) {response.sendRedirect("/HRD_2/list.jsp");}
		else {}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
