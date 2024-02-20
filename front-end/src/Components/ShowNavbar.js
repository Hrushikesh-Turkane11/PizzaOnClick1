import React, { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";

function ShowNavbar({ children }) {
  
    const [showNavBar,setShowNavbar]=useState(false);
    const[pizza,setPizza] = useState(true);

    // useLocation gives the uri(/admin) the user clicks so using it you can manipulate and remove navbar of particular webpage

    const location = useLocation();

  useEffect(() => {
    console.log(location);
    if(location.pathname==='/admin' || location.pathname==='/login' || location.pathname==='/register' || location.pathname==='/users' || location.pathname==='/payments' || location.pathname==='/deliveries' || location.pathname==='/allpizza' ||location.pathname===`/updatepizza/${pizza.id}`  || location.pathname==='/addpizza'){
      setShowNavbar(false);
    } 
      
    else setShowNavbar(true)
  }, [location]);

  return <div>{showNavBar && children}</div>;
}

export default ShowNavbar;
