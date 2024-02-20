import axios from "axios";

class PizzaService{

    getAllPizza(){
       return  axios.get("/pizza/getallPizza");
    }

    deletePizza(id){
        return  axios.delete("/pizza/"+id);
    }

    updatePizza(pizza){
        console.log("updatePizza",pizza);
        return  axios.put("/pizza/"+pizza.id);
    }

    addPizza(p){
        return axios.post("/pizza",p);
    }

    getById(id){
        return axios.get("/pizza/"+id);
    }
}

export default new PizzaService();