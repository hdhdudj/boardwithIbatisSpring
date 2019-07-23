<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.dto.Member"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="pageTitle" value="회원가입" />
<%@ include file="../part/head.jspf"%>

<script>
	function subJoinForm(form) {
		// 유효성 체크 해야함

		form.submit();
	}
</script>

<div class="login-box con table-common">
	<form action="./doJoin" method="POST"
		onsubmit="subJoinForm(this); return false;">
		<table>
			<colgroup>
				<col width="150">
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="loginId" autocomplete="off"
						autofocus="autofocus" placeholder="아이디를 입력해주세요."></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="loginPw"
						placeholder="비밀번호를 입력해주세요."></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td><input type="password" name="loginPwConfirm"
						placeholder="비밀번호 확인을 입력해주세요."></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" autocomplete="off"
						placeholder="이름을 입력해주세요."></td>
				</tr>
				<tr>
					<th>가입</th>
					<td><input class="btn-a" type="submit" value="가입"> <input
						class="btn-a" type="reset" value="취소"
						onclick="location.href = '/';"></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

<%@ include file="../part/foot.jspf"%>