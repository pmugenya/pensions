<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



 <div class="modal fade" id="branchModal" tabindex="-1" role="dialog"
		aria-labelledby="branchModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="branchModalLabel">
						Edit/Add Branch
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
					<form id="branch-form" class="form-horizontal">
					    <div class="alert alert-error alert-dismissible" id="errorDiv" style="display: none;">
						  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						   <div id="errorId"></div>
						</div>
						<input type="hidden" class="form-control" id="brn-code" name="obId">
						<input type="hidden" name="region" id="branchRegion"/>
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Branch ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="brn-id"
									name="obShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="brn-name" class="col-md-3 control-label">Branch Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="brn-name" name="obName" 
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="brn-name" class="col-md-3 control-label">Address</label>

							<div class="col-md-8">
								<textarea rows="3" cols="20" class="editUserCntrls form-control"
								id="brn-addresss" name="address" 
									required>
								</textarea> 
							</div>
						</div>
						<div class="form-group">
							<label for="brn-name" class="col-md-3 control-label">Tel. Number</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="brn-telNumber" name="telNumber" 
									required>
							</div>
						</div>
					<!--	<div class="form-group">
		                 <label for="brn-user" class="control-label col-md-3">Branch User</label>
		                    <div class="col-md-8">
		                     <input type="hidden" id="username" class="form-control"/>
		                     <input type="hidden" id="userCod" class="form-control"/>
		                     <input type="hidden" id="id" name="branchManager.id" rv-value="organization.user.id"/>
		                     
		                        <div id="branch-user" class="form-control" 
				                                 select2-url="<c:url value="/protected/organization/managers"/>" >
				                                 
				               </div>                
		                 </div>
		                 </div>-->
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveBranchBtn"
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
	
	
    
	
	
	 <div class="modal fade" id="regModal" tabindex="-1" role="dialog"
		aria-labelledby="regModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="regModalLabel">
						Edit/Add Region
					</h4>
				</div>
				<div class="modal-body" id="region_model">
					<form id="reg-form" class="form-horizontal">
					    <div class="alert alert-error alert-dismissible errordiv" style="display: none;">
						  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						   <div id="errorId"></div>
						</div>
						<input type="hidden" class="form-control" id="reg-code" name="regCode">
						<input type="hidden" name="organization" id="regOrgCode"/>
						<div class="form-group">
							<label for="reg-id" class="col-md-3 control-label">Region ID</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="reg-id"
									name="shtDesc"  required>
							</div>
						</div>
						
						<div class="form-group">
							<label for="reg-name" class="col-md-3 control-label">Region Name</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="reg-name"
									name="regDesc"  required>
							</div>
						</div>
						
						<div class="form-group">
							<label for="reg-wef" class="col-md-3 control-label">WEF</label>

							<div class="col-md-8">
							   <div class='input-group date datepicker-input'>
				                    <input type='text' class="form-control" name="regWef" id="reg-wef"  required/>
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                </div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="reg-wet" class="col-md-3 control-label">WET</label>

							<div class="col-md-8">
							   <div class='input-group date datepicker-input'>
				                    <input type='text' class="form-control" name="regWet" id="reg-wet" />
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
				                </div>
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveRegionBtn"
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
	
	
	<div class="modal fade" id="reportModal" tabindex="-1" role="dialog"
		aria-labelledby="reportModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		   <form:form id="report-form" class="form-horizontal" action="generateReport" modelAttribute="reportModel">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="reportModalLabel">
						Report Format
					</h4>
				</div>
				<div class="modal-body">
					
					     
						<div class="form-group">
							<label for="format-id" class="col-md-4 control-label">Report Format</label>
							<div class="col-md-8">
							<form:select class="form-control" path="reportFormat" id="report-format">
								   <form:option value="pdf" label="Pdf"/>
								    <form:option value="doc" label="Word"/>
								     <form:option value="xls" label="Excel"/>
								</form:select>
							</div>
						</div>
						
						
					
				</div>
				<div class="modal-footer">
				    <input type="submit" class="btn btn-primary">
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Cancel
					</button>
				</div>
			</div>
			</form:form>
		</div>
	</div>
	
	
