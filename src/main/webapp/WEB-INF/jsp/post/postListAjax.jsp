<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

                        <c:forEach items="${allPost}" var="post">
                            <tr <c:if test="${post.ABLE=='T'}">class="postData"</c:if> data-postId="${post.POSTID}">
                                <td class="boardNum">${post.POSTID}</td>
                                <td><c:forEach var="i" begin="1" end="${post.LEVEL-1}">&nbsp;&nbsp;&nbsp;</c:forEach>
                                    <c:if test="${post.LEVEL > 1}">└ </c:if> ${post.TITLE}</td>
                                <td class="userId">${post.USERID}</td>
                                <td class="reg_dt"><fmt:formatDate value="${post.REG_DATE}" pattern="yyyy-MM-dd"/></td>
                            </tr>
                        </c:forEach>

#########################################################################

                        <c:choose>
                            <c:when test="${pageVo.page==1}">
                                <li class="disabled">
                                    <span aria-hidden="true">&laquo;</span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="javascript:getPostList(1, ${pageVo.pageSize});" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${pageVo.page==1}">
                                <li class="disabled">
                                    <span aria-hidden="true">&lt;</span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="javascript:getPostList(${pageVo.page-1}, ${pageVo.pageSize});" aria-label="Previous">
                                        <span aria-hidden="true">&lt;</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach begin="1" end="${paginationSize}" var="page">

                            <%--                            <li <c:if test="${page == pageNum}"> class="active"</c:if> ><a href="${cp}/userPagingList?boardId=${param.boardId}&page=${page}&pageSize=10">${page}</a></li>--%>
                            <c:choose>
                                <c:when test="${page==pageVo.page}">
                                    <li class="active"><span>${page}</span></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="javascript:getPostList(${page}, ${pageVo.pageSize});">${page}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>

                        <%--                     다음 버튼 --%>
                        <c:choose>
                            <c:when test="${pageVo.page==paginationSize}">
                                <li class="disabled">
                                    <span aria-hidden="true">&gt;</span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="javascript:getPostList(${pageVo.page+1}, ${pageVo.pageSize});" aria-label="Next">
                                        <span aria-hidden="true">&gt;</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>

                        <c:choose>
                            <c:when test="${pageVo.page==paginationSize}">
                                <li class="disabled">
                                    <span aria-hidden="true">&raquo;</span>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li>
                                    <a href="javascript:getPostList(${paginationSize}, ${pageVo.pageSize});" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:otherwise>
                        </c:choose>
