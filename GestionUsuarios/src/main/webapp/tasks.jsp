<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="bg-light">
        <div class="container py-5">
            <!-- Formulario de tareas -->
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card shadow">
                        <div class="card-header">
                            <h4 class="mb-0">Agregar Nueva Tarea</h4>
                        </div>
                        <div class="card-body">
                            <form id="taskForm" action="TasksServlet" method="GET">
                                <div class="mb-3">
                                    <label for="taskName" class="form-label">Nombre de la tarea</label>
                                    <input type="text" class="form-control" id="taskName" name="taskName" required>
                                </div>
                                <div class="mb-3">
                                    <label for="description" class="form-label">Descripcion</label>
                                    <textarea class="form-control" id="taskDescription" name="taskDescription" rows="3"></textarea>
                                </div>
                                <div class="mb-3">
                                    <label for="status" class="form-label">Estado</label>
                                    <select class="form-select" id="taskState" name="taskState" required>
                                        <option value="Pending">Pending</option>
                                        <option value="In Progress">In Progress</option>
                                        <option value="Canceled">Canceled</option>
                                        <option value="Completed">Completed</option>
                                    </select>
                                </div>
                                <div class="mb-3">
                                    <label for="deadline" class="form-label">Fecha limite</label>
                                    <input type="date" class="form-control" id="limitDate" name="limitDate" required>
                                </div>
                                <div class="d-grid">
                                    <button type="submit" class="btn btn-success">Crear Tarea</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Tabla de tareas -->
            <div class="row justify-content-center mt-5">
                <div class="col-md-10">
                    <div class="card shadow">
                        <div class="card-header bg-secondary text-white">
                            <h5 class="mb-0">Lista de Tareas</h5>
                        </div>
                        <div class="card-body table-responsive">
                            <table class="table table-bordered table-striped align-middle text-center">
                                <thead class="table-dark">
                                    <tr>
                                        <th>Nombre</th>
                                        <th>Descripción</th>
                                        <th>Estado</th>
                                        <th>Fecha creación</th>
                                        <th>Fecha límite</th>
                                        <th>¿Completado?</th>
                                    </tr>
                                </thead>
                                <tbody id="taskTableBody">
                                    <c:forEach var="task" items="${sessionScope.user.getTasksList()}">
                                        <tr>
                                            <td>${task.taskName}</td>
                                            <td>${task.taskDescription}</td>
                                            <td>${task.taskState}</td>
                                            <td>${task.creationDate}</td>
                                            <td>${task.limitDate}</td>
                                            <td>
                                                <input type="checkbox" ${task.isComplete?"checked":""} disabled/>
                                            </td>
                                            <td>
                                                <form id="formulario${task.taskId}" action="TasksServlet" method="POST">
                                                    <input hidden="true" name="taskId" value="${task.taskId}"/>
                                                    <input type="button" value="Eliminar" class ="btn btn-danger btn-sm"
                                                           onclick="acceptDelete(${task.taskId})"/>
                                                </form>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <script>
            function acceptDelete(id){
                if(confirm("¿Estas seguro de que quieres eliminar la tarea?")){
                    document.getElementById("formulario"+id).submit();
                }
            }
        </script>
        <!-- Opcional: Script para manejar tareas localmente -->
        <%--        <script>
                    const taskForm = document.getElementById('taskForm');
                    const taskTableBody = document.getElementById('taskTableBody');

            taskForm.addEventListener('submit', function (e) {
                e.preventDefault();

                const name = document.getElementById('taskName').value;
                const desc = document.getElementById('description').value;
                const status = document.getElementById('status').value;
                const deadline = document.getElementById('deadline').value;
                const createdAt = new Date().toLocaleDateString();

                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${name}</td>
                    <td>${desc}</td>
                    <td>${status}</td>
                    <td>${deadline}</td>
                    <td>${createdAt}</td>
                    <td><input type="checkbox" ${status === "Completed" ? "checked" : ""}></td>
                `;
                taskTableBody.appendChild(row);

                taskForm.reset();
            });
        </script>--%>

    </body>
</html>
