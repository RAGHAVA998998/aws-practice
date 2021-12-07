import logo from './logo.svg';
import './App.css';
import {FirstFunc} from './components/FirstFunc';
import axios from 'axios'
import Classcomp  from './components/Classcomp'
import {BrowserRouter as Router, Route,Redirect} from 'react-router-dom'
import Login from './components/Login';
import Guardroute from './login/Guardroute';
import {logincontext} from './components/Login'
import { useContext } from 'react';
function App(props) {
  const state1=props.location;
  console.log(state1)
  return (
    
    <div className="App">
     
      <Router>
        <nav>
        <a href={'/login'}><button>home</button> </a>
        </nav>
      {/* <FirstFunc/> */}
       {/* <Classcomp/> */}
       <Route path='/firstfunc' component={FirstFunc}></Route>
       <Route path='/login' component={Login}></Route>
       <Route path='/loginpage' component={Guardroute}></Route>
       </Router>
      {/* <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header> */}
    </div>
  );
}

export default App;
