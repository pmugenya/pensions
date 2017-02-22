<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript">

    var schemeId = ${schemeId};
</script>
<script type="text/javascript" src="<c:url value="/js/modules/utils/select2builder.js"/>"></script>
<script type="text/javascript" src="<c:url value="/libs/rivets/rivets.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/modules/schemes/schemedef.js"/>"></script>

<form class="form-horizontal" id="scheme-form">
    <input type="hidden" name="schemeId" id="scheme-pk">
    <div class="spacer"></div>
    <input type="button"  class="btn btn-info" id="save-scheme-btn" value="Save and New" >
    <a href="<c:url value="/protected/setups/schemes/schemedef"/>" class="btn btn-info">Cancel</a>
    <hr>
<div class="box box-info">
    <div class="box-header with-border">
        <h3 class="box-title">Scheme Basic Information</h3>
    </div>
    <div class="box-body">
        <div class="form-group form-required">
            <div class="col-md-6">
                <label for="scheme-id" class="control-label col-md-5">Scheme ID</label>
                <div class="col-md-7">
                    <input type="text" id="scheme-id" name="schemeShtDesc" class="form-control" placeholder="Scheme ID" required>
                </div>
            </div>
            <div class="col-md-6">
                <label for="scheme-name" class="control-label col-md-5">Scheme Name</label>
                <div class="col-md-7">
                    <input type="text" id="scheme-name" name="schemeName" class="form-control" placeholder="Scheme Name" required>
                </div>
            </div>
        </div>
        <div class="form-group form-required">
            <div class="col-md-6">
                <label for="scheme-type" class="control-label col-md-5">Scheme Type</label>
                <div class="col-md-7">
                    <select class="form-control" id="scheme-type" name="schemeType" required>
                        <option value="">Select Type</option>
                        <option value="DC">Define Contribution</option>
                        <option value="DB">Define Benefit</option>
                        <option value="HB">Hybrid</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <label for="scheme-category" class="control-label col-md-5">Scheme Category</label>
                <div class="col-md-7">
                    <select class="form-control" id="scheme-category" name="schemeCategory" required>
                        <option value="">Select Category</option>
                        <option value="PEF">Pension Fund</option>
                        <option value="PRF">Provident Fund</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-group form-required">
            <div class="col-md-6">
                <label for="scheme-level-admin" class="control-label col-md-5">Scheme Level of Admin</label>
                <div class="col-md-7">
                    <select class="form-control" id="scheme-level-admin" name="schemeLevelAdmin" required>
                        <option value="">Select Level of Admin</option>
                        <option value="I">Individual Member</option>
                        <option value="G">Group</option>
                    </select>
                </div>
            </div>
            <div class="col-md-6">
                <label for="schema-sect-name" class="control-label col-md-5">Sector</label>
                <div class="col-md-7">
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
        <div class="form-group form-required">
            <div class="col-md-6">
                <label for="scheme-comm-date" class="control-label col-md-5">Commencement Date</label>
                <div class="col-md-7">
                    <div class='input-group date datepicker-input'>
                        <input type='text' class="form-control" name="commenceDate" id="scheme-comm-date"  required/>
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <label for="scheme-reg-date" class="control-label col-md-5">Registration Date</label>
                <div class="col-md-7">
                    <div class='input-group date datepicker-input'>
                        <input type='text' class="form-control" name="regDate" id="scheme-reg-date"  required/>
				                    <span class="input-group-addon">
				                        <span class="glyphicon glyphicon-calendar"></span>
				                    </span>
                    </div>
                </div>
            </div>
        </div>
        <div class="form-group form-required">
            <div class="col-md-6">
                <label for="scheme-id" class="control-label col-md-5">TIN</label>
                <div class="col-md-7">
                    <input type="text" id="scheme-tin" name="tin" class="form-control" placeholder="Scheme TIN">
                </div>
            </div>
            <div class="col-md-6">

            </div>
        </div>
</div>
</div>
    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">Scheme Additional Information</h3>
        </div>
        <div class="box-body">
            <div class="form-group form-required">
                <div class="col-md-6">
                    <label for="scheme-min-join-age" class="control-label col-md-5">Minimum Joining Age</label>
                    <div class="col-md-7">
                        <input type="number" id="scheme-min-join-age" name="minJoinAge" class="form-control" placeholder="Scheme Min Join Age">
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="scheme-max-join-age" class="control-label col-md-5">Maximum Joining Age</label>
                    <div class="col-md-7">
                        <input type="number" id="scheme-max-join-age" name="maxJoinAge" class="form-control" placeholder="Scheme Max Join Age">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <label for="scheme-service-mode" class="control-label col-md-5">Pensionable Service Mode</label>
                    <div class="col-md-7">
                        <select class="form-control" id="scheme-service-mode" name="serviceMode">
                            <option value="">Select Service Mode</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">

                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6 form-required">
                    <label for="scheme-retire-age" class="control-label col-md-5">Normal Retirement Age</label>
                    <div class="col-md-7">
                        <input type="number" id="scheme-retire-age" name="retirementAge" class="form-control" placeholder="Normal Retirement Age" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <label class="control-label col-md-5">Has Life Cover?</label>
                    <div class="col-md-7 checkbox">

                        <label>
                            <input type="checkbox" name="lifeInsuranceCover" id="life-check">
                        </label>

                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <label for="scheme-level-of-cover" class="control-label col-md-5">Level of Cover</label>
                    <div class="col-md-7">
                        <select class="form-control" id="scheme-level-of-cover" name="levelOfCover">
                            <option value="">Select Level of Cover</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="scheme-def-account" class="control-label col-md-5">Surplus/Deficit Account</label>
                    <div class="col-md-7">
                        <select class="form-control" id="scheme-def-account" name="serviceMode">
                            <option value="">Select Account</option>
                        </select>
                    </div>
                </div>
            </div>
            </div>
        </div>

    <div class="box box-info">
        <div class="box-header with-border">
            <h3 class="box-title">Contacts and Additional Information</h3>
        </div>
        <div class="box-body">
            <div class="form-group">
                <div class="col-md-6">
                    <label for="scheme-contrib-remmit" class="control-label col-md-5">Contrib. Remmitance Mode</label>
                    <div class="col-md-7">
                        <select class="form-control" id="scheme-contrib-remmit" name="remmittanceMode">
                            <option value="">Select Remmittance Mode</option>
                            <option value="AD">Advance</option>
                            <option value="AR">Arrears</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="scheme-contrib-freq" class="control-label col-md-5">Contrib. Frequency</label>
                    <div class="col-md-7">
                        <select class="form-control" id="scheme-contrib-freq" name="contribFrequence">
                            <option value="">Select Frequency</option>
                            <option value="M">Monthly</option>
                            <option value="Q">Quarterly</option>
                            <option value="SA">Semi-Annually</option>
                            <option value="A">Annually</option>
                            <option value="SI">Single</option>
                            <option value="D">Daily</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <label for="scheme-movement-interest" class="control-label col-md-5">Movement Appl.Interest</label>
                    <div class="col-md-7">
                        <select class="form-control" id="scheme-movement-interest" name="interestRate">
                            <option value="">Select</option>
                            <option value="I">Interim</option>
                            <option value="D">Declared</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-6">

                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <label class="control-label col-md-5">Based on Contri. Date?</label>
                    <div class="col-md-7 checkbox">

                        <label>
                            <input type="checkbox" name="calcInterestBasedOnDate" id="calc-interest">
                        </label>

                    </div>
                </div>
                <div class="col-md-6">
                    <label for="scheme-contr-due-dt" class="control-label col-md-5">Contr. Due Date(dd)</label>
                    <div class="col-md-7">
                        <input type="number" id="scheme-contr-due-dt" name="contrDueDate" class="form-control" placeholder="Contrib. Due Date">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <label class="control-label col-md-5">Is Umbrella Scheme?</label>
                    <div class="col-md-7 checkbox">

                        <label>
                            <input type="checkbox" name="umbrellaSchema" id="umbr-scheme">
                        </label>

                    </div>
                </div>
                <div class="col-md-6">
                    <label class="control-label col-md-5">Benef. is Pensionable?</label>
                    <div class="col-md-7 checkbox">

                        <label>
                            <input type="checkbox" name="pensionableBenef" id="pension-scheme">
                        </label>

                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <label class="control-label col-md-5">Belongs to Umbrella?</label>
                    <div class="col-md-7 checkbox">

                        <label>
                            <input type="checkbox" name="belongsSchema" id="belong-scheme">
                        </label>

                    </div>
                </div>
                <div class="col-md-6">
                    <label for="scheme-umbr-scheme" class="control-label col-md-5">Umbrella Scheme</label>
                    <div class="col-md-7">
                        <div id="scheme-umbr-scheme" class="form-control"
                             select2-url="<c:url value="/protected/setups/schemes/selSchemes"/>" >
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <label for="scheme-country" class="control-label col-md-5">Country</label>
                    <div class="col-md-7">
                        <div id="scheme-country" class="form-control"
                             select2-url="<c:url value="/protected/organization/countries"/>" >

                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="scheme-postal-addr" class="control-label col-md-5">Postal Address</label>
                    <div class="col-md-7">
                        <input type="text" id="scheme-postal-addr" name="postalAddress" class="form-control" placeholder="Postal Address">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <label for="scheme-town" class="control-label col-md-5">Town</label>
                    <div class="col-md-7">
                        <div id="scheme-town" class="form-control"
                             select2-url="<c:url value="/protected/setups/schemes/selTowns"/>" >
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <label for="scheme-email-addr" class="control-label col-md-5">Email Address</label>
                    <div class="col-md-7">
                        <input type="email" id="scheme-email-addr" name="email" class="form-control" placeholder="Email Address">
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>