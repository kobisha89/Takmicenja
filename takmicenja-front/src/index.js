import React from 'react';
import ReactDOM from 'react-dom';
import { Route, Link, HashRouter as Router, Switch } from 'react-router-dom';
import { Navbar, Nav, Container, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './components/Home';
import {logout} from './services/auth';
import Login from './components/login/Login';
import Takmicenje from './components/takmicenje/Takmicenje';
import AddTakmicenje from './components/takmicenje/AddTakmicenje';
import Prijava from './components/prijave/Prijava';
import { Provider } from "react-redux";
import { createStore, applyMiddleware } from "redux";
import thunk from 'redux-thunk';
import reducers from './reducers';

class App extends React.Component{
    render() {
        return (
            <div>
                <Router>
                    <Navbar expand bg="dark" variant="dark">
                        <Navbar.Brand as={Link} to="/">
                            Home
                        </Navbar.Brand>
                        <Nav>
                            <Nav.Link as={Link} to="/takmicenja">Takmicenja</Nav.Link>
                            
                            {window.localStorage['jwt'] ? 
                            <Button onClick = {()=>logout()}>Logout</Button> :
                            <Nav.Link as={Link} to="/login">Log in</Nav.Link>
                            }
                        </Nav>
                    </Navbar> 
                    <Container style={{paddingTop:"25px"}}>
                    <Switch>
                            <Route exact path="/" component={Home} />
                            <Route exact path="/login" component={Login}/>
                            <Route exact path="/takmicenja" component={Takmicenje} />
                            <Route exact path="/takmicenja/add" component={AddTakmicenje} />
                            <Route exact path="/prijava/:id" component={Prijava} />
                    </Switch>
                    </Container>
                    </Router>
            </div>
        )
    }

}

let storeEnhancer = applyMiddleware(thunk);

ReactDOM.render(
 <Provider store={createStore(reducers, storeEnhancer)}>
    <App />
  </Provider>,
  document.querySelector("#root")
);