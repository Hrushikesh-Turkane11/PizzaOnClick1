import './App.css';
import Navbar from './Components/Navbar'
import Home from './Components/Home'
import About from './Components/About'
import Contact from './Components/Contact'
import AllPizza from './Components/AllPizza'
import PizzaDetails from './Components/PizzaDetails'
import {Routes,Route,BrowserRouter as Router } from 'react-router-dom'
import ShowNavbar from './Components/ShowNavbar';
import Admin from './Components/Admin/Admin';
import Users from './Components/Admin/Users';
import Payment from './Components/Admin/Payment';
import Delivery from './Components/Admin/Delivery';
import Login from './Components/Login';
import Register from './Components/Register';
import GetAllPizza from './Components/Admin/GetAllPizza';
import UpdatePizza from './Components/Admin/UpdatePizza';
import AddPizza from './Components/Admin/AddPizza';

function App() {
  return (
    <>
      <Router>
        <ShowNavbar>
        <Navbar/>
        </ShowNavbar> 
      <Routes>
       
      <Route exact path='/admin' element={<Admin></Admin>}></Route>
      <Route exact path='/users' element={<Users></Users>}></Route>
      <Route exact path='/payments' element={<Payment></Payment>}></Route>
      <Route exact path='/deliveries' element={<Delivery></Delivery>}></Route>
      <Route exact path='/allpizza' element={<GetAllPizza></GetAllPizza>}></Route>
      <Route exact path='/updatePizza/:id' element={<UpdatePizza></UpdatePizza>}></Route>
      <Route exact path='/addPizza' element={<AddPizza></AddPizza>}></Route>
      
      
        <Route exact path='/' element={<Home></Home>}></Route>
        <Route exact path='/home' element={<Home></Home>}></Route>
        <Route exact path='/about' element={<About></About>}></Route>
        <Route exact path='/contact' element={<Contact></Contact>}></Route>
        <Route exact path='/pizza' element={<AllPizza></AllPizza>}></Route>
        <Route exact path='/pizza/:id' element={<PizzaDetails></PizzaDetails>}></Route>
        <Route exact path='/login' element={<Login></Login>} ></Route>
        <Route exact path='/register' element={<Register></Register>}></Route>
        
      </Routes>
      </Router>

    

    </>
  );
}

export default App;
