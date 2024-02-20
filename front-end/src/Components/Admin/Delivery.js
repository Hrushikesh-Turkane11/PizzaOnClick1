import React, { useEffect, useState } from 'react'
import DeliveryService from '../../Service/DeliveryService'
import AdminNavbar from './AdminNavbar';

function Delivery() {

    const [delivery,setdelivery]=useState([]);

    const fetchData =()=>{
        DeliveryService.getAllDelivery().then((result)=>{
            setdelivery([...result.data]);
        }).catch((err)=>{
            console.log(err);
        })
    }

    useEffect(() => {
      fetchData();
    }, [])
    
  return (
    <>
    <AdminNavbar></AdminNavbar>
    <div className="container mt-5">
        <h3 style={{"textAlign":"center"}}>Pizzas deliverd </h3>
<div className="row">
     <div className="col-md-4">
  {
     
     delivery.map(p=>
        <div className="card" key={p.id}>
            <div className="card-body">
            <ul style={{"listStyle":"none"}}>
                 <li> <span style={{"color": "red","fontWeight": "bold"}}> Deliverd By: </span> {p.deliveredBy}</li>
                <li> <span style={{"color": "red","fontWeight": "bold"}}> Delivery Time: </span>  {p.deliveryTime}</li>
                <li> <span style={{"color": "red","fontWeight": "bold"}}> Delivery Status: </span> {p.deliveryStatus}</li>
                <li> <span style={{"color": "red","fontWeight": "bold"}}> Amount Paid: </span>  {p.payment.amount}</li>
                <li> <span style={{"color": "red","fontWeight": "bold"}}> User: </span> {p.payment.user.name}</li>
                <li> <span style={{"color": "red","fontWeight": "bold"}}>Ordered Items are: </span> </li>
            </ul>
            
            
            
            </div>
          
        </div>
     )
    
  }
    </div>
 </div>
  
  </div>
  </>
  )
}

export default Delivery