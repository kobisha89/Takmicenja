import React from 'react';
import Axios from '../../apis/Axios';
import {Table, Button, Form} from 'react-bootstrap'
import getFormatiAction from "../../actions/GetFormati";
import { connect } from "react-redux";

class Takmicenje extends React.Component {


    constructor(props){
        super(props);

        this.state = { 
            takmicenja: [],
            formati:[],
            search: {mestoOdrzavanja:"", formatId: null},
            pageNo: 0, 
            totalPages: 0
        };
    }

    componentDidMount() {
        this.props.getFormati();
        this.getTakmicenja(0);
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
                alert('Formati nisu dobavljeni!');
            });
    }

    delete(takmicenjeId) {
        Axios.delete('/takmicenje/' + takmicenjeId)
        .then(res => {
            console.log(res);
            alert("Takmicenje je obrisano!")
            window.location.reload()
        })
        .catch(error => {
            console.log(error);
            alert("Takmicenje nije obrisano!")
        })
    }

    renderTakmicenja () {

        return this.state.takmicenja.map ((takmicenje) => {
            return (
                <tr key={takmicenje.id}>
                    <td>{takmicenje.naziv}</td>
                    <td>{takmicenje.mestoOdrzavanja}</td>
                    <td>{takmicenje.datumPocetka}</td>
                    <td>{takmicenje.datumZavrsetka}</td>
                    <td>{takmicenje.format.tip}</td>
                    <td><button className="btn btn-danger" onClick={() => this.delete(takmicenje.id)}>Delete</button></td>
                    <td><button className="btn btn-primary" onClick={() => this.prijava(takmicenje.id)}>Prijavi se</button></td>
                </tr>
            )
        })

    }

    prijava(takmicenjeId) {
        this.props.history.push('/prijava/'+ takmicenjeId);
    }

    searchValueChange(e) {
        let control = e.target;

        let name = control.name
        let value = control.value

        let search = this.state.search

        search[name] = value

        this.setState({search:search})
        console.log(this.state.search)

    }

    search() {
        this.getTakmicenja();
    }

    getTakmicenja(pageNo) {
        let config = {
            params: {
                pageNo: pageNo
            },
          }

        if (this.state.search.mestoOdrzavanja != "") {
            config.params.mestoOdrzavanja = this.state.search.mestoOdrzavanja;
        }  
        if (this.state.search.sprintId != -1) {
            config.params.formatId = this.state.search.formatId;
        }  

        Axios.get('/takmicenje', config)
            .then(res => {
                 // handle success
                 console.log(res);
                 this.setState({
                    takmicenja: res.data,
                    totalPages:res.headers["total-pages"]});
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Greska u dobavljanju takmicenja!');
            });
    }

    addTakmicenje() {
        this.props.history.push('/takmicenja/add')
    }


    render() {
        return (
            <div>
                <h1>Takmicenja</h1>
                <Button className="btn btn-primary" type="submit" onClick = {() => this.addTakmicenje()}>Dodaj takmicenje</Button><br/>
                <Form>
                    <Form.Label htmlFor="tmestoOdrzavanja">Mesto Odrzavanja</Form.Label><br/>
                    <Form.Control id="tmestoOdrzavanja" name="mestoOdrzavanja" type="text" onChange={(e) => this.searchValueChange(e)}/><br/>
                    <Form.Label htmlFor="tformatId">Format</Form.Label><br/>
                    <Form.Control as="select" id="tformatId" name="formatId" onChange={(e) => this.searchValueChange(e)}>
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
                    
                    <Button style={{ marginTop: "1px" }} className="btn btn-primary" onClick={()=>{this.search();}}>Search</Button>
                </Form>

                <Table style={{marginTop:30}} className="table table-dark">
                    <thead>
                        <tr>
                            <th>Naziv</th>
                            <th>Mesto 0drzavanja</th>
                            <th>Datum pocetka</th>
                            <th>Datum zavrsetka</th>
                            <th>Format</th>
                            <th>Actions</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.renderTakmicenja()}
                    </tbody>
                    
                </Table>
                <div>
                    <button disabled={this.state.pageNo==0} className="btn btn-primary" onClick={() =>this.getTakmicenja(this.state.pageNo = this.state.pageNo - 1)}>Previous</button>
                    <button disabled={this.state.pageNo==this.state.totalPages-1} className="btn btn-primary" onClick={() =>this.getTakmicenja(this.state.pageNo = this.state.pageNo + 1)}>Next</button>
                </div>
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
  })(Takmicenje);