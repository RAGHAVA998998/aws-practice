import logo from './logo.svg';
import './App.css';
import Form1 from './components/Form1';
import Login from './components/Login';
import { Route, Switch } from 'react-router';
import Navbar from './components/Navbar';
import Guardroute from './components/Guardroute';

function App() {
  return (
    <div className="App">
      <Navbar/>
    <Switch>
    <Route path='/login' component={Login} />
    <Route path='/form1' component={Guardroute} />
    </Switch>
      
    </div>
  );
}

export default App;
