
$(function() {

    $(document).ready(function () {
        createServiceProviders();
        createSchemePeriods();
        newServiceProviders();
        saveServiceProviders();
        saveSchemePeriods();
        createSectorlov();
        createCountryLov();
        createTownLov();
        newSchemePeriods();

        $(".datepicker-input").each(function() {
            $(this).datetimepicker({
                format: 'DD/MM/YYYY'
            });

        });
    })
});


function createTownLov(){
    if($("#scheme-town").filter("div").html() != undefined)
    {
        Select2Builder.initAjaxSelect2({
            containerId : "scheme-town",
            sort : 'ctName',
            change: function(e, a, v) {

            },
            formatResult : function(a)
            {
                return a.ctName
            },
            formatSelection : function(a)
            {
                return a.ctName
            },
            initSelection: function (element, callback) {
                //var countryCode = $("#countryCode").val();
                //var countryName = $("#countryName").val();
                //model.organization.country.couCode = countryCode;
                //model.organization.country.county.countyId = -2000;
                //var data = {couName:countryName,couCode:countryCode};
                //callback(data);
            },
            id: "ctCode",
            width:"200px"
        });
    }
}


function createCountryLov(){
    if($("#scheme-country").filter("div").html() != undefined)
    {
        Select2Builder.initAjaxSelect2({
            containerId : "scheme-country",
            sort : 'couName',
            change: function(e, a, v) {

            },
            formatResult : function(a)
            {
                return a.couName
            },
            formatSelection : function(a)
            {
                return a.couName
            },
            initSelection: function (element, callback) {
                //var countryCode = $("#countryCode").val();
                //var countryName = $("#countryName").val();
                //model.organization.country.couCode = countryCode;
                //model.organization.country.county.countyId = -2000;
                //var data = {couName:countryName,couCode:countryCode};
                //callback(data);
            },
            id: "couCode",
            width:"200px"
        });
    }
}

function createSectorlov(){
    if($("#sector").filter("div").html() != undefined)
    {
        Select2Builder.initAjaxSelect2({
            containerId : "sector",
            sort : 'sectorName',
            change:  function(e, a, v) {
                //$("#schema-sect-name").val(e.added.sectorName);
                $("#schema-sect-code").val(e.added.sectorId);
            },
            formatResult : function(a)
            {
                return a.sectorName
            },
            formatSelection : function(a)
            {
                return a.sectorName
            },
            initSelection: function (element, callback) {
                //var code = $("#schema-sect-code").val();
                //var name = $("#schema-sect-name").val();
                //var data = {sectorName:name,sectorId:code};
                //callback(data);
            },
            id: "sectorId",
            width:"200px"
        });
    }
}

function newServiceProviders(){
    $("#btn-add-providers").on("click", function(){
        $('#provider-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden],input[type=number], textarea").val("");
        $('#sproviderModal').modal('show');
    });
}
function newSchemePeriods() {
    $("#btn-add-periods").on("click", function(){
       $('#period-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden],input[type=number], textarea").val("");
       $('#speriodModal').modal('show')
    });
}

function createSchemePeriods(){
    var url = "allSchemePeriods";
    var table = $('#speriodtbl').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": url,
        lengthMenu: [ [10, 15], [10, 15] ],
        pageLength: 10,
        destroy: true,
        "columns": [
            { "data": "speriodName",
                "render":function(data,type,full,meta){
                    return full.speriodName;
                }
            },
            { "data": "startDate",
                "render":function(data,type,full,meta){
                    return full.startDate;
                }
            },

            { "data": "endDate",
                "render":function(data,type,full,meta){
                    return full.endDate;
                }
            },
            {
                "data": "speriodId",
                "render": function ( data, type, full, meta ) {
                    return '<input type="button" class="hyperlink-btn" data-speriods='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editPeriod(this);"/>';
                }

            },
            {
                "data": "speriodId",
                "render": function ( data, type, full, meta ) {
                    return '<input type="button" class="hyperlink-btn" data-speriods='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmDelSchemePeriod(this);"/>';
                }

            },
        ]
    } );
    return table;
}
function createServiceProviders(){
    var url = "allServiceProviders";
    var table = $('#sprovidertbl').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": url,
        lengthMenu: [ [10, 15], [10, 15] ],
        pageLength: 10,
        destroy: true,
        "columns": [
            { "data": "dealerClass" },
            { "data": "spCode" },
            { "data": "spName",
                "render":function(data,type,full,meta){
                    return full.spName;
                }
            },
            { "data": "spAppointDt",
                "render":function(data,type,full,meta){
                    return full.spAppointDt;
                }
            },
            { "data": "spPin" },
            { "data": "sector",
                "render":function(data,type,full,meta){
                    return full.sector.sectorName;
                }
            },
            {
                "data": "spId",
                "render": function ( data, type, full, meta ) {
                    return '<input type="button" class="hyperlink-btn" data-sproviders='+encodeURI(JSON.stringify(full)) + ' value="Edit" onclick="editProvider(this);"/>';
                }

            },
            {
                "data": "spId",
                "render": function ( data, type, full, meta ) {
                    return '<input type="button" class="hyperlink-btn" data-sproviders='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmDelServiceProvider(this);"/>';
                }

            },
        ]
    } );
    return table;
}

function saveSchemePeriods(){
    var $perForm = $('#period-form');
    var validator = $perForm.validate();
    $('#speriodModal').on('hidden.bs.modal', function () {
        validator.resetForm();
        $('#period-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea").val("");
    });

    $('#saveSchemePeriods').click(function(){
        if (!$perForm.valid()) {
            return;
        }
        var $btn = $(this).button('Saving');
        var data = {};
        $perForm.serializeArray().map(function(x){data[x.name] = x.value;});
        var url = "createSchemePeriod";
        var request = $.post(url, data );
        request.success(function(){
            //bootbox.alert("Record created/updated Successfully");
            $('#speriodtbl').DataTable().ajax.reload();
            validator.resetForm();
            $('#speriodModal').modal('hide');
        });
        request.error(function(jqXHR, textStatus, errorThrown){
            bootbox.alert(jqXHR.responseText);
        });
        request.always(function(){
            $btn.button('reset');
        });
    });
}

function editProvider(button){
    var sproviders = JSON.parse(decodeURI($(button).data("sproviders")));
    $("#sp-id").val(sproviders["spId"]);
    //$("#appoint-date").val(sproviders["spAppointDt"].format('DD/MM/YYYY'));
    $("#appoint-date").val(moment(sproviders["spAppointDt"]).format('DD/MM/YYYY'));
    $("#provider-code").val(sproviders["spCode"]);
    $("#provider-name").val(sproviders["spName"]);
    $("#provider-pin").val(sproviders["spPin"]);
    $("#schema-sect-name").val(sproviders["sector"].sectorName)
    $('#sproviderModal').modal('show');
}
function editPeriod(button){
    var speriods = JSON.parse(decodeURI($(button).data("speriods")));
    $("#sp-id").val(speriods["speriodId"]);
    $("#speriod-name").val(speriods["speriodName"]);
    //$("#appoint-date").val(sproviders["spAppointDt"].format('DD/MM/YYYY'));
    $("#start-date").val(moment(speriods["startDate"]).format('DD/MM/YYYY'));
    $("#end-date").val(moment(speriods["endDate"]).format('DD/MM/YYYY'));


    $('#speriodModal').modal('show');
}

function saveServiceProviders(){
    var $provForm = $('#provider-form');
    var validator = $provForm.validate();
    $('#sproviderModal').on('hidden.bs.modal', function () {
        validator.resetForm();
        $('#provider-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden], textarea").val("");
    });

    $('#saveServiceProviders').click(function(){
        if (!$provForm.valid()) {
            return;
        }
        var $btn = $(this).button('Saving');
        var data = {};
        $provForm.serializeArray().map(function(x){data[x.name] = x.value;});
        var url = "createServiceProvider";
        var request = $.post(url, data );
        request.success(function(){
            //bootbox.alert("Record created/updated Successfully");
            $('#sprovidertbl').DataTable().ajax.reload();
            validator.resetForm();
            $('#sproviderModal').modal('hide');
        });
        request.error(function(jqXHR, textStatus, errorThrown){
            bootbox.alert(jqXHR.responseText);
        });
        request.always(function(){
            $btn.button('reset');
        });
    });
}
function confirmDelServiceProvider(button){
    var $sproviders = JSON.parse(decodeURI($(button).data("sproviders")));
    bootbox.confirm("Are you sure want to delete "+$sproviders["spName"]+"?", function(result) {
        if(result){
            $.ajax({
                type: 'GET',
                url:  'deleteServiceProviders/' + $sproviders["spId"],
                dataType: 'json',
                async: true,
                success: function(result) {
                    bootbox.alert("Record deleted Successfully");
                    $('#sprovidertbl').DataTable().ajax.reload();
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    bootbox.alert(jqXHR.responseText);
                }
            });
        }

    });
}
function confirmDelSchemePeriod(button){
    var $speriods = JSON.parse(decodeURI($(button).data("speriods")));
    bootbox.confirm("Are you sure want to delete "+$speriods["speriodName"]+"?", function(result) {
        if(result){
            $.ajax({
                type: 'GET',
                url:  'deleteSchemePeriod/' + $speriods["periodId"],
                dataType: 'json',
                async: true,
                success: function(result) {
                    bootbox.alert("Record deleted Successfully");
                    $('#speriodtbl').DataTable().ajax.reload();
                },
                error: function(jqXHR, textStatus, errorThrown) {
                    bootbox.alert(jqXHR.responseText);
                }
            });
        }

    });
}