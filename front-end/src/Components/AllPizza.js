import React, { useEffect, useState } from "react";
import "../style/AllPizza.css";
import PizzaService from "../Service/PizzaService";

function AllPizza() {

  const [pizza,setPizza]=useState([]);
  const fetchData=()=>{
    PizzaService.getAllPizza().then((result)=>{
        setPizza([...result.data]);
        
    }).catch((err)=>{
      console.log(err);
    })
  }
useEffect(() => {
  fetchData();
}, [])


  return (
    <>
    
      <div className="container">

      <div className="col-lg-12 md-12">
            <h2 className="text-center mb-5">Hot Pizza</h2>
          </div>
        <div className="row row-cols-1 row-cols-md-3">
          
        {
            pizza.map(p=>
          <div className="col mb-4">
           
             <div className="card" key={p.id}>
              {/* adding image to public folder and accessing the image path name by popping the location till you get fileName */}
             <img  src={`./images/${p.pizzaImagePath.split('/').pop()}`} className="card-img mx-auto d-block" alt="..." />

           <div className="card-body">
             <h5 className="card-title text-center">{p.pizzaName}</h5>
             <p className="card-text">
               This is a longer card with supporting text below as a natural
               lead-in to additional content. This content is a little bit
               longer.
             </p>
           </div>
           <div className="card-footer d-flex align-items-center justify-content-between">
             <span className="price">₹{p.pizzaPrice} </span>
             <button className="add_to_cart">Add to cart</button>
           </div>
         </div>
          </div>
            )
        }
      </div>
      </div>
    </>
  );
}

export default AllPizza;
