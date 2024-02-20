import AdminNavbar from './AdminNavbar';
import { useState,useEffect } from 'react';
import PizzaService from '../../Service/PizzaService';
import { Link } from 'react-router-dom';

const  GetAllPizza=()=>{

    const[pizza,setPizza] = useState([]);

    const deletePizza=(id)=>{
        PizzaService.deletePizza(id).then((result)=>{
            console.log(result);
            
           init();
          
        }).catch((err)=>{
            console.log(err);
        })
    }

    const init=()=>
    {
        PizzaService.getAllPizza().then((result)=>{
        console.log('Printing pizza data', result.data);
        setPizza(result.data);
        }).catch((err)=>{
            console.log("Something went wrong",err);
        })
    }


    
    useEffect(() => {
      init();
    },[])

    const element=
    <>
     <AdminNavbar></AdminNavbar>
    
        <div className="container mt-5">
        <h3 style={{"textAlign":"center"}}>Pizza</h3>

       

        <div className="row">
            <div className="row row-cols-1 row-cols-md-3" >
            {
        
            pizza.map(p=>
                   
                        <div className="card" key={p.id}>
                            {/* adding image to public folder and accessing the image path name by popping the location till you get fileName */}
                             <img  src={`./images/${p.pizzaImagePath.split('/').pop()}`}  className="card-img mx-auto d-block" alt="..." />

                            <div className="card-body">
                                <h5 className="card-title text-center">{p.pizzaName}</h5>
                            
                                <ul style={{"listStyle":"none"}}>

                                    <li><span style={{"color":"red","fontWeight":"bold"}}>pizza 
                                    Id: </span>{p.id}</li>
                                    <li><span style={{"color":"red","fontWeight":"bold"}}>pizza 
                                    Name: </span>{p.pizzaName}</li>
                                    <li> <span style={{"color":"red","fontWeight":"bold"}}>Pizza Price: </span> {p.pizzaPrice}</li>
                                    
                                </ul>


                             </div>
                             &ensp;&ensp;&ensp;&ensp;

                             <div className="card-footer" >
                            <Link to={`/updatepizza/${p.id}`} >
                             <button type='button' className='btn btn-success' >
                             Update Pizza</button>
                             </Link>

                                &ensp;
                                
                                <button type='button' className='btn btn-danger'  onClick={()=>{deletePizza(p.id)}}>Delete Pizza </button>

                               &ensp;
                                <button type='button' className='btn btn-success' >Update Image </button>
                            </div>
                        </div>  
                        
                    )
            }
            </div>
            
        </div>
  
    </div>
    

    </>
    return element;
}

export default GetAllPizza