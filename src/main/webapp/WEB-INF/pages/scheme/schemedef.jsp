<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="<c:url value="/js/modules/schemes/schemedef.js"/>"></script>
<div class="box box-info">
    <div class="box-body">
        <div class="spacer"></div>
        <div class="spacer"></div>
        <a href="<c:url value="/protected/setups/schemes/schemenew"/>" class="btn btn-primary pull-right">New</a>
        <h4>Schemes List</h4>
        <div class="spacer"></div>
        <div class="spacer"></div>
        <table id="schemesTbl" class="table table-hover table-bordered">
            <thead>
            <tr>

                <th>Scheme ID</th>
                <th>Scheme Name</th>
                <th>Scheme Category</th>
                <th>Sector</th>
                <th>Commencement Date</th>
                <th width="5%"></th>
                <th width="5%"></th>
            </tr>
            </thead>
        </table>
    </div>
</div>