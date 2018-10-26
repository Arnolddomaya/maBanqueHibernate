
<%@ include file="jstl_includes.jsp" %>
<%@ page import="fr.ynov.arnold.banque.others.Url_path"%>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}
</style>
<fmt:setBundle basename="fr.ynov.arnold.banque.textes.msgNavbar" />
<ul>
  <li><a href="#">Home</a></li>
  <li><a href="<c:url value="${ Url_path.ACCOUNT }"/>">comptes</a></li>
  <li><a href="#">Contact</a></li>
  <li><a href="#">About</a></li>
  <c:if test="${ client != null }" >
    <li style="float:right"><a href="<c:url value="${ Url_path.LOG_OUT }"/>"><fmt:message key="logout" /></a></li>
  </c:if>
</ul>

