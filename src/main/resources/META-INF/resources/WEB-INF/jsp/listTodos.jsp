<%@ include file="common/header.jspf"%>

<%@ include file="common/navigation.jspf"%>

<div class="container">


    <h2> TODOS!</h2>
    <table class="table">
        <thead>
        <tr>
            <%--            <th>id</th>--%>
            <th>Desc</th>
            <th>Target date</th>
            <th>Is done?</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                    <%--                <td>${todo.id}</td>--%>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td>
                    <a href="delete-todo?id=${todo.id}" class="btn btn-outline-dark">DELETE</a>
                    <a href="update-todo?id=${todo.id}" class="btn btn-outline-dark ">UPDATE</a>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="/add-todo" type="button" class="btn btn-dark"> ADD</a>

</div>

<%@ include file="common/footer.jspf"%>
