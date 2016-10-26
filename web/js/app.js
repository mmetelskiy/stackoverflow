var ajax = function (options, callback) {
    var xhr = new XMLHttpRequest();
    var body = null;
    var token = localStorage.getItem('token');
    var queryString;

    if (options.json) {
        xhr.setRequestHeader('Content-Type', 'application/json');
        options.json = JSON.stringify(options.json)
    } else if (options.body) {
        body = options.body;
    } else {
        body = null;
    }

    if (options.qs) {
        queryString = Object.getOwnPropertyNames(options.qs)
            .map(function (par) {
                return encodeURIComponent(par) + '=' + encodeURIComponent(options.qs[par]);
            })
            .join('&');
    }

    if (options.headers) {
        for (let header in options.headers) {
            xhr.setRequestHeader(header, options.headers[header]);
        }
    }

    if (token) {
        xhr.setRequestHeader('Authorization', token);
    }

    xhr.open(options.method, options.path + (queryString ? '?' + queryString : ''));
    xhr.send(body);

    xhr.onload = function () {
        var response = xhr.responseText;
        var contentType = xhr.getResponseHeader('Content-Type');

        if (contentType === 'application/json') {
            response = JSON.stringify(response);
        }

        callback(response);
    }
};

var render = (function () {
    var render = {
        questions: _.template(document.getElementById('questions-template').innerHTML),
        question: _.template(document.getElementById('question-template').innerHTML)
    };

    return function (view, options) {
        return document
            .createRange()
            .createContextualFragment(render[view](options));
    };
})();

var switchView = (function () {
    var currentView = null;

    return function (element) {
        if (currentView) {
            currentView.classList.remove('current-view');
        }

        currentView = element;
        currentView.classList.add('current-view');
    };
})();

var clearElement = function (element) {
    while (element.lastChild) {
        element.removeChild(element.lastChild);
    }
}

var showQuestions = (function () {
    var options = {
        method: 'GET',
        path: '/list'
    };
    var questions = document.getElementById('questions');

    return function (query) {
        if (query) {
            options.qs = {
                q: query
            };
        }

//        ajax(options, function (questionsList) {
            let questionsList = [
                {
                    id: 1,
                    header: 'underscore templates',
                    author: 'misha',
                    time: '13.10.2015',
                    answers: 5
                },
                {
                    id: 2,
                    header: 'bash array slice',
                    author: 'misha',
                    time: '21.09.2014',
                    answers: 6
                },
                {
                    id: 3,
                    header: 'java stream to collection',
                    author: 'misha',
                    time: '21.09.2014',
                    answers: 255
                },
                {
                    id: 4,
                    header: 'Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod' +
                        'tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,' +
                        'quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo' +
                        'consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse' +
                        'cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non' +
                        'proident, sunt in culpa qui officia deserunt mollit anim id est laborum.',
                    author: 'misha',
                    time: '21.09.2014',
                    answers: 1234
                }
            ];
            var renderedQuestions = render('questions', {
                questions: questionsList
            });

            clearElement(questions);
            questions.appendChild(renderedQuestions);

            history.pushState({
                name: 'questions',
            }, '', '/questions')

            switchView(questions);
//        });
    };
})();

var showLogin = function () {

};

var showQuestion = (function () {
    var options = {
        method: 'GET'
    };
    var basePath = '/list';
    var questionDiv = document.getElementById('question');

    return function (questionId) {
        // ajax(Object.assign({
        //     path: basePath + '/' + encodeURI(questionId)
        // }, options), function (question) {
            let question = {
                id: questionId
            };
            var renderedQuestion = render('question', {
                question: question
            });

            clearElement(questionDiv);
            questionDiv.appendChild(renderedQuestion);

            history.pushState({
                name: 'question'
            }, '', questionId);

            switchView(questionDiv);
        // });
    };
})();

var showNotFound = function () {

};

var setCurrentState = function () {
    var path = window.location.pathname;

    if (path === '/') {
        showQuestions();
    } else if (path === '/questions') {
        showQuestions();
    } else if (path === '/login') {
        showLogin();
    } else if (path.indexOf('/questions/') === 0) {
        showQuestion();
    } else {
        showNotFound();
    }
};

var initHandlers = function () {
    document.getElementById('questions').addEventListener('click', function (event) {
        if (event.target.tagName === 'H4') {
            showQuestion(event.target.parentNode.id);
        }
    })
};

document.body.onload = function () {
    setCurrentState();
    initHandlers();
};
window.onpopstate = function (e) {
    e.preventDefault();
    setCurrentState();
};
