package com.amaker.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amaker.dao.UpdateDao;
import com.amaker.dao.impl.UpdateDaoImpl;
import com.amaker.entity.Menu;
import com.amaker.entity.Table;

public class UpdateTableServlet extends HttpServlet {
	// ���췽��
		public UpdateTableServlet() {
			super();
		}
		// ���ٷ���
		public void destroy() {
			super.destroy();
		}
		// ��ӦGet����
		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/xml");
			PrintWriter out = response.getWriter();
			// ʵ����dao
			UpdateDao dao = new UpdateDaoImpl();
			// ��ò����б�
			List list = dao.getTableList();
			
			// ƴXML��ʽ����
			out.println("<?xml version='1.0' encoding='UTF-8'?>");
			// ���ڵ�
			out.println("<tablelist>");
				for (int i = 0; i <list.size(); i++) {
					Table t = (Table)list.get(i);
					out.println("<table>");
						// �������
						out.print("<id>");
							out.print(t.getId());
						out.println("</id>");
						// ��������
						out.print("<num>");
							out.print(t.getNum());
						out.println("</num>");
						// ��ע
						out.print("<description>");
							out.print(t.getDescription());
						out.println("</description>");
					out.println("</table>");
				}
			out.println("</tablelist>");
			out.flush();
			out.close();
		}
		// ��ӦPost����
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			doGet(request,response);
		}
		// ��ʼ������
		public void init() throws ServletException {
		}
}
