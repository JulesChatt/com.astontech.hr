<%@include file="../../includes/header.jsp" %>
<%@include file="../../includes/navbar.jsp" %>
<%@include file="../../includes/subnav_admin.jsp" %>

<c:url var="modelsByMake" value="/model" />
<script>
    $(document).ready(function(){

        $('#vehicleMakeId').change(function(){
            $.getJSON('${modelsByMake}',{
                selectedMake : $(this).val(),
                ajax : 'true'
            }, function(data){
                var html = '<option value="">Model</option>';
                var len = data.length;
                for (var i=0; i < len; i++){
                    html += '<option value="' + data[i].vehicleModelId + '">'
                    + data[i].vehicleModelName + '</option>';
                }

                $('#vehicleModelId').html(html);
            })

        })

    });
</script>


<div class="wrapper">
                <%@include file="vehicle_sidebar.jsp" %>

                <div id="main-wrapper" class="col-sm-10">
                <div class="col-sm-8 col-md-7 col-sm-6">
                <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post">
                    <fieldset>
                        <legend>Create a New Vehicle</legend>

                        <div class="form-group">
                            <label for="inputNewVin" class="col-lg-2 control-label">Vin Number</label>

                            <div class="col-lg-10">
                                <form:input path="vehicle.vin" type="text" cssClass="form-control" id="inputNewVin" placeholder="Vin"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputNewPlate" class="col-lg-2 control-label">License Plate</label>
                            <div class="col-lg-10">
                                <form:input path="vehicle.licensePlate" type="text" cssClass="form-control" id="inputNewPlate" placeholder="License Plate"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputNewYear" class="col-lg-2 control-label">Year</label>
                            <div class="col-lg-10">
                                <form:input path="vehicle.year" type="text" cssClass="form-control" id="inputNewYear" placeholder="Year"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputNewColor" class="col-lg-2 control-label">Color</label>
                            <div class="col-lg-10">
                                <form:input path="vehicle.color" type="text" cssClass="form-control" id="inputNewColor" placeholder="Color"></form:input>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="vehicleMakeId" class="col-lg-2 control-label">Vehicle Make</label>
                            <div class="col-lg-10">
                                <select path="vehicleMake.vehicleMakeId" class="form-control" id="vehicleMakeId">
                                    <option value="0">(Select Make)</option>
                                    <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                                        <option value="${vehicleMake.vehicleMakeId}">${vehicleMake.vehicleMakeName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                    <div class="form-group">
                        <label for="vehicleModelId" class="col-lg-2 control-label">Vehicle Model</label>
                        <div class="col-lg-10">
                            <form:select path="vehicleModel.vehicleModelId" cssClass="form-control" id="vehicleModelId" placeholder="">
                                <%--<form:option value="0">(Select Model)</form:option>--%>
                                <%--<c:forEach var="vehicleModel" items="${vehicleModelList}">--%>
                                <%--<form:option value="${vehicleModel.id}">${vehicleModel.vehicleModelName}</form:option>--%>
                                <%--</c:forEach>--%>
                            </form:select>
                        </div>
                    </div>

                    <div class="from-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-primary">Save</form:button>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </div>
    </div>
</div>




<%@include file="../../includes/footer.jsp" %>