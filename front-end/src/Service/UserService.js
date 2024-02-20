import axios from 'axios';


class UserService{

    getAllUsers(){
        return axios.get('/users')
    }
}

export default new UserService();