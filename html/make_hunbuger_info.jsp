<%@ page language="java" contentType="text/html; charset=Shift_JIS" pageEncoding="Shift_JIS"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang = "ja">
	<div style="text-align : center ;">
	<link rel="stylesheet" href="buger.css">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
		<title>�n���o�[�K�[�쐬�����</title>
		<script type = "text/javascript">
			function make(){
					window.alert("���߂łƂ��������܂��I�V�����n���o�[�K�[���o���܂����I");
					window.location.href = "index.html";
			}
			function cancel(){
					//window.alert("�쐬��ʂ֖߂�܂�");
					window.location.href = "make_hunbuger.html";
			}
		</script>
	</head>
	<%
		String[] getNamelist = new String[6];
		String[] namelist = new String[6];
		String[] tmps = {"bands_up","sources","foods1","foods2","foods3","bands_down"};

		//�H�ޏ��i���{��j
		String[] bands_up = {"�m�[�}��","�Z�T�~�o���Y","�}�t�B��","�H�p��"};
		String[] sources = {"�P�`���b�v","�f�~�O���X�\�[�X","�}���l�[�Y","�Ă�₫"};
		String[] foods = {"�p�e�B","���^�X","�g�}�g","�`�L��"};
		String[] bands_down = {"�m�[�}��","�Z�T�~�o���Y","�}�t�B��","�H�p��"};
		
		//�H�ޏ��i�p��j
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
			<h1>�n���o�[�K�[�쐬���</h1>
			<table style="margin-left : auto ; margin-right : auto ; text-align : left ;"border="1">
				<caption>�ȉ��̃n���o�[�K�[���쐬���܂�</caption>
					<tr><th> ���</th><th>���</th><th>�摜�i�������j</th></tr>
					<tr><th> �o���Y��</th><th><%= namelist[0] %></th><th>�摜�i�������j</th></tr>
					<tr><th> �\�[�X</th><th><%= namelist[1] %></th><th>�摜�i�������j</th></tr>
					<tr><th> �H��1</th><th><%= namelist[2] %></th><th>�摜�i�������j</th></tr>
					<tr><th> �H��2</th><th><%= namelist[3] %></th><th>�摜�i�������j</th></tr>
					<tr><th> �H��3</th><th><%= namelist[4] %></th><th>�摜�i�������j</th></tr>
					<tr><th> �o���Y��</th><th><%= namelist[5] %></th><th>�摜�i�������j</th></tr>
			</table>
			<br>


			<p>��낵���ł��傤���H</p>
			<input type = "button" value="�쐬����" 					onclick="make()" style="WIDTH: 100px; HEIGHT: 50px"/>
			<input type = "button" value="�L�����Z��" 					onclick="cancel()" style="WIDTH: 100px; HEIGHT: 50px"/><br>
	</body>

</html>
