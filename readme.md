# rest-services API

### GET /web/list
#### 200 (application/json)
response: `[]`
#### 500 (application/json)

### GET /web/list/questionId
#### 200 (application/json)
response: `{}`
#### 404 (application/json)
#### 500 (application/json)

### POST /web/list
#### 201 (application/json)
response: `{id:123}`
#### 400 (application/json)
#### 401 (application/json)
#### 403 (application/json)
#### 500 (application/json)

### DELETE /web/list/questionId
#### 200 (application/json)
#### 401 (application/json)
#### 403 (application/json)
#### 404 (application/json)
#### 500 (application/json)

### GET /web/access
Headers: Authorization: Basic fj12D4ksaUn6Jknk7l
#### 200 401 403 500

### PUT /web/rating/up
#### 200 (application/json)
#### 401 (application/json)
#### 403 (application/json)
#### 404 (application/json)
#### 409 (application/json)
#### 500 (application/json)

### PUT /web/rating/down
#### 200 (application/json)
#### 401 (application/json)
#### 403 (application/json)
#### 404 (application/json)
#### 409 (application/json)
#### 500 (application/json)

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
