import api from "../utils/api"

//get请求 不能使用请求体传参，只能通过地址栏传参，需要使用params
async function findAll (pageNo = 1, pageSize = 5, params = {}) {
    // console.log("findAll", pageNo, pageSize, params)
    let resp = await api({
        url: "/doctors",
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
        url: `/doctors/${id}`,
        method: "delete",
    });
    return resp;
}
async function save (doctor) {
    let resp = await api({
        url: "/doctors",
        method: "post",
        data: doctor
    })
    return resp;
}
async function update (doctor) {
    let resp = await api({
        url: "/doctors",
        method: "put",
        data: doctor
    })
    return resp;
}
export { findAll, deleteById, save, update }