import api from "../utils/api"

//get请求 不能使用请求体传参，只能通过地址栏传参，需要使用params
async function findAll (pageNo = 1, pageSize = 5, params = {}) {
    // console.log("findAll", pageNo, pageSize, params)
    let resp = await api({
        url: "/subjects",
        method: "get",
        params: {
            pageNo,
            pageSize,
            ...params,
        }
    })
    return resp
}
async function findSubNames () {
    let resp = await api({
        url: `/subjects/names`,
        method: "get",
    });
    return resp;
}
async function deleteById (id) {
    let resp = await api({
        url: `/subjects/${id}`,
        method: "delete",
    });
    return resp;
}
async function save (subeject) {
    let resp = await api({
        url: "/subjects",
        method: "post",
        data: subeject
    })
    return resp;
}
async function update (subeject) {
    let resp = await api({
        url: "/subjects",
        method: "put",
        data: subeject
    })
    return resp;
}
export { findAll, deleteById, save, update, findSubNames }