<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 02/09/2020
  Time: 2:57 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MAIN</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<link rel="stylesheet" type="text/css" href="/bootstrap_4/bootstrap-4.5.2-dist/css/bootstrap.min.css">
<script src="/bootstrap_4/bootstrap-4.5.2-dist/js/bootstrap.min.js"></script>
<script src="/bootstrap_4/bootstrap-4.5.2-dist/js/jquery-3.5.1.js"></script>
<body>
<header class="row" style="height: 75px;background-color: honeydew">
        <img class="col-xl-3" src="/imagi/logo.jpg" alt="picture"
             style="height: 60px;text-align: center;padding-top: 7px ">
    <div class="col-xl-6">
        <img src="/imagi/unnamed.png" alt="logo" style="height: 69px; width:230px;align-content: center;padding-top: 5px">
    </div>
    <div class="col-xl-3" style="align-content: center; text-align: center;padding-top: 7px ">
        <h5 style="color: red ;font-weight: bolder">TRAN HUU HIEN</h5>
        <h5>Class: C0520G1 </h5>
    </div>
</header>
<nav class="navbar navbar-expand-lg navbar-darkblue"
     style="background-color: #e3f2fd;border: 2px solid darkblue;height: 80px;padding-left: 20px">
    <div class="collapse navbar-collapse" id="navbarSupportedContent" style="font-weight: bolder;font-size: 20px">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link " href="#" tabindex="-1" aria-disabled="true">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#" tabindex="-1" aria-disabled="true">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#" tabindex="-1" aria-disabled="true">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#" tabindex="-1" aria-disabled="true">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="#" tabindex="-1" aria-disabled="true">Contract</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" style="padding-right: 20px">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" style="font-weight: bolder">Search
            </button>
        </form>
    </div>
</nav>
<div class="container-fluid">
    <div class="row" style="height: 400px">
        <div class="col-xl-12" style="border: 1px solid darkblue">
            <div>
                <a href="#">Item one</a>
            </div>
            <div style="text-align: center">
                <h1>Body</h1>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xl-12" style="border: 1px solid darkblue; text-align: center">
            <h1>FOOTER</h1>
        </div>
    </div>
</div>
</body>
</html>
