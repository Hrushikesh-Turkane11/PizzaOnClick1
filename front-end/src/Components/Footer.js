import React from 'react'
import Logo from '../assests/images/res-logo.png';
import '../style/Footer.css'
import { Link } from 'react-router-dom';
function Footer() {
  // Timestap 55 min
  return (
   <>
   <footer className='footer'>
   <div className="container w-auto" >
      <div className="row">
        <div className="col-md-4 col-sm-6 col-lg-3">
        <img src={Logo} alt="Logo not found" className='logo-img'/>
              <h5 className='mx-2'>PizzaOnClick</h5>
              <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Voluptatum, officiis repudiandae.</p>
        </div>
        <div className="col-md-4 col-sm-6 col-lg-3">
            <h5 className='footer-title'>Delivery Time</h5>
            <div className="list-group ps-0">
              <div className="list-item delivery-items">
                <span>Monday-Friday</span>
                <p>10:00am -6:30pm </p>
              </div>
              <div className="list-item ps-0 delivery-items">
                <span>Saturday-Sunday</span>
                <p>Off Day </p>
              </div>
            </div>
        </div>
        <div className="col-md-4 col-sm-6 col-lg-3">
          <h5 className='footer-title'>Contact</h5>
          <div className="list-group">
          <div className="list-item contact">
                <p>Location: JijaMata Chowk, Akurdi,Pune</p>
              </div>

          <div className="list-item contact">
                <p>Phone: 99999999</p>
              </div>
              <div className="list-item contact">
                <span>email: example@gmail.com</span>
              </div>
              </div>
        </div>

        <div className=" col-md-4 col-sm-6 col-lg-3">
          <h5 className='footer-title'>NewsLetter</h5>
          <p className='subscribe'>Subscribe to our newsletter</p>
          <div className="newsletter">
          <input type="email" placeholder='Enter you email'/>
          <span>
          <i className="ri-send-plane-fill"></i>
          </span>
          </div>
        </div>
      </div>
      <div className="row mt-5">
      <div className="col-lg-6 col-md-6 copy-text">
          <p>Copyright-2023 &copy; All rights reserved.</p>
        </div>
        <div className="col-lg-6 col-md-6">
        <div className="social-links d-flex align-items-center gap-4 justify-content-end">
          <p className='m-0'>Follow</p>
          <span><Link to=''><i className="ri-github-fill"></i></Link></span>

          <span><Link to=''><i className="ri-facebook-fill"></i></Link></span>

          <span><Link to=''><i className="ri-linkedin-box-fill"></i></Link></span>
        </div>
        </div>

      </div>
   </div>
   </footer>
   </>
  )
}

export default Footer