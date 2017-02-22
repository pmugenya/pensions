<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="<c:url value="/js/modules/utils/select2builder.js"/>"></script>
<script type="text/javascript" src="<c:url value="/libs/rivets/rivets.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/modules/setups/serviceprd.js"/>"></script>
<div class="box box-info">
    <div class="box-body">
        <div class="spacer"></div>
        <div class="spacer"></div>
        <button class="btn btn-info pull-right" id="btn-add-periods">New</button>
        <h4>Scheme Periods</h4>
        <div class="spacer"></div>
        <div class="spacer"></div>
        <table id="speriodtbl" class="table table-hover table-bordered">
            <thead>
            <tr>

                <th>Scheme Period Description</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Period Closed</th>
                <th width="5%"></th>
                <th width="5%"></th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="modal fade" id="speriodModal" tabindex="-1" role="dialog"
         aria-labelledby="speriodModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="speriodModalLabel">
                        Edit/Add Scheme Providers
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="period-form" class="form-horizontal">
                        <input type="hidden" class="form-control" id="sp-id" name="speriodId">
                        <div class="form-group">
                            <div class="col-md-8">
                                <label for="speriod-name" class="col-md-4 control-label">Scheme Period Desc</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="speriod-name"
                                           name="speriodName"  required>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <label for="start-date" class="col-md-4 control-label">Start Date</label>

                                <div class="col-md-8">

                                    <div class='input-group date datepicker-input'>
                                        <input type='text' class="form-control" name="startDate" id="start-date"  required/>
                                        <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <label for="end-date" class="col-md-4 control-label">End Date</label>

                                <div class="col-md-8">

                                    <div class='input-group date datepicker-input'>
                                        <input type='text' class="form-control" name="endDate" id="end-date"  required/>
                                        <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button data-loading-text="Saving..." id="saveSchemePeriods"
                            type="button" class="btn btn-primary">
                        Save
                    </button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        Cancel
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>