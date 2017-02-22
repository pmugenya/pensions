<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="<c:url value="/js/modules/setups/utilitysetups.js"/>"></script>
<div class="box box-info">
    <div class="box-body">
        <div class="spacer"></div>
        <div class="spacer"></div>
        <button class="btn btn-info pull-right" id="btn-add-facilit">New</button>
        <h4>Facilitator Types List</h4>
        <div class="spacer"></div>
        <div class="spacer"></div>
        <table id="facilitatorTbl" class="table table-hover table-bordered">
            <thead>
            <tr>

                <th>Facilitator ID</th>
                <th>Facilitator Name</th>
                <th width="5%"></th>
                <th width="5%"></th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="modal fade" id="facilModal" tabindex="-1" role="dialog"
         aria-labelledby="facilModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="facilModalLabel">
                        Edit/Add Facilitator Types
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="facilitator-form" class="form-horizontal">
                        <input type="hidden" class="form-control" id="facil-id" name="facilId">
                        <div class="form-group">
                            <label for="facil-sht-desc" class="col-md-3 control-label">Facilitator ID</label>

                            <div class="col-md-8">
                                <input type="text" class="form-control" id="facil-sht-desc"
                                       name="facilShtDesc"  required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="facil-name" class="col-md-3 control-label">Facilitator Name</label>

                            <div class="col-md-8">
                                <input type="text" class="form-control" id="facil-name"
                                       name="facilName"  required>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button data-loading-text="Saving..." id="saveFacilitatorTypes"
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