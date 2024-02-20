import React from 'react'
import '../style/About.css'
import aboutImg from '../assests/images/location.png'
function About() {
  return (
    <>
    
      <div className="container">
        <div className="row">
          <div className="col-lg-6 col-md-6 ">
    <img src={aboutImg} alt='not' className='about-img w-75'></img>
          </div>
          <div className="col-md-6 col-lg-6">
    <div className="why-pizza">
        <h2 className="title mb-4">Why <span>PizzaOnClick?</span></h2>
        <p className='about-desc'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio nobis rem facilis vitae dicta autem natus hic ipsum, alias, similique ex quas ad sint aliquam eligendi debitis delectus nisi consequuntur.</p>
        <div className="list-group">

          <div className="list-item">
          <p className='item-icon d-flex align-items-center gap-2'><i className="ri-checkbox-circle-line"></i>Fresh and tasty food</p>
          <p className='item-desc'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis, possimus?</p>
          </div>

          <div className="list-item">
          <p className='item-icon d-flex align-items-center gap-2'><i className="ri-checkbox-circle-line"></i>Quality food</p>
          <p className='item-desc'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis, possimus?</p>
          </div>

          <div className="list-item">
          <p className='item-icon d-flex align-items-center gap-2'><i className="ri-checkbox-circle-line"></i>Fast delivery</p>
          <p className='item-desc'>Lorem ipsum dolor sit amet consectetur adipisicing elit. Blanditiis, possimus?</p>
          </div>
      </div>
    </div>
            
          </div>
        </div>
      </div>
    </>
  )
}

export default About