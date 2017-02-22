<div class="modal fade" id="countryModal" tabindex="-1" role="dialog"
		aria-labelledby="countryModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="countryModalLabel">
						Edit/Add Country
					</h4>
				</div>
				<div class="modal-body" id="branch_model">
					<form id="country-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="cou-code" name="couCode">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">Country Code</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="country-id"
									name="couShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">Country Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="cou-name" name="couName" 
									required>
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveCountryBtn"
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
	<div class="modal fade" id="countyModal" tabindex="-1" role="dialog"
		aria-labelledby="countyModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="countyModalLabel">
						Edit/Add County
					</h4>
					<input type="hidden" class="form-control" id="country-pk-code" name="country">
				</div>
				<div class="modal-body" id="branch_model">
					<form id="county-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="county-code" name="countyId">
						<input type="hidden" class="form-control" id="country-code" name="country">
						<div class="form-group">
							<label for="brn-id" class="col-md-3 control-label">County Code</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="county-id"
									name="countyCode"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="cou-name" class="col-md-3 control-label">County Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="county-name" name="countyName" 
									required>
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveCountyBtn"
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
	<div class="modal fade" id="townModal" tabindex="-1" role="dialog"
		aria-labelledby="townModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="townModalLabel">
						Edit/Add Town
					</h4>
					<input type="hidden" class="form-control" id="county-pk-code" name="county">
				</div>
				<div class="modal-body" id="branch_model">
					<form id="town-form" class="form-horizontal">
						<input type="hidden" class="form-control" id="town-code" name="ctCode">
						<input type="hidden" class="form-control" id="count-code" name="county">
						<div class="form-group">
							<label for="town-id" class="col-md-3 control-label">Town Code</label>

							<div class="col-md-8">
								<input type="text" class="form-control" id="town-id"
									name="ctShtDesc"  required>
							</div>
						</div>
						<div class="form-group">
							<label for="town-name" class="col-md-3 control-label">Town Name</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="town-name" name="ctName" 
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="town-postal-code" class="col-md-3 control-label">Postal Code</label>

							<div class="col-md-8">
								<input type="text" class="editUserCntrls form-control"
									id="town-postal-code" name="ctPostalCode" 
									required>
							</div>
						</div>
						
					</form>
				</div>
				<div class="modal-footer">
					<button data-loading-text="Saving..." id="saveTownBtn"
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