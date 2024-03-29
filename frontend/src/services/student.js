import axios from 'axios'

// The API endpoint where bills are located
const studentURL = `http://localhost:8080/project2-1.0-SNAPSHOT/api/students/getall`

// Gets all bills which belong to a user
const getStudentDetails = async () => {
  // Get bills of the given user, using query parameter, ?user={user.studentId}
  const response = await axios.get(studentURL)
//   console.log(response.data)
  
  // The .data field would now contain the bills of the users
  return response.data
}

// Pays the bill which is specified, after paying, the record of the bill is deleted
// So this translates to a delete request from axios to the bill API endpoint at the backend
// const payBill = async (bill) => {
//   const response = await axios.delete(`${billsUrl}/${bill.billId}`)
//   return response.data
// }

const exportObject = { getStudentDetails }

export default exportObject