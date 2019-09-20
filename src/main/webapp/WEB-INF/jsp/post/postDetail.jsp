<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Jsp</title>

    <%@include file="/WEB-INF/jsp/commonJsp/basicLib.jsp"%>

    <style>
        textarea.form-control {
            width: 400px;
        }

        .comment {
            display: inline-block;
        }

        div.row {
            width: 100%;
        }
        .fileList {
            display: inline-block;
        }
        td {
            padding: 10px;
        }

        .btnLine {
            display: inline-block;
        }
    </style>

    <script>
        $(function () {
            $('#regCom').on('click', function () {
                var postId = $('#postId').val();
                var userId = $('#userId').val();
                var cont = $("#cont").val();
                $.ajax({
                    url : '${cp}/post/regCom',
                    type : 'post',
                    data : {'postId' : postId, 'userId' : userId, 'cont' : cont},
                    success : function (data) {
                        console.log(data);
                        var code = "";
                        $.each(data, function (i, v) {
                            code += '<span onclick="delCom(' + v.COMMID + ')" class="glyphicon glyphicon-remove del"></span> ';
                            if(v.ABLE == 'T') {
                                code += '<label id="post_com' + v.COMMID + '" class="control-label"> ' + v.CONT + ' [ ' + v.USERID + ' / ' + formatDate(new Date()) +' ]</label><br>';
                            } else if (v.ABLE == 'F') {
                                code += '<label id="post_com' + v.COMMID + '" class="control-label"> ' + v.CONT + '</label><br>';
                            }
                        });
                        $('#commentList').append(code);
                        $('#cont').val('');
                    }, error : function (xhr) {
                        alert("상태 : " + xhr.status)
                    }
                })
            });
        });

        function formatDate(date) {
            var d = new Date(date), month = '' + (d.getMonth() + 1), day = '' + d.getDate(), year = d.getFullYear();
            if (month.length < 2) month = '0' + month;
            if (day.length < 2) day = '0' + day;
            return [year, month, day].join('-');
        }


        function delCom(idx) {
            $.ajax({
                url : '${cp}/post/delCom',
                type : 'post',
                data : {'comId' : idx, 'userId' : $('#userId').val()},
                success : function (data) {
                    alert("삭제 성공");
                    $('#post_com' + idx).html('삭제된 댓글 입니다');
                }, error : function (xhr) {
                    alert("상태 : " + xhr.status);
                }
            })
        }
    </script>
</head>

<body>
<%@include file="/WEB-INF/jsp/commonJsp/header.jsp"%>
<%--<form id="frm" action="${cp}/regCom" method="post">--%>
<input type="hidden" id="postId" name="postId" value="${post.POSTID}">
<input type="hidden" id="userId" name="userId" value="${S_USER.userId}">

<div class="container-fluid">
    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <%@include file="/WEB-INF/jsp/commonJsp/left.jsp"%>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


        <%--<div class="blog-header">
            <h1 class="blog-title">Board</h1>
            <p class="lead blog-description">2019.09.04 제출</p>
        </div>--%>

            <div class="form-group">
                <label for="title" class="col-sm-1 control-label">제목</label>
                <div class="col-sm-10">
                    <label id="title" class="control-label">${post.TITLE}</label>
                </div>
            </div>
            <br>

            <div class="form-group">
                <label for="post_file" class="col-sm-10 control-label">내용</label>
                <div class="col-sm-10">
                    <label id="post_file" class="control-label">${post.CONT}</label>
                </div>
            </div>
            <br>

            <div class="form-group">
                <label for="post_cont" class="col-sm-10 control-label">첨부파일</label>
                <div id="fileList" class="col-sm-10 btnLine">
                    <c:forEach items="${postFile}" var="file">
<%--                        <label id="post_cont" class="control-label">${file.FILENM}</label><br>--%>
<%--                        <a href="${cp}/download?path=${file.REALFILEPATH}" download="${file.FILENM}">${file.FILENM}<br>--%>
<%--                        <a href="${cp}/download?filename=${file.FILENM}&path=${file.REALFILEPATH}">${file.FILENM}<br>--%>
<%--                        <a href="${cp}/download?filename=${file.FILENM}&path=${file.REALFILEPATH}" download="${file.FILENM}">${file.FILENM}<br>--%>
                        <a href="${cp}/post/download?fileId=${file.FILEID}&fileNm=${file.FILENM}" download="${file.FILENM}">${file.FILENM}<br>
                    </c:forEach>
                </div>
                <div class="col-sm-4 btnLine">
                    <%--<button type="button" class="modify btn btn-success">수정</button>
                    <button type="button" class="modify btn btn-success">삭제</button>
                    <button type="button" class="modify btn btn-success">답글</button>--%>
                    <c:if test="${post.USERID==S_USER.userId}">
                        <a href="${cp}/post/postForm?boardId=${param.boardId}&postId=${param.postId}" class="modify btn btn-success pull-right">수정</a>
                        <a href="${cp}/post/delPost?boardId=${param.boardId}&postId=${param.postId}" class="modify btn btn-success pull-right">삭제</a>
                    </c:if>
                    <a href="${cp}/post/postForm?boardId=${param.boardId}&parentId=${param.postId}" class="modify btn btn-success pull-right">답글</a>
                </div>
            </div>
            <br><br><br>

            <div class="form-group">
                <label for="post_com" class="col-sm-10 control-label">댓글</label>
                <div id="commentList" class="col-sm-10">
                    <c:forEach items="${postCom}" var="com">
                        <c:if test="${com.USERID == S_USER.userId}">
                            <span onclick="delCom(${com.COMMID})" class="glyphicon glyphicon-remove del"></span>
                        </c:if>
                        <c:choose>
                            <c:when test="${com.ABLE == 'T'}">
                                <label id="post_com${com.COMMID}" class="control-label">${com.CONT} [ ${com.USERID} / <fmt:formatDate value="${com.REG_DATE}" pattern="yyyy-MM-dd"/> ]</label><br>
                            </c:when>
                            <c:when test="${com.ABLE == 'F'}">
                                <label id="post_com${com.COMMID}" class="control-label">${com.CONT}</label><br>
                            </c:when>
                        </c:choose>
                    </c:forEach>
                </div>
            </div>
            <br><br>

            <div class="form-group">
                <div class="col-sm-1"> </div>
                <div class="col-sm-4">
                    <textarea class="form-control" rows="3" id="cont" name="cont"></textarea>
                </div>
                <div class="col-sm-2">
                    <button id="regCom" type="button" class="modify btn btn-success">댓글 저장</button>
                </div>
            </div>
            <br>
    </div>
    </div>
</div>
</body>
</html>
