package com.test.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.apphosting.utils.remoteapi.RemoteApiPb.Request;
import com.sun.org.apache.xml.internal.security.Init;

@SuppressWarnings("serial")
public class TestSampleGAEServlet extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		//�T�[�u���b�g���̏���

		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world Ziko");

		//���N�G�X�g�̎�M
		String tmp = req.getParameter("menu");
		String menu_name = new String(tmp.getBytes("8859_1"),"JISAutoDetect");

		//�R���e���c�^�C�v�̐ݒ�
		resp.setContentType("text/plain; charset=Shift_JIS");

		System.out.println(menu_name);

		//HTML���������o��
		/*PrintWriter pw = resp.getWriter();
		pw.println("<html>\n"
					+"<head><title>"
					+ menu_name
					+"</title></head>"
					+"<body>"
					+ "�y�[�W�J�ڃe�X�g"
					+"</body>"
					+"</html>\n");
		*/
		ServletContext sc = getServletContext();
			
		System.out.println("menu_name="+menu_name);
		String[] command = {"make_buger","add_menu","del_menu","show_menu","show_buger","recipe","info","create","back"};
		int command_num = command.length;
		for(int i = 0; i < command.length; i++){
			if(command[i].equals(menu_name)){
				command_num = i;
			}
		}
		System.out.println("command_num="+command_num);
		
		//���j���[����
		switch(command_num){
			//�n���o�[�K�[�쐬
			case 0:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/make_hunbuger.html").forward(req,resp);
				System.out.println("�n���o�[�K�[�쐬��ʂ֑J��");
				break;
			//���j���[�ǉ�
			case 1:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/add_menu.html").forward(req,resp);
				break;
			//���j���[����폜
			case 2:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/remove_menu.html").forward(req,resp);
				break;
			//���j���[�{��
			case 3:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/show_menu.html").forward(req,resp);
				break;
			//�n���o�[�K�[�{��
			case 4:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/finished_make_hunbuger_info.html").forward(req,resp);
				break;
			//���V�s
			case 5:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/recipe.html").forward(req,resp);
				break;
			//�쐬�����C���t�H���[�V����
			case 6:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/web_info.html").forward(req,resp);
				break;
			//�쐬�����n���o�[�K�[�̏���\������
			case 7:
				String bands;
				BugerInfo b_info = new BugerInfo();
				bands =  req.getParameter("bands_up");
				b_info.SetBugerFood(bands);
				bands =  req.getParameter("sources");
				b_info.SetBugerFood(bands);
				bands =  req.getParameter("foods1");
				b_info.SetBugerFood(bands);
				bands =  req.getParameter("foods2");
				b_info.SetBugerFood(bands);
				bands =  req.getParameter("foods3");
				b_info.SetBugerFood(bands);
				bands =  req.getParameter("bands_down");
				b_info.SetBugerFood(bands);

				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/make_hunbuger_info.jsp").forward(req,resp);
				break;
			//�߂�
			case 8:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/index.html").forward(req,resp);
				break;
			default:
				System.out.println("����ȊO�̍���");
				break;
		}



	}

}
