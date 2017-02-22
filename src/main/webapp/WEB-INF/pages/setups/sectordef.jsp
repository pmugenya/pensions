<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="<c:url value="/js/modules/setups/utilitysetups.js"/>"></script>
<div class="box box-info">
    <div class="box-body">
        <div class="spacer"></div>
        <div class="spacer"></div>
        <button class="btn btn-info pull-right" id="btn-add-sector">New</button>
        <h4>Sectors List</h4>
        <div class="spacer"></div>
        <div class="spacer"></div>
        <table id="sectorTbl" class="table table-hover table-bordered">
            <thead>
            <tr>

                <th>Sector ID</th>
                <th>Sector Name</th>
                <th width="5%"></th>
                <th width="5%"></th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="modal fade" id="sectorModal" tabindex="-1" role="dialog"
         aria-labelledby="sectorModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="sectorModalLabel">
                        Edit/Add Sectors
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="sector-form" class="form-horizontal">
                        <input type="hidden" class="form-control" id="sector-id" name="sectorId">
                        <div class="form-group">
                            <label for="sht-desc" class="col-md-3 control-label">Sector ID</label>

                            <div class="col-md-8">
                                <input type="text" class="form-control" id="sht-desc"
                                       name="sectorShtDesc"  required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sector-name" class="col-md-3 control-label">Sector Name</label>

                            <div class="col-md-8">
                                <input type="text" class="form-control" id="sector-name"
                                       name="sectorName"  required>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button data-loading-text="Saving..." id="saveSectors"
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