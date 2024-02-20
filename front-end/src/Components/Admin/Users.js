import React, { useEffect, useState } from "react";
import AdminNavbar from "./AdminNavbar";
import UserService from "../../Service/UserService";

function Users() {
  const [user, setuser] = useState([]);
  const fetchData = () => {
    UserService.getAllUsers()
      .then((result) => {
        setuser([...result.data]);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      <AdminNavbar></AdminNavbar>
    <div className="container mt-5">
    

    <table className="table table-striped">
      <thead>
    <tr>
      <th>
        Id
      </th>
        <th>
          Name
        </th>
        <th>
          Mobile
        </th>
        <th>
          Email
        </th>
        <th>
          Role
        </th>
      </tr>
      </thead> 
      <tbody>
      {
        
        user.map(p=>
          <tr key={p.id}>
            <td>{p.id}</td>
          <td>{p.name}</td>
          <td>{p.mobileNo}</td>
          <td>{p.email}</td>
          <td>{p.role}</td>
          </tr>
          )
      }
    
      </tbody>
    </table>
    </div>
    </div>
  );
}

export default Users;
