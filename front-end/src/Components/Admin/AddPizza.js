import AdminNavbar from "./AdminNavbar";
import { useLocation, useNavigate } from "react-router-dom";
import "../Admin/UpdatePizza.css";
import { useEffect, useState } from "react";
import PizzaService from "../../Service/PizzaService";

const  AddPizza=()=>{

const[pizza,setPizza]=useState({pizzaName:"",pizzaPrice:""});
const navigate=useNavigate();
const location=useLocation();




const updatePizza=()=>
    {
        PizzaService.updatePizza(pizza).then((result)=>{
        console.log('Printing pizza data', result.data);
        setPizza({pizzaName:"",pizzaPrice:""});
        navigate('/allpizza');
        }).catch((err)=>{
            console.log("Something went wrong",err);
        })
    }

const handleChange=(event)=>{

    let {name,value}=event.target
    setPizza({...pizza,[name]:value})

}



const element=
<>
<AdminNavbar></AdminNavbar>



<div>
      <div className='registration-out-container '>
        <div className="container registration-in-container col-6" >
        <form action="/allpizza" method="post" className="container registration-form-container"   >
        
          

          <div className="row">
            <div className="col-6">

              <label htmlFor="fName">Pizza Name</label>
              <input type="text" className="form-control" name="pizzaName" id="fName" placeholder="Enter Pizza name" value={pizza.pizzaName} onChange={handleChange} required />

            </div>
          </div>

          {/* sec row*/ }
          <div className="row">
            <div className="col-6">
              <label htmlFor="PizzaPrice">Pizza Price</label>
              <input type="text" className="form-control" name="pizzaPrice" id="PizzaPrice" placeholder="Enter Price" value={pizza.pizzaPrice} onChange={handleChange} />
            </div>
          </div>


          
          {/* Row 5 */}
          <div className="row">
            <div className="col-12">
              <button type="button" className="btn btn-success" onClick={updatePizza}>Update</button>
            </div>
          </div>
        </form>
        </div>
      </div>
    </div>
</>

return element;
}

export default AddPizza;