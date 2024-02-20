import React from 'react';
import Logo from '../assests/images/res-logo.png';
import { Link, NavLink } from 'react-router-dom';
import '../style/Navbar.css';




function Navbar() {
  
  return (
    <>
      <nav className="navbar navbar-expand-lg bg-light">
  <div className="container py-3 home-nav" >
  <NavLink to='/home' className="navbar-brand">
      <img src={Logo} alt="Logo" width="30" height="30" className="d-inline-block align-text-top mx-2"/>
      PizzaOnClick
    </NavLink>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav  me-auto mb-2 mb-lg-0 align-items-center mx-auto nav_ul">
        
        <li className="nav-item">
          <NavLink to='/home' className="nav-link">Home</NavLink>
        </li>
        
        <li className="nav-item">
          <NavLink to='/about' className="nav-link">About</NavLink>
        </li>
        
        <li className="nav-item">
          <NavLink  to='/pizza' className="nav-link">Pizza</NavLink>
        </li>

        <li className="nav-item dropdown">
          <nav className="nav-link dropdown-toggle"  role="button" data-bs-toggle="dropdown" aria-expanded="false">
           <span style={{"fontWeight":"500"}}> Deals </span>
          </nav>
          <ul className="dropdown-menu">
            <li><NavLink to='/deals' className="nav-link dropdown-item" >Bulk Order</NavLink></li>

          </ul>
        </li> 
        <li className="nav-item">
          <NavLink  to='/pizza' className="nav-link">Contact Us</NavLink>
        </li>
      </ul>
    </div>
    
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0 align-items-center ms-auto nav_icons">
        <li className="nav-item">
        <NavLink to='/cart' className='nav-link'>
          <span className='shopping_cart' style={{"fontWeight":"500"}}>
          Cart
        <i className="ri-shopping-cart-2-line"></i>
          </span>
          </NavLink>
        </li>
        <li className="nav-item">
          <NavLink to='/login' className='nav-link'>
          <span className='user_login' style={{"fontWeight":"500"}}>
            Login
        <i className="ri-user-line"></i>
          </span>
          </NavLink>
        </li>
      </ul>
      </div>
  </div>
</nav>
    </>
  );
}

export default Navbar;
