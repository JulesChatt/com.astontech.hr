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
            <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/update" method="post">
            <fieldset>
                <legend>Update Vehicle</legend>

                <form:hidden path="vehicle.vehicleId" value="${vehicle.vehicleId}" />
                <form:hidden path="vehicle.version" value="${vehicle.version}" />

                <div class="form-group">
                    <label for="inputNewVin" class="col-lg-2 control-label">Vin Number</label>
                    <div class="col-lg-10">
                        <form:input path="vehicle.vin" type="text" cssClass="form-control" id="inputNewVin" value="${vehicle.vin}"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewPlate" class="col-lg-2 control-label">License Plate</label>
                    <div class="col-lg-10">
                        <form:input path="vehicle.licensePlate" type="text" cssClass="form-control" id="inputNewPlate" value="${vehicle.licensePlate}" ></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewYear" class="col-lg-2 control-label">Year</label>
                    <div class="col-lg-10">
                        <form:input path="vehicle.year" type="text" cssClass="form-control" id="inputNewYear" value="${vehicle.year}"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputNewColor" class="col-lg-2 control-label">Color</label>
                    <div class="col-lg-10">
                        <form:input path="vehicle.color" type="text" cssClass="form-control" id="inputNewColor" value="${vehicle.color}"></form:input>
                    </div>
                </div>
                <div class="from-group">
                    <div class="col-lg-10 col-lg-offset-2">
                        <form:button type="reset" value="cancel" class="btn btn-default">Cancel</form:button>
                        <form:button type="submit" value="update" class="btn btn-primary">Update</form:button>
                    </div>
                </div>
            </fieldset>
            </form:form>
        </div>
    </div>

    </div>
</div>