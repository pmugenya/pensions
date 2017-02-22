$(function(){

	$(document).ready(function() {
		createPaymentModes();
		newPaymentModes();
		savePaymentModes();
		$('#min-val,#max-val').number( true, 2 );
		createSectors();
        newSectors();
        saveSectors();
		createFacilTypes();
		saveFacilitatorTypes();
		newFacilTypes();
	})
	
});


function savePaymentModes(){
	var $paymodesForm = $('#pay-modes-form');
	var validator = $paymodesForm.validate();
	 $('#paymentModesModal').on('hidden.bs.modal', function () {
		 validator.resetForm();
		 $('#pay-modes-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea").val("");
	 });
	 
	 $('#savePaymentModes').click(function(){
		 if (!$paymodesForm.valid()) {
				return;
			}
			var $btn = $(this).button('Saving');
			var data = {};
			$paymodesForm.serializeArray().map(function(x){data[x.name] = x.value;});
			var url = "createPaymentModes";
	        var request = $.post(url, data );
	        request.success(function(){
	        	bootbox.alert("Record created/updated Successfully");
				$('#paymodetbl').DataTable().ajax.reload();
				validator.resetForm();
				$('#paymentModesModal').modal('hide');
	        });
	        request.error(function(jqXHR, textStatus, errorThrown){
	        	bootbox.alert(jqXHR.responseText);
			});
			request.always(function(){
				$btn.button('reset');
	        });
	 });
}


function newPaymentModes(){
	$("#btn-add-modes").on("click", function(){
		$('#pay-modes-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden],input[type=number], textarea").val("");
		$('#paymentModesModal').modal('show');
	});
}

function currencyFormat (num) {
    return  num.toFixed(2).replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,")
}

function createPaymentModes(){
	var url = "allpaymentModes";
	  var table = $('#paymodetbl').DataTable( {
			"processing": true,
			"serverSide": true,
			"ajax": url,
			lengthMenu: [ [10, 15], [10, 15] ],
			pageLength: 10,
			destroy: true,
			"columns": [
				{ "data": "pmShtDesc" },
				{ "data": "pmDesc" },
				{ "data": "pmMinValue",
				  "render":function(data,type,full,meta){
					  return currencyFormat(full.pmMinValue);
				  }
				},
				{ "data": "pmMaxValue",
				  "render":function(data,type,full,meta){
					  return currencyFormat(full.pmMaxValue);
				  }
				},
				{ 
					"data": "pmId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-modes='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editPaymentModes(this);"/>';
					}

				},
				{ 
					"data": "pmId",
					"render": function ( data, type, full, meta ) {
						return '<input type="button" class="hyperlink-btn" data-modes='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmModesDel(this);"/>';
					}

				},
			]
		} );
	  return table;
}


function editPaymentModes(button){
	var modes = JSON.parse(decodeURI($(button).data("modes")));
	$("#sht-desc").val(modes["pmShtDesc"]);
	$("#pm-id").val(modes["pmId"]);
	$("#description").val(modes["pmDesc"]);
	$("#min-val").val(modes["pmMinValue"]);
	$("#max-val").val(modes["pmMaxValue"]);
	$('#paymentModesModal').modal('show');
}

function confirmModesDel(button){
	var modes = JSON.parse(decodeURI($(button).data("modes")));
	bootbox.confirm("Are you sure want to delete "+modes["pmShtDesc"]+"?", function(result) {
		 if(result){
	    	  $.ajax({
			        type: 'GET',
			        url:  'deletePayMode/' + modes["pmId"],
			        dataType: 'json',
			        async: true,
			        success: function(result) {
			        	bootbox.alert("Record deleted Successfully");
			        	$('#paymodetbl').DataTable().ajax.reload();
			        },
			        error: function(jqXHR, textStatus, errorThrown) {
                       bootbox.alert(jqXHR.responseText);
			        }
			    });
	      }
		
	});
}


function createSectors(){
	var url = "allSectors";
	var table = $('#sectorTbl').DataTable( {
		"processing": true,
		"serverSide": true,
		"ajax": url,
		lengthMenu: [ [10, 15], [10, 15] ],
		pageLength: 10,
		destroy: true,
		"columns": [
			{ "data": "sectorShtDesc" },
			{ "data": "sectorName" },
			{
				"data": "sectorId",
				"render": function ( data, type, full, meta ) {
					return '<input type="button" class="hyperlink-btn" data-sectors='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editSectors(this);"/>';
				}

			},
			{
				"data": "sectorId",
				"render": function ( data, type, full, meta ) {
					return '<input type="button" class="hyperlink-btn" data-sectors='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmSectorDel(this);"/>';
				}

			},
		]
	} );
	return table;
}


function newSectors(){
    $("#btn-add-sector").on("click", function(){
        $('#sector-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden],input[type=number], textarea").val("");
        $('#sectorModal').modal('show');
    });
}


function saveSectors(){
    var $sectForm = $('#sector-form');
    var validator = $sectForm.validate();
    $('#sectorModal').on('hidden.bs.modal', function () {
        validator.resetForm();
        $('#sector-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea").val("");
    });

    $('#saveSectors').click(function(){
        if (!$sectForm.valid()) {
            return;
        }
        var $btn = $(this).button('Saving');
        var data = {};
        $sectForm.serializeArray().map(function(x){data[x.name] = x.value;});
        var url = "createSectors";
        var request = $.post(url, data );
        request.success(function(){
           // bootbox.alert("Record created/updated Successfully");
            $('#sectorTbl').DataTable().ajax.reload();
            validator.resetForm();
            $('#sectorModal').modal('hide');
        });
        request.error(function(jqXHR, textStatus, errorThrown){
            bootbox.alert(jqXHR.responseText);
        });
        request.always(function(){
            $btn.button('reset');
        });
    });
}

function editSectors(button){
    var sectors = JSON.parse(decodeURI($(button).data("sectors")));
    $("#sector-id").val(sectors["sectorId"]);
    $("#sht-desc").val(sectors["sectorShtDesc"]);
    $("#sector-name").val(sectors["sectorName"]);
    $('#sectorModal').modal('show');
}

function confirmSectorDel(button){
    var sectors = JSON.parse(decodeURI($(button).data("sectors")));
    bootbox.confirm("Are you sure want to delete "+sectors["sectorName"]+"?", function(result) {
        if(result){
            $.ajax({
                type: 'GET',
                url:  'deleteSector/' + sectors["sectorId"],
                dataType: 'json',
                async: true,
                success: function(result) {
                    bootbox.alert("Record deleted Successfully");
                    $('#sectorTbl').DataTable().ajax.reload();
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    bootbox.alert(jqXHR.responseText);
                }
            });
        }

    });
}

function newFacilTypes(){
	$("#btn-add-facilit").on("click", function(){
		$('#facilitator-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden],input[type=number], textarea").val("");
		$('#facilModal').modal('show');
	});
}

function editFacilitor(button){
	var facilitators = JSON.parse(decodeURI($(button).data("facilitators")));
	$("#facil-id").val(facilitators["facilId"]);
	$("#facil-sht-desc").val(facilitators["facilShtDesc"]);
	$("#facil-name").val(facilitators["facilName"]);
	$('#facilModal').modal('show');
}

function confirmDelFacilitator(button){
	var facilitators = JSON.parse(decodeURI($(button).data("facilitators")));
	bootbox.confirm("Are you sure want to delete "+facilitators["facilName"]+"?", function(result) {
		if(result){
			$.ajax({
				type: 'GET',
				url:  'deleteFaciliTypes/' + facilitators["facilId"],
				dataType: 'json',
				async: true,
				success: function(result) {
					bootbox.alert("Record deleted Successfully");
					$('#facilitatorTbl').DataTable().ajax.reload();
				},
				error: function(jqXHR, textStatus, errorThrown) {
					bootbox.alert(jqXHR.responseText);
				}
			});
		}

	});
}

function createFacilTypes(){
	var url = "allSProviders";
	var table = $('#sprovidertbl').DataTable( {
		"processing": true,
		"serverSide": true,
		"ajax": url,
		lengthMenu: [ [10, 15], [10, 15] ],
		pageLength: 10,
		destroy: true,
		"columns": [
			{ "data": "spShtDesc" },
			{ "data": "spName" },
			{
				"data": "spCode",
				"render": function ( data, type, full, meta ) {
					return '<input type="button" class="hyperlink-btn" data-sProviders='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editSProvider(this);"/>';
				}

			},
			{
				"data": "spCode",
				"render": function ( data, type, full, meta ) {
					return '<input type="button" class="hyperlink-btn" data-sproviders='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmDelFacilitator(this);"/>';
				}

			},
		]
	} );
	return table;
}

function saveFacilitatorTypes(){
	var $sectForm = $('#facilitator-form');
	var validator = $sectForm.validate();
	$('#facilModal').on('hidden.bs.modal', function () {
		validator.resetForm();
		$('#facilitator-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea").val("");
	});

	$('#saveFacilitatorTypes').click(function(){
		if (!$sectForm.valid()) {
			return;
		}
		var $btn = $(this).button('Saving');
		var data = {};
		$sectForm.serializeArray().map(function(x){data[x.name] = x.value;});
		var url = "createFacilTypes";
		var request = $.post(url, data );
		request.success(function(){
			//bootbox.alert("Record created/updated Successfully");
			$('#facilitatorTbl').DataTable().ajax.reload();
			validator.resetForm();
			$('#facilModal').modal('hide');
		});
		request.error(function(jqXHR, textStatus, errorThrown){
			bootbox.alert(jqXHR.responseText);
		});
		request.always(function(){
			$btn.button('reset');
		});
	});
}

function newSProviders(){
    $("#btn-add-providers").on("click", function(){
        $('#provider-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden],input[type=number], textarea").val("");
        $('#providerModal').modal('show');
    });
}

function editSProvider(button){
    var providers = JSON.parse(decodeURI($(button).data("providers")));
    $("#facil-id").val(facilitators["facilId"]);
    $("#facil-sht-desc").val(facilitators["facilShtDesc"]);
    $("#facil-name").val(facilitators["facilName"]);
    $('#facilModal').modal('show');
}

function createSectors(){
    var url = "all";
    var table = $('#sectorTbl').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": url,
        lengthMenu: [ [10, 15], [10, 15] ],
        pageLength: 10,
        destroy: true,
        "columns": [
            { "data": "sectorShtDesc" },
            { "data": "sectorName" },
            {
                "data": "sectorId",
                "render": function ( data, type, full, meta ) {
                    return '<input type="button" class="hyperlink-btn" data-sectors='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editSectors(this);"/>';
                }

            },
            {
                "data": "sectorId",
                "render": function ( data, type, full, meta ) {
                    return '<input type="button" class="hyperlink-btn" data-sectors='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmSectorDel(this);"/>';
                }

            },
        ]
    } );
    return table;
}