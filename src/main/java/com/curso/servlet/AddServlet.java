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
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		boolean idExiste = false;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>Borrado exitoso</title>");
		out.println("</head>");
		out.println("<body style='background-color: #c4fffc'>");

		for (Producto p : AlmacenService.getAlmacen()) {
			if (p.getId() == id) {
				idExiste = true;
				break;
			}
		}

		if (idExiste) {
			out.println("<h3 align='center'>EL ID [" + id + "] YA ESTA ASOCIADO A OTRO PRODUCTO</h3>");
		} else {
			String nombre = request.getParameter("nombre");
			Categoria categoria = Categoria.valueOf(request.getParameter("categoria"));
			Double precio = Double.parseDouble(request.getParameter("precio"));
			Double stock = Double.parseDouble(request.getParameter("stock"));
			
			AlmacenService.getAlmacen().add(new Producto(id, nombre, categoria, precio, stock));
			
			out.println("<h3 align='center'> EL PRODUCTO [" + id + "] HA SIDO AÑADIDO </h3>");
		}
		out.println("<br><a align='center' href='menu.html' ><b>VOLVER</b></a>");

		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
