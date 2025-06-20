const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootau72407e/",
            name: "springbootau72407e",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootau72407e/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "新能源汽车个性化推荐系统"
        } 
    }
}
export default base
