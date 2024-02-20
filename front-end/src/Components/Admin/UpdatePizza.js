import AdminNavbar from "./AdminNavbar";
import {useNavigate, useParams } from "react-router-dom";
import "../Admin/UpdatePizza.css";
import { useEffect, useState } from "react";
import PizzaService from "../../Service/PizzaService";

const  UpdatePizza=()=>{

const[name,setName]=useState('');
const[price,setPrice]=useState('');
//const[id,setId]=useState('');

const navigate=useNavigate();
const {id}=useParams();
//const params=useParams();




const updatePizza=(e)=>
    { 
      e.preventDefault();
      const pizza={id,name,price};
        PizzaService.updatePizza(pizza).then((result)=>{
        console.log('Printing pizza data', result.data);
        
        navigate('/');
        }).catch((err)=>{
            console.log("Something went wrong",err);
        })
    }

useEffect(() => {
  if (id) {
    PizzaService
      .getById(id)
      .then((pizza) => {
        setName(pizza.data.name);
        setPrice(pizza.data.price);
      })
      .catch((error) => {
        console.log('Something went wrong', error);
      });
  }
}, []);


const element=
<>
<AdminNavbar></AdminNavbar>



<div>
      <div className='registration-out-container '>
        <div className="container registration-in-container col-6" >
        <form action="/" method="post" className="container registration-form-container"   >
        
          {/* Row 1 */}


          <div className="row">
            <div className="col-6">

              <label htmlFor="id">Pizza Id</label>
              <input type="text" className="form-control" name="id" id="id"  value={id} readOnly />

            </div>
          </div>    

          <div className="row">
            <div className="col-6">

              <label htmlFor="fName">Pizza Name</label>
              <input type="text" className="form-control" name="pizzaName" id="fName" placeholder="Enter Pizza name" value={name} onChange={(e) => setName(e.target.value)} required />

            </div>
          </div>

          {/* sec row*/ }
          <div className="row">
            <div className="col-6">
              <label htmlFor="PizzaPrice">Pizza Price</label>
              <input type="text" className="form-control" name="pizzaPrice" id="PizzaPrice" placeholder="Enter Price" value={price} onChange={(e) => setPrice(e.target.value)} />
            </div>
          </div>


          
          {/* Row 5 */}
          <div className="row">
            <div className="col-12">
              <button type="button" className="btn btn-success" onClick={(e) => updatePizza(e)}>Update</button>
            </div>
          </div>
        </form>
        </div>
      </div>
    </div>
</>

return element;
}

export default UpdatePizza;