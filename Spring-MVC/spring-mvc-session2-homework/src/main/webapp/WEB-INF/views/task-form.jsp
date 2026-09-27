<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Task</title>
    <style>
        .form-group { margin-bottom: 15px; }
        label { display: block; font-weight: bold; margin-bottom: 5px; }
        input[type="text"], select { width: 300px; padding: 8px; }
        .checkbox-label { display: inline; font-weight: normal; }
        button { padding: 8px 16px; background-color: #007bff; color: white; border: none; cursor: pointer; }
    </style>
</head>
<body>

<h1>Add Task</h1>

<form action="/tasks" method="post">
    
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required placeholder="Enter task title" />
        </div>

        <div class="form-group">
            <label for="priority">Priority:</label>
            <select id="priority" name="priority" required>
                <option value="LOW">Low</option>
                <option value="MEDIUM" selected>Medium</option>
                <option value="HIGH">High</option>
            </select>
        </div>

        <div class="form-group">
            <label class="checkbox-label">
                <input type="checkbox" id="completed" name="completed" value="false" />
                Mark as Completed
            </label>
        </div>

        <button type="submit">Save Task</button>
</form>

</body>
</html>