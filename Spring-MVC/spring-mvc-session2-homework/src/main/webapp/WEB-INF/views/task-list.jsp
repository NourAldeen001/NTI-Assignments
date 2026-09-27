<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
        th { background-color: #007bff; color: white; }
        tr:nth-child(even) { background-color: #f9f9f9; }

        /* Priority Badges */
        .priority-HIGH { color: #dc3545; font-weight: bold; }
        .priority-MEDIUM { color: #ffc107; font-weight: bold; }
        .priority-LOW { color: #28a745; font-weight: bold; }

        /* Status Badges */
        .status-completed { color: #28a745; font-weight: bold; }
        .status-pending { color: #6c757d; }

        .btn { padding: 8px 12px; background-color: #007bff; color: white; text-decoration: none; border-radius: 4px; }
    </style>
</head>
<body>

    <h2>Task List</h2>
    <!-- <a href="task-form.jsp" class="btn">+ Add New Task</a> -->

    <table>
        <thead>
            <tr>
                <th>#</th>
                <th>Title</th>
                <th>Priority</th>
                <th>Completed</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${!tasks.isEmpty()}">
                    <c:forEach var="task" items="${tasks}" varStatus="status">
                        <tr>
                            <td>${status.count}</td>
                            <td><c:out value="${task.title}" /></td>
                            <td class="priority-${task.priority}">
                                <c:out value="${task.priority}" />
                            </td>
                            <td>
                                <c:choose>
                                    <c:when test="${task.completed}">
                                        <span class="status-completed">&#10004; Yes</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="status-pending">&#10008; No</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="4" style="text-align: center;">No tasks found.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>

</body>
</html>