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
    <title>图书管理</title>
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="index?">图书管理系统</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a class="nav-link" href="index?">首页<span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item active">
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
    
    <div class="container" style="padding-top: 20px">
      <ul class="nav nav-pills nav-fill">
        <li class="nav-item">
          <a class="nav-link active" href="manage?">图书列表</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="addrequest?">添加图书</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="searchbookrequest?">查询图书</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="searchauthorrequest?">查询作者</a>
        </li>
      </ul>
      <div class="card">
        <div class="card-header">输入作者信息</div>
        <div class="card-body">
          <form action="updateaddauthor">
            <div class="form-group row">
              <label for="authorId" class="col-sm-2 col-form-label">作者ID</label>
              <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="authorId" value="<s:property value="authorID"/>" name="authorID"/>
              </div>
            </div>
            <div class="form-group row">
              <label for="authorName" class="col-sm-2 col-form-label">姓名</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="authorName" placeholder="请输入作者姓名" name="name">
              </div>
            </div>
            <div class="form-group row">
              <label for="authorAge" class="col-sm-2 col-form-label">年龄</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="authorAge" placeholder="请输入作者年龄" name="age">
              </div>
            </div>
            <div class="form-group row">
              <label for="authorCountry" class="col-sm-2 col-form-label">国籍</label>
              <div class="col-sm-10">
                <input type="text" class="form-control" id="authorCountry" placeholder="请输入作者国籍" name="country">
                <small id="publishDateHelp" class="form-text text-muted">合法的国籍应不超过20个字符，如：中国</small>
              </div>
            </div>
            <button type="submit" class="btn btn-primary">确定</button>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>