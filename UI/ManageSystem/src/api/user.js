import request from '@/request'

export function login(account, password){
    const data = {
        username: account,
        password
    }
    return request({
        url: '/user/login',
        method: 'get',
        headers: {
            'Content-Type': 'application/json'
        },
        params: data,
    })
}