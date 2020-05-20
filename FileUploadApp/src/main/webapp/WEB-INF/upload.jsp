<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>File Uploading Form</title>
</head>

<body>

<h3>File Upload App.</h3>
<h4>Select a file to upload:</h4>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file" size="50"/>
    <br/>
    <input type="submit" value="Upload File"/>
</form>

<h4>Already uploaded:</h4>

<div class="grid" align="center">

    <c:forEach var="file" items="${fileList}">
        <div class="cell">
            <img class="images" src="uploadedimages/${file}" alt="${file}" onclick="ShowImage(this.src)">
        </div>
    </c:forEach>

</div>
<h4>Click to the shortcut to preview:</h4>
<img class="imagepreview" id="picture" src="images/glass.jpg">

<div id="myModal" class="modal">
    <div class="modal-content">
        <span class="close">&times;</span>
        <p id="message" about="${message}" align="center">${message}</p>
    </div>
</div>

</body>
</html>
<script type="text/javascript">
    <%@include file="/WEB-INF/upload/upload.js"%>
</script>

<style>
    <%@include file="/WEB-INF/upload/upload.css"%>
</style>

