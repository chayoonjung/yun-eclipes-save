<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title> Lotto </title>
</head>
<body>

	<%
		int[] numbers = new int[6];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					i--;
					break;
				}
			}
		}
	%>

	<table border ="1" style = "margin:50px auto">
		<caption style="height:30px">당첨 예상 번호</caption>
		<tr>
		<% for (int i = 0; i < 6; i++) { %>
			<td style="height:50px;width:50px;text-align:center">
				<%= String.format("%2d", numbers[i]) %>
			</td>
		<% } %>
		</tr>
	</table>

</body>
</html>