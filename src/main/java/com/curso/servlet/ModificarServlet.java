package com.curso.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.curso.modelo.Categoria;
import com.curso.modelo.Producto;
import com.curso.service.AlmacenService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModificarServlet
 */
public class ModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("producto"));
		for (Producto p : AlmacenService.getAlmacen()) {
			if (p.getId() == id) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<meta charset=\"UTF-8\">");
				out.println("<title>Borrado exitoso</title>");
				out.println("</head>");
				out.println("<body style='background-color: #c4fffc'>");

				p.setNombre(request.getParameter("nombre"));
				p.setCategoria(Categoria.valueOf(request.getParameter("categoria")));
				p.setPrecio(Double.parseDouble(request.getParameter("precio")));
				p.setStock(Double.parseDouble(request.getParameter("precio")));

				out.println("<h2 align='center'> EL PRODUCTO [" + p.getId() + "] HA SIDO MODIFICADO </h2>");
				out.println("<p align='center'>" + p + "</p>");
				out.println("<br><a align='center' href='menu.html' ><b>VOLVER</b></a>");
				out.println("</body>");
				out.println("</html>");
				out.close();

			}
		}
	}

}
