import React from 'react'
import AdminNavbar from './AdminNavbar'
import user from '../../assests/icons/team.png'
import pizza from '../../assests/icons/pizza.png'
import payment from '../../assests/icons/wallet.png'
import delivery from '../../assests/icons/delivery-bike.png'
import topping from '../../assests/icons/vegetable.png'
function Admin() {
  return (
    <>
        <AdminNavbar></AdminNavbar>

        <div className="container">
          {/* first row */}
          <div className="row mt-3">

            {/* first col */}
            <div className="col-md-4 mt-2">
              <div className="card">
                <div className="card-body text-center">
                  <div className="container">
                    <img style={{"maxWidth":"150px"}} src={user} className='img-fluid' alt="not found" />
                  </div>

                  <h1>2342</h1>
                  <h1>Users</h1>
                </div>
              </div>
            </div>

            {/* second col */}
            <div className="col-md-4 mt-2">
            <div className="card">
                <div className="card-body text-center">
                <div className="container">
                    <img src={pizza} style={{"maxWidth":"150px"}}  className='img-fluid' alt="not found" />
                  </div>
                  <h1>1256</h1>
                  <h1>Pizzas</h1>
                </div>
              </div>
            </div>

            {/* third col */}
            <div className="col-md-4 mt-2">
            <div className="card">
                <div className="card-body text-center">
                <div className="container">
                    <img src={payment} style={{"maxWidth":"150px"}} className='img-fluid' alt="not found" />
                  </div>
                  <h1>256</h1>
                  <h1>Payments</h1>
                </div>
              </div>
            </div>
          </div>

          {/* second row */}
          <div className="row">

            {/* first col */}
            <div className="col-md-6 mt-2">
            <div className="card">
                <div className="card-body text-center">
                <div className="container">
                    <img src={delivery} style={{"maxWidth":"150px"}} className='img-fluid' alt="not found" />
                  </div>
                  <h1>125</h1>
                  <h1>Delivery</h1>
                </div>
              </div>
            </div>

            {/* second col */}
            <div className="col-md-6 mt-2">
            <div className="card">
                <div className="card-body text-center">
                <div className="container">
                    <img src={topping} style={{"maxWidth":"150px"}} className='img-fluid' alt="not found" />
                  </div>
                  <h1>20</h1>
                  <h1>Toppings</h1>
                </div>
              </div>
            </div>
          </div>
        </div>
    </>
  )
}

export default Admin