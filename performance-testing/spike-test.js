import http from 'k6/http';
import { sleep } from 'k6';

export const options = {
    stages:[
        {
            duration: '2m',
            target: 100
        },
        {
            duration: '1m',
            target: 0
        }
    ]
}

export default function () {
    http.get('http://localhost:8080/api/v3/pet/findByStatus?status=available')
    sleep(1)
}
