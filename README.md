# Setup Development
`docker pull swaggerapi/petstore3:unstable`
`docker run  --name swaggerapi-petstore3 -d -p 8080:8080 swaggerapi/petstore3:unstable`

# API Testing
`mvn clean verify`

# Performance Testing
`k6 run smoke-test.js`

__TODO__ for performance tests
- add checks 