import axios from "axios";


class PaymentService{
    getAllPayments(){
        return axios.get('/payments')        
    }
}

export default new PaymentService();