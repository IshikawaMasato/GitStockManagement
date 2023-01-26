package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StockManagementDao;
import dto.StockManagement;

/**
 * Servlet implementation class StockRegisterExecuteServlet
 */
@WebServlet("/StockRegisterExecuteServlet")
public class StockRegisterExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockRegisterExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String StockId = request.getParameter("StockId");
		String StockName = request.getParameter("StockName");
		String StockCategory = request.getParameter("StockCategory");
		int StockPrice = Integer.parseInt(request.getParameter("StockPrice"));
		String StockNote = request.getParameter("StockNote");
		
		StockManagement StockManagement = new StockManagement(-1,StockId, StockName, StockCategory, StockPrice, StockNote,null);
	 
		int result = StockManagementDao.registerStockProduct(StockManagement);
		
		String path = "";
		if(result == 1) {
			path = "WEB-INF/view/result.jsp";
		} else {
			// 失敗した場合はパラメータ付きで登録画面に戻す
			path = "WEB-INF/view/RegisterForm.jsp?error=1";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
