<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        .boardNum {
            width: 100px;
            text-align: center;
        }
        .cont {
            width: 500px;
        }
        .userId {
            width: 100px;
            text-align: center;
        }
        .reg_dt {
            width: 150px;
            text-align: center;
        }

        th {
            text-align: center;
        }
    </style>

    <script type="text/javascript">
        /*$(document).on('click', '.postData', function () {
            // var postId = $(this).children().eq(0).text();

        });*/
        $(function () {
            getPostList(1,10);

            $('#postListDiv').on('click', '.postData', function () {
                $('#postId').val($(this).data("postid"));
                $('#frm').submit();
            });
        });

        function getPostList(page, pageSize) {
            $.ajax({
                url : "${cp}/post/postListJson",
                data : {"page" : page, "pageSize" : pageSize, "boardId" : $('#boardId').val()},
                success : function (data) {
                    console.log(data);
                    $("#postListDiv").empty();

                    var html = data.split("#########################################################################");

                    $("#postListDiv").html(html[0]);
                    $(".pagination").html(html[1]);
                }
            })
        }

    </script>
</head>

<body>
<form action="${cp}/post/postDetail" method="get" id="frm">
    <input type="hidden" id="boardId" name="boardId" value="${param.boardId}">
    <input type="hidden" id="postId" name="postId">
</form>

<%@include file="/WEB-INF/jsp/commonJsp/header.jsp"%>

<div class="container-fluid">
    <div class="row">

        <div class="col-sm-3 col-md-2 sidebar">
            <%@include file="/WEB-INF/jsp/commonJsp/left.jsp"%>
        </div><div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


        <div class="blog-header">
            <h1 class="blog-title">게시판</h1>
        </div>

        <div class="row">

            <div class="col-sm-8 blog-main">
                <div class="container">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th class="boardNum">게시글 번호</th>
                                <th class="cont">제목</th>
                                <th class="userId">작성자 아이디</th>
                                <th class="reg_dt">작성일시</th>
                            </tr>
                        </thead>
                        <tbody id="postListDiv">

                        </tbody>
                    </table>
                </div>

                <%--게시글 등록 버튼--%>
                <a href="${cp}/post/postForm?boardId=${param.boardId}" class="btn btn-default pull-right">게시글 등록</a>

                <div class="text-center">
                    <ul class="pagination">

                    </ul>
                </div>

            </div>
            <!-- /.blog-main -->
        </div>	</div>
    </div>
</div>
</body>
</html>
