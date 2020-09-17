<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 04/09/2020
  Time: 4:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HEADER</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<link rel="stylesheet" type="text/css" href="../../bootstrap_4/bootstrap-4.5.2-dist/css/bootstrap.min.css">
<body>
<nav class="navbar navbar-expand-lg navbar-darkblue"
     style="background-color: #e3f2fd;border: 2px solid darkblue;height: 60px;padding-left: 20px">
    <div class="collapse navbar-collapse" id="navbarSupportedContent" style="font-weight: bolder;font-size: 20px">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link " href="/home" tabindex="-1" aria-disabled="true">Home</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link " href="/employee" tabindex="-1" aria-disabled="true">Employee</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link " href="/customer" tabindex="-1" aria-disabled="true">Customer</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link " href="/service" tabindex="-1" aria-disabled="true">Service</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                   data-toggle="dropdown" aria-haspopup="false" aria-expanded="false">
                    Contract
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/contract">List Contract</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/contractDetail">Contract-Detail</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/userService">Manager Customer User Service</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" style="padding-right: 20px">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search"
                   value="${search}">
            <input type="hidden" name="action" value="search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="font-weight: bolder">Search
            </button>
        </form>
    </div>
</nav>
<script src="../../bootstrap_4/bootstrap-4.5.2-dist/js/jquery-3.5.1.js"></script>
<script src="../../bootstrap_4/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
</body>
</html>
