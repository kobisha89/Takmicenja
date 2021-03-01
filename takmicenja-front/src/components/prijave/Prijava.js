import React from 'react';
import Axios from '../../apis/Axios';
import {Table, Button, Form} from 'react-bootstrap'

class Prijava extends React.Component {

    constructor(props) {
        super(props);

        this.state = { id: -1, drzavaTakmicara: "", kontakt: "" }
    }

    componentDidMount() {
        this.getTakmicenjeById(this.props.match.params.id);
        console.log(this.props.match.params.id)
     }

    getTakmicenjeById(takmicenjeId) {
        Axios.get('/takmicenje/' + takmicenjeId)
        .then(res => {
            // handle success
            this.setState({id: res.data.id});
            console.log('Dobavljeni id takmicenja je ' + this.state.id)
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Takmicenje nije dobavljeno!');
         });
    }

    drzavChange = event => {
        console.log(event.target.value);
        let input = event.target;
        let value = input.value;

        this.setState({
            drzavaTakmicara: value
          },function(){
            console.log('Drzava je ' + this.state.drzavaTakmicara)
            console.log('Id  je ' + this.state.id)
          })
    }

    kontaktChange = event => {
        console.log(event.target.value);
        let input = event.target;
        let value = input.value;

        this.setState({
            kontakt: value
          },function(){
            console.log('Kontakt je ' + this.state.kontakt)
            console.log('Id je ' + this.state.id)
          })
    }

    prijava(event) {
        event.preventDefault();
        let config = {
            params: {
                'id': this.state.id,
                'drzavaTakmicara': this.state.drzavaTakmicara,
                'kontakt': this.state.kontakt
            }
        }
        
        Axios.get('/prijave', config, {})
        .then(res => {
            // handle success
            console.log(res);
            alert('Uspesna prijava!');
            this.props.history.push('/takmicenja');
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Prijava nije uspela!');
         });
    }

    render () {
        return (
            <div>
                <h1>Prijava</h1>
                <Form>
                <Form.Label htmlFor="pdrzavaTakmicara">Drzava takmicara</Form.Label><br/>
                <Form.Control id="pdrzavaTakmicara" type="text" value={this.state.drzavaTakmicara} onChange={(event) => this.drzavChange(event)}/><br/>
                <Form.Label htmlFor="pkontakt">Kontakt</Form.Label><br/>
                <Form.Control id="pkontakt" type="text" value={this.state.kontakt} onChange={(event) => this.kontaktChange(event)}/><br/>

                <Button style={{ marginTop: "1px" }} className="button btn-primary" onClick={(event) => this.prijava(event)}>Prijavi</Button>
                </Form>
            </div>
        )
    }

}

export default Prijava;