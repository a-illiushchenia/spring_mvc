<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 13.11.2016
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
    <h2>A global community of friends and strangers spitting out their
        inner-most and personal thoughts on the web for everyone else to
        see.</h2>
    <h3>Look at what these people are spitting right now...</h3>
    <ol class="spittle-list">
        <c:forEach var="spittle" items="${spittles}"> <!-- Цикл по списку сообщений -->
            <s:url value="/spitters/{spitterName}"
                   var="spitter_url"> <!-- Конструирование URL-сообщения -->
                <s:param name="spitterName"
                         value="${spittle.spitter.username}"/>
            </s:url>
            <li>
<span class="spittleListImage">
<img src="http://s3.amazonaws.com/spitterImages/${spittle.spitter.id}.jpg"
     width="48"
     border="0"
     align="middle"
     onError="this.src='<s:url value="/resources/images"/>/spitter_avatar.jpeg'"/>
</span>
                <span class="spittleListText">
    <a href="${spitter_url}"> <!-- Отображение свойств сообщения -->
    <c:out value="${spittle.spitter.username}"/></a>
    - <c:out value="${spittle.text}"/><br/>
<%--<small><fmt:formatDate value="${spittle.when}"--%>
                       <%--pattern="hh:mma MMM d, yyyy"/></small>--%>
</span>
            </li>
        </c:forEach>
    </ol>
</div>
