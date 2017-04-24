<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>


<div class="wrapper">

    <%--SIDEBAR here--%>
    <%@include file="vehicle_sidebar.jsp" %>

    <div id="main-wrapper" class="col-sm-10">
        <div class="col-sm-12">
            <%--LIST OF EXISTING ELEMENTS--%>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <%--<th>Vehicle Model</th>--%>
                    <th>Vehicle Id</th>
                    <th>Vehicle Make</th>
                    <th>Vehicle Model</th>
                    <th>Vin</th>
                    <th>Year</th>
                    <th>LicensePlate</th>
                    <th>Color</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="make" items="${vehicleMakeList}">
                        <c:forEach var="model" items="${make.vehicleModelList}">
                            <c:forEach var="vehicle" items="${model.vehicleList}">
                                <tr>
                                    <td>${vehicle.vehicleId}</td>
                                    <td>${make.vehicleMakeName}</td>
                                    <td>${model.vehicleModelName}</td>
                                    <td>${vehicle.vin}</td>
                                    <td>${vehicle.year}</td>
                                    <td>${vehicle.licensePlate}</td>
                                    <td>${vehicle.color}</td>
                                    <td><a href="/admin/vehicle/edit/${vehicle.vehicleId}">Edit</a></td>
                                    <td><a href="/admin/vehicle/delete/${vehicle.vehicleId}">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<%@include file="../../includes/footer.jsp" %>