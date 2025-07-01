<%-- Document : tasks Created on : Jul 1, 2025, 12:42:15 PM Author : manana --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <jsp:include page="header.jsp" />
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Tasks</title>
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/bootswatch/5.3.7/morph/bootstrap.min.css" />
        </head>

        <body>
            <div class="row justify-content-center">
                <div class="col-6 bg-secondary p-4 mb-5">
                    <fieldset>
                        <legend>Welcome <%request.getAttribute("username");%>
                        </legend>
                        <div class="card border-primary mb-3" style="max-width: 20rem;">
                            <div class="card-header">Tasks</div>
                            <div class="card-body">
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">Type</th>
                                            <th scope="col">Column heading</th>
                                            <th scope="col">Column heading</th>
                                            <th scope="col">Column heading</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="table-dark">
                                            <th scope="row">Dark</th>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                            <td>Column content</td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </fieldset>
                </div>
            </div>
        </body>

        </html>