<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Task Details</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 30px; background-color: #f4f6f9; }
        .card { background: white; max-width: 500px; padding: 25px; border-radius: 8px; box-shadow: 0 2px 8px rgba(0,0,0,0.1); }
        .detail-row { display: flex; justify-content: space-between; padding: 12px 0; border-bottom: 1px solid #eee; }
        .detail-row:last-child { border-bottom: none; }
        .label { font-weight: bold; color: #555; }

        /* Badges */
        .badge { padding: 4px 10px; border-radius: 12px; font-weight: bold; font-size: 0.9em; }
        .priority-HIGH { background-color: #f8d7da; color: #721c24; }
        .priority-MEDIUM { background-color: #fff3cd; color: #856404; }
        .priority-LOW { background-color: #d4edda; color: #155724; }

        .status-completed { color: #28a745; font-weight: bold; }
        .status-pending { color: #dc3545; font-weight: bold; }
    </style>
</head>
<body>

<div class="card">
        <h2>Task Details</h2>

        <div class="detail-row">
            <span class="label">Task ID:</span>
            <span>#<c:out value="${task.id}" /></span>
        </div>

        <div class="detail-row">
            <span class="label">Title:</span>
            <span><c:out value="${task.title}" /></span>
        </div>

        <div class="detail-row">
            <span class="label">Priority:</span>
            <span class="badge priority-${task.priority}">
                <c:out value="${task.priority}" />
            </span>
        </div>

        <div class="detail-row">
            <span class="label">Status:</span>
            <span>
                <c:choose>
                    <c:when test="${task.completed}">
                        <span class="status-completed">&#10004; Completed</span>
                    </c:when>
                    <c:otherwise>
                        <span class="status-pending">&#10008; Pending</span>
                    </c:otherwise>
                </c:choose>
            </span>
        </div>

</body>
</html>