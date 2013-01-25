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

		//サーブレット側の処理

		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world Ziko");

		//リクエストの受信
		String tmp = req.getParameter("menu");
		String menu_name = new String(tmp.getBytes("8859_1"),"JISAutoDetect");

		//コンテンツタイプの設定
		resp.setContentType("text/plain; charset=Shift_JIS");

		System.out.println(menu_name);

		//HTML文書書き出し
		/*PrintWriter pw = resp.getWriter();
		pw.println("<html>\n"
					+"<head><title>"
					+ menu_name
					+"</title></head>"
					+"<body>"
					+ "ページ遷移テスト"
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
		
		//メニュー項目
		switch(command_num){
			//ハンバーガー作成
			case 0:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/make_hunbuger.html").forward(req,resp);
				System.out.println("ハンバーガー作成画面へ遷移");
				break;
			//メニュー追加
			case 1:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/add_menu.html").forward(req,resp);
				break;
			//メニューから削除
			case 2:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/remove_menu.html").forward(req,resp);
				break;
			//メニュー閲覧
			case 3:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/show_menu.html").forward(req,resp);
				break;
			//ハンバーガー閲覧
			case 4:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/finished_make_hunbuger_info.html").forward(req,resp);
				break;
			//レシピ
			case 5:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/recipe.html").forward(req,resp);
				break;
			//作成したインフォメーション
			case 6:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/web_info.html").forward(req,resp);
				break;
			//作成したハンバーガーの情報を表示する
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
			//戻る
			case 8:
				resp.setContentType("charset=UTF-8");
				resp.setCharacterEncoding("text/html; charset=UTF-8");
				sc.getRequestDispatcher("/index.html").forward(req,resp);
				break;
			default:
				System.out.println("それ以外の項目");
				break;
		}



	}

}
