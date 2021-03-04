import React from 'react';
import Axios from '../../apis/Axios';
import {Button, Form} from 'react-bootstrap'
import getFormatiAction from "../../actions/GetFormati";
import { connect } from "react-redux";

class AddTakmicenje extends React.Component {


    constructor(props){
        super(props);

        let tekmicenje = {
            naziv: "",
            mestoOdrzavanja: "",
            datumPocetka: "",
            datumZavrsetka: "",
            format: null
        }

        this.state = {tekmicenje: tekmicenje, formati: []};
    }

    componentDidMount(){
        this.props.getFormati();
    }

    getFormati() {
        Axios.get('/formati')
            .then(res => {
                 // handle success
                 console.log(res);
                 this.setState({formati: res.data});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Problem sa ocitavanjem formati');
            });
    }

    onInputChange(e) {
        let input = e.target;
    
        let name = input.name;
        let value = input.value;
    
        let tekmicenje = this.state.tekmicenje;
        tekmicenje[name] = value;
    
        this.setState({ tekmicenje: tekmicenje });
        console.log(this.state.tekmicenje)
    }

    formatkSelectionChange(e) {
        let formatId = e.target.value;
        let format = this.props.formati.find((format) => format.id == formatId);
        console.log(format)

        let tekmicenje = this.state.tekmicenje;
        tekmicenje.format = format;

        this.setState({tekmicenje: tekmicenje});
        console.log(this.state.tekmicenje)
    }

    create(e) {
        e.preventDefault();

        let tekmicenje = this.state.tekmicenje;

            let tekmicenjeDTO = {
                naziv: tekmicenje.naziv,
                mestoOdrzavanja: tekmicenje.mestoOdrzavanja,
                datumPocetka: tekmicenje.datumPocetka,
                datumZavrsetka: tekmicenje.datumZavrsetka,
                format: tekmicenje.format
            }

        Axios.post('/takmicenje', tekmicenjeDTO)
        .then(res => {
            // handle success
            console.log(res);
           
            alert('Takmicenje je uspseno dodato!');
            this.props.history.push('/takmicenja');
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Problem sa slanjem takmicenja na server!');
         });
    }

    render() {
        return (
            <div>
                <h1>Dodaj takmicenje</h1>
                <Form>
                    <Form.Label htmlFor="tnaziv">Naziv</Form.Label><br/>
                    <Form.Control id="tnaziv" type="text" name="naziv" onChange={(e) => this.onInputChange(e)}/><br/>
                    <Form.Label htmlFor="tmestoOdrzavanja">Mesto odrzavanja</Form.Label><br/>
                    <Form.Control id="tmestoOdrzavanja" type="text" name="mestoOdrzavanja" onChange={(e) => this.onInputChange(e)}/><br/>
                    <Form.Label htmlFor="tdatumPocetka">Datum pocetka</Form.Label><br/>
                    <Form.Control id="tdatumPocetka" type="text" name="datumPocetka" onChange={(e) => this.onInputChange(e)}/><br/>
                    <Form.Label htmlFor="tdatumZavrsetka">Datum zavrsetka</Form.Label><br/>
                    <Form.Control id="tdatumZavrsetka" type="text" name="datumZavrsetka" onChange={(e) => this.onInputChange(e)}/><br/>
                    <Form.Label htmlFor="tformat">Format</Form.Label><br/>
                    <Form.Control as="select" id="tformat" onChange={event => this.formatkSelectionChange(event)}>
                        <option></option>
                        {
                            this.props.formati.map((format) => {
                                return (
                                    <option key={format.id} value={format.id}>
                                        {format.tip}
                                    </option>
                                )
                            })
                        }
                    </Form.Control><br/>
                    <Button className="button btn-primary" onClick={(event)=>{this.create(event);}}>Add</Button>
                </Form>

            </div>
        )
    }

}

const mapStateToProps = (state, ownProps) => {
    // console.log(state);
    return { formati: state.formati };
  };
  
  export default connect(mapStateToProps, {
    getFormati: getFormatiAction,
  })(AddTakmicenje);