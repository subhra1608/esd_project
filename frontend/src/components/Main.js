// import React from "react";
import Table from 'react-bootstrap/Table';
import Dropdown from 'react-bootstrap/Dropdown';
import studentService from '../services/student';
import React,{useEffect, useState} from 'react';

function Main() {
    const submitt=(id)=>{
        window.location.replace(`/specialization/${id}`)
    }
    const click=(id)=>{
        window.location.replace(`/domain/${id}`)
    }
   
  
    const domain=[
        {
            domain_id:1,
            domain_name:"CSE"
        },
        {
            domain_id:3,
            domain_name:"ECE"
        }
    ]
    const specialization=[
        {
            code:"2022-TSCD",
            specialization_name:"ai"
        },
        {
            code:"2022-AIML",
            specialization_name:"nlp"
        },
        {
            code:"2022-NC",
            specialization_name:"ml"
        },
    ]
    const [ data, setData] = useState([])
    useEffect(() => {
      async function fetchData() {
       
          // console.log(pdata)
          const studentData = await studentService.getStudentDetails();
          setData(studentData)
          console.log(studentData)
      }
      fetchData()
    }, [])
    // const data=[
    //     {
    //         "domain_id":1,
    //         "specialization_id":1,
    //         "student_name":"ayush",
    //         "specialization":"ai",
    //         "domain":"mtech cse"
    //     },
    //     {
    //         "domain_id":2,
    //         "specialization_id":2,
    //         "student_name":"yash",
    //         "specialization":"ml",
    //         "domain":"imtech"
    //     },
    //     {
    //         "domain_id":3,
    //         "specialization_id":3,
    //         "student_name":"akshat",
    //         "specialization":"nlp",
    //         "domain":"mtech ece"
    //     },
    // ]
    return(
        <>
        <Dropdown className="m-3">
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        Domain
      </Dropdown.Toggle>

      <Dropdown.Menu>
        {domain.map(d=>{
            return(
        <Dropdown.Item onClick={click.bind(this,d.domain_name)}>{d.domain_name}</Dropdown.Item>
        )})}
      </Dropdown.Menu>
    </Dropdown>
    <Dropdown className="m-3">
      <Dropdown.Toggle variant="success" id="dropdown-basic">
        Specialization
      </Dropdown.Toggle>

      <Dropdown.Menu>
        {specialization.map(s=>{
            return(
        <Dropdown.Item onClick={submitt.bind(this,s.code)}>{s.specialization_name}</Dropdown.Item>
        )})}
      </Dropdown.Menu>
    </Dropdown>
<Table striped bordered hover>
      <thead>
        <tr>
          <th>Student First Name</th>
          <th>Student Last Name</th>

          <th>Roll Number</th>
          <th>Domain</th>
        </tr>
      </thead>
      <tbody>
        {data.map(i=>{
            return(
                <tr>
          <td>{i.first_name}</td>
          <td>{i.last_name}</td>
          <td>{i.roll_number}</td>
          <td>{i.domain}</td>
        </tr>
            )
        })}
        
        
      </tbody>
    </Table>
    
    </>
    )
}
export default Main