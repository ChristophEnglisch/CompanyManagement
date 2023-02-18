import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/personalInformation',
      name: 'personalInformation',
    component: () => import('../person/PersonalInformationView.vue')
  },
  {
      path: '/application',
      name: 'candidateApplication',
      component: () => import('../views/CandidateApplicationView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
