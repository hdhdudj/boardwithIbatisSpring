<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.dto.Member"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="pageTitle" value="게시물 작성" />
<%@ include file="../part/head.jspf"%>

<h3 class="con">게시물 작성</h3>
<form action="./doAdd" method="POST">
<div class="con">
<table>
	<tr>
		<th>제목</th>
		<td><input type="text" name="title" placeholder="제목을 써주세요."></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="body" placeholder="내용을 써주세요."></textarea></td>
	</tr>
	<tr>
		<th></th>
		<td><button type="submit">작성</button> <input type="reset" value="리셋"></td>
	</tr>
</table>
<input type="hidden" name="boardId" value="1">
</div>
</form>
<%@ include file="../part/foot.jspf"%>