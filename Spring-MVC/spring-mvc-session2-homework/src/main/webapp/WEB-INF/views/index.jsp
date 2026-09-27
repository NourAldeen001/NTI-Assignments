<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Hello</title>
</head>
<body>

<h1>Session 2 Lab -- Part1</h1>

<h2>Task 1 -- Add Endpoint</h2>
<ul>
    <li><a href="/tasks/new"> /tasks/new </a> <span> -- add task </span></li>
</ul>

<h2>Task 2 -- Read Endpoint</h2>
<ul>
    <li><a href="/tasks"> /tasks </a> <span> -- list all</span></li>
    <li><a href="/tasks/1"> /tasks/1 </a> <span> -- one task by id</span></li>
    <li><a href="/tasks/search?priority=HIGH"> /tasks/search?priority=HIGH </a> <span> -- filter</span></li>
</ul>

<h2>Task 5 -- Exception Handling</h2>
<ul>
    <li><a href="/tasks/999"> /tasks/999 </a> <span> -- no such id -> TaskNotFoundException -> @ControllerAdvice </span></li>
</ul>

<h2>Task 6 -- Interceptor vs Filter</h2>

<ul>
    <li><a href="/tasks"> /tasks </a> <span> -- both Filter and Interceptor fire </span></li>
    <li><a href="/nope"> /nope </a> <span> -- only the Filter fires (no handler matched) </span></li>
</ul>

</body>
</html>