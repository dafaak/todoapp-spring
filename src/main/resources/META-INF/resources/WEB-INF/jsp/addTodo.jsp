<%@ include file="common/header.jspf" %>

<%@ include file="common/navigation.jspf" %>

<div class="container">


    <h2> ADD TODO!</h2>
    <form:form method="post" modelAttribute="todo">

        <fieldset class="mb-3">
            <form:label path="description">Description:</form:label>
            <form:input path="description" type="text" id="description" name="description" required="true"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Targe date:</form:label>
            <form:input path="targetDate" type="text" id="targetDate" name="targetDate" required="true"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input path="done" type="hidden" id="description" name="description" required="true" minlength="5"
                    maxlength="255"/>

        <form:input path="id" type="hidden" id="description" name="description" required="true" minlength="5"
                    maxlength="255"/>


        <input type="submit" class="btn btn-dark" value="ADD">
    </form:form>


</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd',
    });
</script>
