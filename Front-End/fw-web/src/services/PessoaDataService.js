import axios from 'axios';

const API_URL = process.env.REACT_APP_API_URL;

class PessoaDataService{
    
    retriveAllPessoas(){
        return axios.get(`${API_URL}pessoas`);
    }

    updatePessoa(pessoa, codigo){
        return axios.put(`${API_URL}pessoas/${codigo}`, pessoa);
    }
	
    deletePessoa(codigo){
        return axios.delete(`${API_URL}pessoas/${codigo}`);
    }			
}

export default new PessoaDataService();