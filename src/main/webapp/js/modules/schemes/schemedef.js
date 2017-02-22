/**
 * Created by Peter on 1/26/2017.
 */
$(function() {

    $(document).ready(function () {
        createSchemeTable();
        createSchemeLov();
        createCountryLov();
        createTownLov();
        createSectorlov();
        saveSchemaDetails();
        querySchemeDetails();


        $(".datepicker-input").each(function() {
            $(this).datetimepicker({
                format: 'DD/MM/YYYY'
            });

        });

    })
});

function querySchemeDetails() {

    if (typeof schemeId !== 'undefined') {
        if (schemeId !== -2000) {
            $.ajax( {
                url: 'getSchemeDetails/'+schemeId,
                type: 'GET',
                processData: false,
                contentType: false,
                success: function (s ) {
                    console.log(s);
                    $("#scheme-pk").val(s.schemeId);
                    $("#scheme-id").val(s.schemeShtDesc);
                    $("#scheme-name").val(s.schemeName);
                    $("#scheme-type").val(s.schemeType);
                    $("#scheme-category").val(s.schemeCategory);
                    $("#scheme-level-admin").val(s.schemeLevelAdmin);
                    $("#schema-sect-name").val(s.sector.sectorName);
                    $("#schema-sect-code").val(s.sector.sectorId);
                    createSectorlov();
                    $("#scheme-comm-date").val( moment(s.commenceDate).format('DD/MM/YYYY'));
                    $("#scheme-reg-date").val(moment(s.regDate).format('DD/MM/YYYY'));
                    $("#scheme-tin").val(s.tin);
                    $("#scheme-min-join-age").val(s.minJoinAge);
                    $("#scheme-max-join-age").val(s.maxJoinAge);
                    $("#scheme-service-mode").val(s.serviceMode);
                    $("#scheme-retire-age").val(s.retirementAge);
                    $("#life-check").prop("checked", s.lifeInsuranceCover);
                    $("#scheme-level-of-cover").val(s.levelOfCover);
                    $("#scheme-contrib-remmit").val(s.remmittanceMode);
                    $("#scheme-contrib-freq").val(s.contribFrequence);
                    $("#scheme-movement-interest").val(s.interestRate);
                    $("#calc-interest").prop("checked", s.calcInterestBasedOnDate);
                    $("#scheme-contr-due-dt").val(s.contrDueDate);
                    $("#umbr-scheme").prop("checked", s.umbrellaSchema);
                    $("#pension-scheme").prop("checked", s.pensionableBenef);
                    $("#belong-scheme").prop("checked", s.belongsSchema);
                    $("#scheme-postal-addr").val(s.postalAddress);
                    $("#scheme-email-addr").val(s.email);

                },
                error: function(xhr, error){
                    bootbox.alert(xhr.responseText);
                }
            });

        }
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

function createSchemeLov(){
    if($("#scheme-umbr-scheme").filter("div").html() != undefined)
    {
        Select2Builder.initAjaxSelect2({
            containerId : "scheme-umbr-scheme",
            sort : 'schemeName',
            change: function(e, a, v) {

            },
            formatResult : function(a)
            {
                return a.schemeName
            },
            formatSelection : function(a)
            {
                return a.schemeName
            },
            initSelection: function (element, callback) {
                //var countryCode = $("#countryCode").val();
                //var countryName = $("#countryName").val();
                //model.organization.country.couCode = countryCode;
                //model.organization.country.county.countyId = -2000;
                //var data = {couName:countryName,couCode:countryCode};
                //callback(data);
            },
            id: "schemeId",
            width:"200px"
        });
    }
}


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

function createSectorlov(){
    if($("#sector").filter("div").html() != undefined)
    {
        Select2Builder.initAjaxSelect2({
            containerId : "sector",
            sort : 'sectorName',
            change:  function(e, a, v) {
                $("#schema-sect-name").val(e.added.sectorName);
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
                var code = $("#schema-sect-code").val();
                var name = $("#schema-sect-name").val();
                var data = {sectorName:name,sectorId:code};
                callback(data);
            },
            id: "sectorId",
            width:"200px"
        });
    }
}


function createSchemeTable(){
    var url = "schemeList";
    var tbl = $('#schemesTbl').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": url,
        lengthMenu: [ [ 10, 20,30], [10,20,30] ],
        pageLength: 10,
        destroy: true,
        "columns": [
            { "data": "schemeShtDesc" },
            { "data": "schemeName" },
            { "data": "schemeCategory" },
            { "data": "sector",
                "render": function ( data, type, full, meta ) {
                    if(full.sector)
                        return full.sector.sectorName;
                    else{
                        return "";
                    }
                }
            },
            { "data": "commenceDate",
                "render": function ( data, type, full, meta ) {

                        return  moment(full.commenceDate).format('DD/MM/YYYY');

                }
            },
            {
                "data": "schemeId",
                "render": function ( data, type, full, meta ) {

                    return '<form action="editScheme" method="post"><input type="hidden" name="schemeId" value='+full.schemeId+'><input type="submit"  class="hyperlink-btn" value="View" ></form>';;

                }

            },
            {
                "data": "schemeId",
                "render": function ( data, type, full, meta ) {

                        return '<input type="button" class="hyperlink-btn" data-branch='+encodeURI(JSON.stringify(full)) + ' value="Delete" onclick="confirmBranchDelete(this);"/>';



                }

            },
        ]
    } );
    return tbl;
}


function saveSchemaDetails(){
    var $schemeForm = $('#scheme-form');
    var validator = $schemeForm.validate();
    $('#save-scheme-btn').click(function(){
        if (!$schemeForm.valid()) {
            return;
        }
        var $btn = $(this).button('Saving');
        var data = {};
        $schemeForm.serializeArray().map(function(x){data[x.name] = x.value;});
        var url = "createNewScheme";
        var request = $.post(url, data );
        request.success(function(){
            bootbox.alert("Scheme created/updated Successfully");
            $('#scheme-form').find("input[type=text],input[type=mobileNumber],input[type=emailFull],input[type=password],input[type=hidden],input[type=number], textarea,select").val("");
            validator.resetForm();
        });
        request.error(function(jqXHR, textStatus, errorThrown){
            bootbox.alert(jqXHR.responseText);
        });
        request.always(function(){
            $btn.button('reset');
        });
    });

}