# nginx config
    http {
        server {
            listen 8080;

            root /media/Data/Универ/КБ/repository/web;
            index index.html;

            location / {
                try_files $uri /index.html;
            }

            location = /index.html {
                expires 30s;
            }

            location /rest-services {
                proxy_pass http://localhost:8082/web;
            }
        }
    }

# api

## rest-services

### GET /web/list
* 200
* 500

### GET /web/list/questionId
* 200
* 404
* 500

### POST /web/list
* 201
* 400
* 401
* 403
* 500

### DELETE /web/list/questionId
* 200
* 401
* 403
* 404
* 500

### PUT /web/rating/up
* 200
* 401
* 403
* 404
* 409
* 500

### PUT /web/rating/down
* 200
* 401
* 403
* 404
* 409
* 500
