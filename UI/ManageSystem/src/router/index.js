import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

const router = new Router({
    routes: [
        {
          path: '/',
          name: 'login',
          component: () => import('../views/Login.vue'),
        },
        {
            path: '/manage',
            component: () => import('../views/BackManage.vue'),
            redirect: '/manage/dataview',
            children: [
                {
                    path: '/manage/dataview',
                    component: () => import('../components/manage/DataView.vue')
                },
                {
                    path: '/manage/userDataview',
                    component: () => import('../components/manage/UserDataView.vue')
                },
                {
                    path: '/manage/userListView',
                    component: () => import('../components/manage/UserListView.vue')
                },
            ]
        },
    ]
})

export default router