import React, { useContext, useState } from 'react';
import { Redirect } from 'react-router';
import Guardroute from '../login/Guardroute';
import {logincontext} from './Login';

function Logout(props) {
    const [logout,setlogout] =useState(false);
    const state=props.state
    const onclickbutton=()=>{
        setlogout(true)
    }

    return (
        <div>
            {JSON.stringify(state)}
            <nav>
                <button onClick={onclickbutton}>logout</button>
            </nav>
             <Guardroute state={state} logout={logout} setlogout={setlogout} setstate={props.setstate}/>
            {!state.auth && <Redirect to={'/login'} />}
            
        </div>
    );
}

export default Logout;