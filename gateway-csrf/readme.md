### spring security and csrf disabled

curl -X GET http://localhost:8085/product

curl -X POST \
    -H "Content-Type: text/plain" \
    -d "monitor" \
    http://localhost:8085/product

* both GET and POST requests are working

### spring security and csrf enabled

* Login with browser (username: userone, password: userone), Replace the Cookie and X-XSRF-TOKEN values

curl -X GET \
    -H "Cookie: SESSION=5ef95397-1bdc-45df-ace7-b38ee1a72f46" \
    http://localhost:8085/product

curl -X POST \
    -H "Content-Type: text/plain" \
    -H "X-XSRF-TOKEN: 7a9af6da-cd5a-4203-b8f3-7cd527a6749a" \
    -H "Cookie: SESSION=5ef95397-1bdc-45df-ace7-b38ee1a72f46" \
    -d "monitor" \
    http://localhost:8085/product

* The GET request is working
* The POST request is not working giving 403 error with message: "An expected CSRF token cannot be found"