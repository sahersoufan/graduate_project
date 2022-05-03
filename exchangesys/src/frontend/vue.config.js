// vue.config.js
module.exports = {
    // https://cli.vuejs.org/config/#devserver-proxy
    devServer: {
        port: 3000,
        proxy: {
            '/api': {
                target: 'http://localhost:8080',
                ws: true,
                changeOrigin: true
            }
        }
    },pages: {

        main: {
            entry: './src/main.js',
            template: 'public/index.html',
            filename: 'index.html',
        },
        user: {
            entry: './src/user.js',
            template: 'public/user/home.html',
            filename: 'home.html',
        },
        admin: {
            entry: './src/admin.js',
            template: 'public/admin/dashboard.html',
            filename: 'dashboard.html',
        },
    },

}
