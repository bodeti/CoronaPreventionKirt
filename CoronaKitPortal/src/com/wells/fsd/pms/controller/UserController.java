package com.wells.fsd.pms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wells.fsd.pms.entity.Product;
import com.wells.fsd.pms.exception.ProductException;
import com.wells.fsd.pms.service.ProductService;
import com.wells.fsd.pms.service.ProductServiceImpl;

/**
 * Servlet implementation class coronaKitFrontController
 */
@WebServlet({ "/user","/addToKit"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private ProductService productService;
	
	

	@Override
	public void init() throws ServletException {
		
		productService = new ProductServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		String view = "";
		
		switch (url) {
		case "/listProducts":
			view = doList(request, response);
			break;
		case "/newProduct":
			view = doNewProduct(request, response);
			break;
		case "/addProduct":
			view = doAddorSaveProduct(request, response);
			break;
		case "/deleteProduct":
			view = doDeleteProduct(request, response);
			break;
		case "/editProduct":
			view = doEditProduct(request, response);
			break;
		case "/saveProduct":
			view = doAddorSaveProduct(request, response);
			break;
		case "/login":
			doLogin(request, response);
			break;
		case "/user":
			view =doUser(request, response);
			break;
		case "/addToKit":
			
			view =	doAddItemToKit(request, response);
			
			break;
		
		}

		request.getRequestDispatcher(view).forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String doList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String view = "";
		
		try {
			List<Product> products = productService.getAllProducts();
			request.setAttribute("products", products);
			view = "listProducts.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		
		return view;
	}
	
	private String doNewProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Product product = new Product();
		request.setAttribute("product", product);
		request.setAttribute("isNew", true);
		String view = "newProduct.jsp";
		return view;
	}
	
	private String doEditProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
		String view = "";
		try {
		
		Product product = productService.getProduct(pid);
		request.setAttribute("product", product);
		request.setAttribute("isNew", false);
		view = "newProduct.jsp";
		
		
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}
	
	private String doAddorSaveProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Product product = new Product();
		
		product.setProductId((Integer.parseInt(request.getParameter("productId"))));
		product.setProductName(request.getParameter("productName"));
		product.setProductCost((Double.parseDouble(request.getParameter("productCost"))));
		product.setProductDescription(request.getParameter("productDescription"));

		String view = "";

		try {
			if (request.getServletPath().equals("/addProduct")) {
				productService.validateAndAdd(product);
			} else if (request.getServletPath().equals("/saveProduct")) {
				productService.validateAndSave(product);
			}
			request.setAttribute("msg", "Product Saved Successfully");
			view = "listProducts.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}
	
	private String doDeleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		String view = "";
		try {
			productService.deleteProduct(pid);
			
			request.setAttribute("msg", "Product Deleted");
		
		view = "header.jsp";
		
		
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("user");	
		String password = request.getParameter("pass");
		
		if (username.equals("admin") && password.equals("admin")) {
			request.setAttribute("Login", "Succesful");
			request.getRequestDispatcher("/listProducts.jsp").forward(request, response);
			
			
		}
		
		else 
			request.setAttribute("Login", "Login Failure !! Invalid Username or Password.");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	private String doUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String name = request.getParameter("name");	
		
		String view = "";
		
		try {
			List<Product> products = productService.getAllProducts();
			request.setAttribute("products", products);
			request.setAttribute("msg", "Hello "+name);
			request.getRequestDispatcher("/showProductsToAdd.jsp").forward(request, response);
			view = "listProducts.jsp";
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		
		return view;
	
		
		//String email = request.getParameter("email");
		//String amount = request.getParameter("mobile");	
		
		
		//if (name.equals("bhaskar")) {
		
						
		//}
		
	}
	
	private String doAddItemToKit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pid = Integer.parseInt(request.getParameter("pid"));
	
		
		String view = "";
		try {
			
		Product product = productService.getProduct(pid);
		request.setAttribute("product", product);
		request.setAttribute("pid", pid);
		request.getRequestDispatcher("/showKit.jsp").forward(request, response);
		//request.setAttribute("isNew", false);
		view = "showKit.jsp";
		
		
		} catch (ProductException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
	}	
		
	
	/*private String doAddItemToKit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view="";
	
		return view;

	
	
	}*/
	}


