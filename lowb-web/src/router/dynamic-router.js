
/* 需要权限判断的路由 */
const dynamicRoutes = [
  {
    path: '/user-manage',
    component: () => import('../pages/user-manage'),
    name: 'user-manage',
    meta: {
      name: '用户管理',
      icon: 'el-icon-s-check'
    },
    children: [
      {
        path: 'hr-manage',
        component: () => import('../pages/user-manage/hr-manage'),
        name: 'hr-manage',
        meta: {
          name: 'HR管理',
          icon: 'el-icon-user-solid'
        }
      }
    ]
  }
  // {
  //   path: '/user-manage',
  //   component: () => import('../pages/user-manage'),
  //   name: 'user-manage',
  //   meta: {
  //     name: '用户管理',
  //     icon: 'el-icon-s-check'
  //   },
  //   children: [
  //     {
  //       path: 'teacher-manage',
  //       name: 'teacher-manage',
  //       component: () => import('../pages/user-manage/teacher-manage/index.vue'),
  //       meta: {
  //         name: '老师管理',
  //         icon: 'el-icon-s-custom'
  //       }
  //     },
  //     {
  //       path: 'student-manage',
  //       name: 'student-manage',
  //       component: () => import('../pages/user-manage/student-manage/index.vue'),
  //       meta: {
  //         name: "学生管理",
  //         icon: "el-icon-user-solid"
  //       }
  //     },
  //     {
  //       path: 'sysUser-manage',
  //       name: 'sysUser-manage',
  //       component: () => import('../pages/user-manage/user-manage/index.vue'),
  //       meta: {
  //         name: "系统用户管理",
  //         icon: "el-icon-user-solid"
  //       }
  //     }
  //   ]
  // }
]

export default dynamicRoutes
