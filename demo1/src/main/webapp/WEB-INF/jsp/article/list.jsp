<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.example.demo.dto.Member"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="pageTitle" value="게시물 리스트" />
<%@ include file="../part/head.jspf"%>

<h3 class="con">게시물 리스트</h3>

<div class="con">
	<form action="./list" method="GET">

		<select name="searchType">
			<option value="title">제목</option>
			<option value="body">내용</option>
		</select>

		<c:if test="${param.searchType != null && param.searchType != ''}">
			<script>
				$('select[name="searchType"]').val('${param.searchType}');
			</script>
		</c:if>

		<input type="text" name="searchKeyword" placeholder="검색어"
			value="${param.searchKeyword}"> <input type="submit"
			value="검색" />
	</form>
</div>


<div class="list-1 table-common con">
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
				<th>제목</th>
				<th>댓글</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${list}">
				<tr>
					<td><c:out value="${article.id}" /></td>
					<td><c:out value="${article.regDate}" /></td>
					<td><c:out value="${article.writer}" /></td>
					<td><a href="detail?id=${article.id}"><c:out
								value="${article.title}" /></a></td>
					<td>${article.extra.get("repliesCount")}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../part/foot.jspf"%>