package com.cestar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestar.dao.bankDao;
import com.cestar.model.bank;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String url = request.getServletPath();
		
		switch (url) {
		
		case "/insert":{
			
			
			enterDetails(request, response);
			break;
			
		}
		
		case "/enterData":{
			
			insertRec(request, response);			
			break;
			
		}
		
		case "/display":{
			
			displayAll(request, response);
			
			break;
		}
		
		case "/edit":{
			
			out.print("We are at edit page...");
			
			editRec(request, response);
			break;
			
		}
		
		case "/update":{
			
			updateRec(request, response);
			
			break;
		}
		
		case "/delete":{
			
			deleteRec(request, response);
			
			break;
		}
		
		default :{
			
			out.print("Sorry the page is not available!!.....");
		}
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void insertRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		int accountId = Integer.parseInt(request.getParameter("id"));
		
		String accountType = request.getParameter("type");
		
		String accountName = request.getParameter("name");
		
		String accountContact = request.getParameter("contact");
		
		String accountBalance = request.getParameter("balance");
		
		String accountDate = request.getParameter("date");
		
		bank bnk = new bank(accountId,accountType,accountName,accountContact,accountBalance,accountDate);
		
		bankDao obj = new bankDao();
		
		int status = obj.addRec(bnk);
		
		if(status > 0) {
			out.print("<h1>Employee record has been inserted successfully...</h1>");
		}
		
		displayAll(request, response);
	}
	
	protected void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		bankDao obj = new bankDao();
		
		List<bank> bnk = obj.displayAllRec();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("bankdetails",bnk);
		
		RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
		
		rd.forward(request, response);
	}

	
	protected void editRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		bankDao obj = new bankDao();
		
		int old_id = Integer.parseInt(request.getParameter("id"));
		
		bank toBeUpdated = obj.getRecById(old_id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("bankToBeUpdated",toBeUpdated);
		
		session.setAttribute("oldId",old_id);
		
		RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
		
		rd.forward(request, response);
		
	}
	
	protected void updateRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));
		
		String type = request.getParameter("type");
		
		String name = request.getParameter("name");
		
		String contact = request.getParameter("contact");
		
		String balance = request.getParameter("balance");
		
		String date = request.getParameter("date");
		
		bank bnk = new bank(id,type,name,contact,balance,date);
		
		HttpSession session = request.getSession();
		
		int oldId = (int) session.getAttribute("oldId");
		
		bankDao obj = new bankDao();
	
		obj.updtaeRec(oldId, bnk);
		
		displayAll(request, response);
		
	}
	
	protected void deleteRec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		bankDao obj = new bankDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		obj.deleteRec(id);
		
		displayAll(request, response);
	}
	
	protected void enterDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("enterData.jsp");
		
		rd.forward(request, response);
	}
	
	
}





