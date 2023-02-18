import {createApp} from 'vue'
import {createPinia} from 'pinia'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify'
import {loadFonts} from './plugins/webfontloader'
import mitt from "mitt";

const emitter = mitt();

loadFonts()

const app = createApp(App)
    .use(vuetify)
    .use(createPinia())
    .use(router)

app.config.globalProperties.emitter = emitter;

app.mount('#app')