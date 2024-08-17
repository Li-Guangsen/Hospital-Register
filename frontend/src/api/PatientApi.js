import api from "../utils/api"

//get请求 不能使用请求体传参，只能通过地址栏传参，需要使用params
async function findAll (pageNo = 1, pageSize = 5, params = {}) {
    // console.log("findAll", pageNo, pageSize, params)
    let p = Object.assign({}, params)
    let birthFrom, birthTo
    if (Array.isArray(p.birthRange)) {
        if (p.birthRange.length > 0) {
            birthFrom = p.birthRange[0]
            birthTo = p.birthRange[1]
        }
        delete p.birthRange;
    }
    let resp = await api({
        url: "/patients",
        method: "get",
        params: {
            pageNo,
            pageSize,
            ...p,
            birthFrom,
            birthTo
        }
    })
    return resp
}
async function deleteById (id) {
    let resp = await api({
        url: `/patients/${id}`,
        method: "delete",
    });
    return resp;
}
async function save (patient) {
    let resp = await api({
        url: "/patients",
        method: "post",
        data: patient
    })
    return resp;
}
async function update (patient) {
    let resp = await api({
        url: "/patients",
        method: "put",
        data: patient
    })
    return resp;
}
async function apiUpdatePass (patient) {
    let resp = await api({
        url: "/patients/password",
        method: "put",
        data: patient
    })
    return resp;
}
export { findAll, deleteById, save, update, apiUpdatePass }