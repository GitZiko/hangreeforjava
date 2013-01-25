<%@ page language="java" contentType="text/html; charset=Shift_JIS" pageEncoding="Shift_JIS"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang = "ja">
	<div style="text-align : center ;">
	<link rel="stylesheet" href="buger.css">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
		<title>ハンバーガー作成情報画面</title>
		<script type = "text/javascript">
			function make(){
					window.alert("おめでとうございます！新しいハンバーガーが出来ました！");
					window.location.href = "index.html";
			}
			function cancel(){
					//window.alert("作成画面へ戻ります");
					window.location.href = "make_hunbuger.html";
			}
		</script>
	</head>
	<%
		String[] getNamelist = new String[6];
		String[] namelist = new String[6];
		String[] tmps = {"bands_up","sources","foods1","foods2","foods3","bands_down"};

		//食材情報（日本語）
		String[] bands_up = {"ノーマル","セサミバンズ","マフィン","食パン"};
		String[] sources = {"ケチャップ","デミグラスソース","マヨネーズ","てりやき"};
		String[] foods = {"パティ","レタス","トマト","チキン"};
		String[] bands_down = {"ノーマル","セサミバンズ","マフィン","食パン"};
		
		//食材情報（英語）
		String[] eng_bands_up = {"normal","sesami","mafin","syokupan"};
		String[] eng_sources = {"ketchup","demi","mayo","teri"};
		String[] eng_foods = {"pathyi","retas","tomato","chikin"};
		String[] eng_bands_down = {"normal","sesami","mafin","syokupan"};
		
		for(int i = 0; i < 6; i++){
			getNamelist[i] = request.getParameter(tmps[i]);
			System.out.println("getNamelist="+getNamelist[i]);
			namelist[i] = new String(getNamelist[i].getBytes("8859_1"), "JISAutoDetect");
			
			for(int j = 0; j < 4; j++){
				if(getNamelist[i].equals(eng_bands_up[j])){
					namelist[i] = "";
					namelist[i] = bands_up[j];
				}
			}
			for(int j = 0; j < 4; j++){
				if(getNamelist[i].equals(eng_sources[j])){
					namelist[i] = "";
					namelist[i] = sources[j];
				}
			}
			for(int j = 0; j < 4; j++){
				if(getNamelist[i].equals(eng_foods[j])){
					namelist[i] = "";
					namelist[i] = foods[j];
				}
			}

		}


	%>

	<body>
			<h1>ハンバーガー作成情報</h1>
			<table style="margin-left : auto ; margin-right : auto ; text-align : left ;"border="1">
				<caption>以下のハンバーガーを作成します</caption>
					<tr><th> 種類</th><th>具材</th><th>画像（未実装）</th></tr>
					<tr><th> バンズ上</th><th><%= namelist[0] %></th><th>画像（未実装）</th></tr>
					<tr><th> ソース</th><th><%= namelist[1] %></th><th>画像（未実装）</th></tr>
					<tr><th> 食材1</th><th><%= namelist[2] %></th><th>画像（未実装）</th></tr>
					<tr><th> 食材2</th><th><%= namelist[3] %></th><th>画像（未実装）</th></tr>
					<tr><th> 食材3</th><th><%= namelist[4] %></th><th>画像（未実装）</th></tr>
					<tr><th> バンズ下</th><th><%= namelist[5] %></th><th>画像（未実装）</th></tr>
			</table>
			<br>


			<p>よろしいでしょうか？</p>
			<input type = "button" value="作成完了" 					onclick="make()" style="WIDTH: 100px; HEIGHT: 50px"/>
			<input type = "button" value="キャンセル" 					onclick="cancel()" style="WIDTH: 100px; HEIGHT: 50px"/><br>
	</body>

</html>
