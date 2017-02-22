<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="<c:url value="/js/modules/utils/select2builder.js"/>"></script>
<script type="text/javascript" src="<c:url value="/libs/rivets/rivets.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/modules/setups/serviceprd.js"/>"></script>
<div class="box box-info">
    <div class="box-body">
        <div class="spacer"></div>
        <div class="spacer"></div>
        <button class="btn btn-info pull-right" id="btn-add-providers">New</button>
        <h4>All Service Providers</h4>
        <div class="spacer"></div>
        <div class="spacer"></div>
        <table id="sprovidertbl" class="table table-hover table-bordered">
            <thead>
            <tr>

                <th>Dealer Class</th>
                <th>Provider Code</th>
                <th>Provider Name</th>
                <th>Date of Appointment</th>
                <th>PIN2</th>
                <th>Sector</th>
                <th width="5%"></th>
                <th width="5%"></th>
            </tr>
            </thead>
        </table>
    </div>
    <div class="modal fade" id="sproviderModal" tabindex="-1" role="dialog"
         aria-labelledby="sproviderModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="sproviderModalLabel">
                        Edit/Add Service Providers
                    </h4>
                </div>
                <div class="modal-body">
                    <form id="provider-form" class="form-horizontal">
                        <input type="hidden" class="form-control" id="sp-id" name="spId">
                        <div class="form-group">
                            <div class="col-md-6">
                            <label for="sp-id" class="col-md-4 control-label">Dealer Class</label>
                               <%-- <div class="col-md-8">
                                    <input type="text" class="form-control" id="prov-sht-desc"
                                           name="spShtDesc"  required>
                                </div> --%>
                            <div class="col-md-8">
                                <select class="form-control" id="driver-class" name="dealerClass" required>
                                    <option value="">Select Dealer Class</option>
                                    <option value="C">Corporate</option>
                                </select>
                            </div>
                                </div>
                            <div class="col-md-6">
                                <label for="provider-code" class="col-md-4 control-label">Provider Code</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="provider-code"
                                           name="spCode"  required>
                                </div>
                                </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <label for="provider-name" class="col-md-4 control-label">Provider Name</label>

                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="provider-name"
                                           name="spName"  required>
                                </div>
                                </div>
                            <div class="col-md-6">
                                <label for="appoint-date" class="col-md-4 control-label">Date of Appointment</label>

                                <div class="col-md-8">

                                    <div class='input-group date datepicker-input'>
                                        <input type='text' class="form-control" name="spAppointDt" id="appoint-date"  required/>
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
                                    </div>
                                </div>
                                </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                            <label for="provider-pin" class="col-md-4 control-label">PIN</label>

                            <div class="col-md-8">
                                <input type="text" class="form-control" id="provider-pin"
                                       name="spPin"  required>
                            </div>
                                </div>
                            <div class="col-md-6">
                                <label for="schema-sect-code" class="col-md-4 control-label">Sector</label>

                                <div class="col-md-8">
                                    <div class="input-group">
                                        <input type="hidden"  id="schema-sect-name"/>
                                        <input type="hidden"  name="sector" id="schema-sect-code"/>
                                        <div id="sector" class="form-control"
                                             select2-url="<c:url value="/protected/setups/schemes/selSectors"/>" >
                                        </div>
                                    </div>
                                </div>
                                </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <label for="scheme-country" class="control-label col-md-4">Country</label>
                                <div class="col-md-8">
                                    <div id="scheme-country" class="form-control"
                                         select2-url="<c:url value="/protected/organization/countries"/>" >

                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="scheme-postal-addr" class="control-label col-md-4">Postal Address</label>
                                <div class="col-md-8">
                                    <input type="text" id="scheme-postal-addr" name="address" class="form-control" placeholder="Postal Address">
                                </div>
                            </div>
                            </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <label for="scheme-town" class="control-label col-md-4">Town</label>
                                <div class="col-md-8">
                                    <div id="scheme-town" class="form-control"
                                         select2-url="<c:url value="/protected/setups/schemes/selTowns"/>" >
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="tel-no" class="control-label col-md-4">Telephone No.</label>
                                <div class="col-md-8">
                                    <input type="text" id="tel-no" name="telephone" class="form-control" placeholder="Telephone No">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6">
                                <label for="scheme-email-addr" class="control-label col-md-4">Email Address</label>
                                <div class="col-md-8">
                                    <input type="email" id="scheme-email-addr" name="email" class="form-control" placeholder="Email Address">
                                </div>
                            </div>
                            <div class="col-md-6">
                                <label for="scheme-email-addr" class="control-label col-md-4">Physical Address</label>
                                <div class="col-md-8">
                                    <textarea rows="3" cols="20" class="editUserCntrls form-control"
                                              id="sp-addresss" name="address"
                                              required>
								</textarea>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button data-loading-text="Saving..." id="saveServiceProviders"
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