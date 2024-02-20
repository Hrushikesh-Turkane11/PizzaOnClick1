import React, { useEffect, useState } from 'react'
import PaymentService from '../../Service/PaymentService';
import AdminNavbar from './AdminNavbar';

function Payment() {
    

    const [payment,setpayment]=useState([]);
    const fetchData=()=>{
        PaymentService.getAllPayments().then((result)=>{
            setpayment([...result.data]);
        }).catch((err)=>{
            console.log(err);
        })
    }
    
    useEffect(() => {
      fetchData();
    }, [])
    
    const getDelivery=(id)=>{
        
    }

    return (
        
    <>
    <AdminNavbar></AdminNavbar>
    <div className="container mt-5">
        <h3 style={{"textAlign":"center"}}>Payments</h3>
        <div className="row">
            <div className="col-md-4">
                {
        
                payment.map(p=>
                <div className="card" key={p.id}>
                        <div className="card-body">
                            <ul style={{"listStyle":"none"}}>
                                <li><span style={{"color":"red","fontWeight":"bold"}}>User Name: </span>{p.user.name}</li>
                                <li> <span style={{"color":"red","fontWeight":"bold"}}>Amount paid: </span> {p.amount}</li>
                                <li> <span style={{"color":"red","fontWeight":"bold"}}>Payment Date: </span>{p.paymentDate}</li>
                                <li> <span style={{"color":"red","fontWeight":"bold"}}>Order Date: </span>{p.order.orderDate}</li>
                                <li> <span style={{"color":"red","fontWeight":"bold"}}>Delivery Date: </span>{p.order.deliveryDate}</li>
                                <li> <span style={{"color":"red","fontWeight":"bold"}}>Ordered Items are:</span> </li>
                            </ul>

                        </div>
                <div className="card-footer">
                    <button type='button' className='btn btn-success' onClick={getDelivery(p.id)}>Add to Delivery</button>
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

export default Payment