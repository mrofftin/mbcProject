<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>	

<div class="container mt-5">
<form action='memberInsert.do'>
	<table>
		<thead>
			<tr>
				<th colspan='2'>회원가입</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>아이디</td>
				<td><input type='text' name='id'></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type='text' name='pw'></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type='text' name='name'></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type='text' name='age'></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type='text' name='email'></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type='text' name='tel'></td>
			</tr>
			<tr>				
				<td colspan='2'>
					<input type='submit' value='회원가입'>
					<input type='reset' value='취소'>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</div>
</body>
</html>