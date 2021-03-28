import { Table, Button, message} from "antd";
import Column from "antd/lib/table/Column";
import { Component } from "react";
import PessoaDataService from "../services/PessoaDataService";


export default class ListaPessoas extends Component {

    constructor(props) {
        super(props)
        this.state = {
            pessoas:[],
            message: null
        }
    }

    sucess = (record) => {
        if (record.isVacinada){
            record.isVacinada = false;
        } else record.isVacinada = true;
        PessoaDataService.updatePessoa(record, record.codigo);
        message.success('Status alterado com sucesso!');
    }

    delete = (record) => {
        PessoaDataService.deletePessoa(record.codigo);
        message.success('Deletado com sucesso!');
    }

    componentDidMount(){
        this.refreshPessoas();
    }

    refreshPessoas(){
       PessoaDataService.retriveAllPessoas()
       .then(
           response => {
               console.log(response);
               this.setState({pessoas: response.data})
           }
       )
    }

    render() {
        return (
            <div className="container">
                <h2>PESSOAS CADASTRADAS</h2>  
                <div className="container">
                    <Table dataSource={this.state.pessoas}>
                        <Column title="NOME" dataIndex="nome" key="nome" width="400px" />
                        <Column title="CPF" dataIndex="cpf" key="cpf" />
                        <Column title="TELEFONE" dataIndex="telefone" key="telefone" />
                        <Column title="EMAIL" dataIndex="email" key="email" />
                        <Column title="VACINADA" dataIndex="isVacinada" key="isVacinada" 
                        render={(text, record) => (<p>{String(record.isVacinada)}</p>)}/>

                        <Column title="ATUALIZAR"  key="atualizar" width="20px"
                        render={(text, record) => (<Button onClick={() => this.sucess(record)} 
                        type="primary">Alterar status</Button>)} />

                        <Column title="DELETAR"  key="deletar" width="20px"
                        render={(text, record) => (<Button onClick={() => this.delete(record)} 
                        type="primary" danger>Deletar</Button>)} />                      

                    </Table>
                </div>
            </div>
        )

}



}