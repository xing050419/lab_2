<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <link href="./res/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="./res/css/bootstrap-grid.css" rel="stylesheet" type="text/css" />
    <link href="./res/css/bootstrap-reboot.css" rel="stylesheet" type="text/css" />
	<script src="./res/js/jquery-3.2.1.min.js"></script>
	<script src="./res/js/bootstrap.min.js"></script>
    <title>主页</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="index?">图书管理系统</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index?">首页<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="manage?">管理</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about?">关于</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="friend?">友情链接</a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
        </form>
      </div>
    </nav>
    
    <div class="container">
      <div class="card text-center">
        <div class="card-body">
          <h2 class="card-title">欢迎使用图书管理系统</h2>
          <a href="manage?" class="btn btn-primary">开始管理</a>
        </div>
      </div>
      
    </div>
  </body>
</html>