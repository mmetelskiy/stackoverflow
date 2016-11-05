<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page session="true"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>StackOverflow</title>
    <link rel="stylesheet" type="text/css" href="/resources/style/main.css">
</head>
<body>
    <header>
        <div class="center-content">

        </div>
    </header>
    <main class="center-content">
        <ul id="pages">
            <li class="page" id="questions"></li>
            <li class="page" id="question"></li>
            <li class="page" id="login"></li>
        </ul>
    </main>
    <footer>
        <div class="center-content">

        </div>
    </footer>
    <script type="text/javascript" src="http://underscorejs.org/underscore-min.js"></script>
    <template id="questions-template" type="text/template">
        <ul>
            <% _.each(questions, function (question) { %>
                <li id="<%= question.id %>" class="question">
                    <div class="answers-num"><%= question.answers %></div>
                    <h4><%= question.header %></h4>
                    <div class="right-left">
                        <span class="question-author"><%= question.author %></span>
                        <time><%= question.time %></time>
                    </div>
                </li>
            <% }) %>
        </ul>
    </template>
    <script type="text/javascript" src="/resources/js/app.js"></script>
</body>
</html>
