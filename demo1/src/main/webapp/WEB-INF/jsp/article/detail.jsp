<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.dto.Article"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../part/head.jspf"%>

<script>
	
</script>

<style>
</style>

<h1 class="con">게시물 상세</h1>

<div class="article-detail table-common con">
	<table>
		<colgroup>
			<col width="80">
		</colgroup>
		<tbody>
			<tr>
				<th>ID</th>
				<td><c:out value="${article.id}" /></td>
			</tr>
			<tr>
				<th>날짜</th>
				<td><c:out value="${article.regDate}" /></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><c:out value="${article.writer}" escapeXml="true" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><c:out value="${article.title}" escapeXml="true" /></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${article.bodyForPrint}</td>
			</tr>
		</tbody>
	</table>
</div>
<h2 class="con">댓글쓰기</h2>
<div class="con">
<form action="./doAddReply" method="POST">
<textarea name="body"></textarea>
<input type="hidden" name="boardId" value="2">
<input type="hidden" name="articleId" value="${article.id}">
<div><button type="submit">댓글쓰기</button></div>
</form>
</div>


<h3 class="con">댓글보기</h3>
<div class="articleReply-detail table-common con">
	<table>
		<colgroup>
			<col width="80">
			<col width="180">
			<col width="80">
			<col>
			<col width="100">
		</colgroup>
		<thead>
			<tr>
				<th>ID</th>
				<th>등록날짜</th>
				<th>글쓴이</th>
				<th>내용</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="articleRelyList" items="${articleRelyList}">
				<tr>
					<td><c:out value="${articleRelyList.id}" /></td>
					<td><c:out value="${articleRelyList.regDate}" /></td>
					<td><c:out value="${articleRelyList.writer}" /></td>
					<td><c:out value="${articleRelyList.body}" /></td>
					<td><a href="./doDeleteReply?id=${articleRelyList.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="../part/foot.jspf"%>