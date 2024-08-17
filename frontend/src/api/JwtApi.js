import api from "../utils/api"

const JWT_KEY = "@jwt_key"
function save (jwt) {
  sessionStorage.setItem(JWT_KEY, jwt)
}
function get () {
  return sessionStorage.getItem(JWT_KEY)
}
function clear () {
  sessionStorage.removeItem(JWT_KEY)
}
export { save, get, clear }