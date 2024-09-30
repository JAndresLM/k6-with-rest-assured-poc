import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    stages:[
        {
            duration: '10s',
            target: 1000
        },
        {
            duration: '30s',
            target: 1000
        },
        {
            duration: '10s',
            target: 0
        }
    ]
}

export default function () {
    http.get('http://localhost:8080/api/v3/pet/findByStatus?status=available')
    sleep(1)

    http.get('http://localhost:8080/api/v3/pet/1')
    sleep(2)

    http.get('http://localhost:8080/api/v3/pet/findByTags')
    sleep(2)
}
