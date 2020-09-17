<%--
  Created by IntelliJ IDEA.
  User: Tran Huu Hien
  Date: 11/09/2020
  Time: 10:08 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="../bootstrap_4/datatables/css/dataTables.bootstrap4.min.css">
<style>
    th {
        align-items: center;
        color: #fd7e14;
        background-color: darkslategray;
        font-size: 20px;
    }

    td {

        height: 35px;

    }

    tr {
        text-align: center;
        align-content: center;
    }
</style>
<body>
<%@include file="/common/header.jsp" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-xl-12" style="border: 2px solid darkblue">
            <div style="text-align: center;padding-top: 10px">
                <h2 style="color: red;font-weight: bold;font-size: 25px">List Product </h2>
            </div>
            <div style="padding-top: 0px">
                <a class="btn btn-outline-success" href="/product?action=create" role="button"
                   style="font-weight: bolder;font-size: 20px">Add New Product</a>
            </div>
            <div class="table-responsive-lg">
                <table class="table table-striped" id="tableStudent" class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">ID-Product</th>
                        <th scope="col">Name-Product</th>
                        <th scope="col">Price-Product</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">Color</th>
                        <th scope="col">Description</th>
                        <th scope="col">Category</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${productList}">
                        <tr>
                            <td>${product.id}</td>
                            <td>${product.name}</td>
                            <td>${product.price}</td>
                            <td>${product.quantity}</td>
                            <td>${product.color}</td>
                            <td>${product.description}</td>
                            <c:if test="${product.category == 1}">
                                <td>Smart Phone</td>
                            </c:if>
                            <c:if test="${product.category  == 2}">
                                <td>Television</td>
                            </c:if>
                            <c:if test="${product.category == 3}">
                                <td>Computer</td>
                            </c:if>
                            <c:if test="${product.category  == 4}">
                                <td>Computer tablet</td>
                            </c:if>
                            <td style="color: goldenrod;font-weight: bolder">
                                <a href="/product?action=edit&id=${product.id}"
                                   class="btn btn-outline-warning" role="button"><span
                                        class="fas fa-edit mr-3">Edit</span></a>
                                <button type="button" class="btn btn-outline-danger" data-toggle="modal"
                                        data-target="#a${product.id}">
                                    Delete
                                </button>
                                <!-- The Modal -->
                                <div class="modal" id="a${product.id}" style="color: #0c0c0c">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <!-- Modal Header -->
                                            <div class="modal-header">
                                                <h4 class="modal-title">Do you want to delete ? </h4>
                                            </div>
                                            <!-- Modal body -->
                                            <div class="modal-body">
                                                Product : ${product.name}
                                            </div>
                                            <!-- Modal footer -->
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-outline-success"
                                                        data-dismiss="modal">Cancel
                                                </button>
                                                <a href="/product?action=delete&id=${product.id}">
                                                    <button type="button" class="btn btn-outline-danger">Delete</button>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $('#tableStudent').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });
    });
</script>
<script src="../bootstrap_4/bootstrap-4.5.2-dist/js/jquery-3.5.1.js"></script>
<script src="../bootstrap_4/datatables/js/jquery.dataTables.min.js"></script>
<script src="../bootstrap_4/datatables/js/dataTables.bootstrap4.min.js"></script>
</body>
</html>
