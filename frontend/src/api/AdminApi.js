import api from "../utils/api"
//get请求 不能使用请求体传参，只能通过地址栏传参，需要使用params
async function findAll (pageNo = 1, pageSize = 5, params = {}) {
    // console.log("findAll", pageNo, pageSize, params)
    let resp = await api({
        url: "/users",
        method: "get",
        params: {
            pageNo,
            pageSize,
            ...params,
        }
    })
    return resp
}
async function deleteById (id) {
    let resp = await api({
        url: `/users/${id}`,
        method: "delete",
    });
    return resp;
}
async function save (adm) {
    let resp = await api({
        url: "/users",
        method: "post",
        data: adm
    })
    return resp;
}
async function update (adm) {
    let resp = await api({
        url: "/users",
        method: "put",
        data: adm
    })
    return resp;
}
export { findAll, deleteById, save, update }