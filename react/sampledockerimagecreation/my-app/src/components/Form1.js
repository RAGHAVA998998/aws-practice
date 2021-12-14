import React, { useState } from 'react';
import { useSelector } from 'react-redux';
import Logout from './Logout';

function Form1(props) {
    const [toggle,settoggle]=useState(true)
    const state=useSelector(state=>state.form1Reducer.name)
    return (
        <div>
            <Logout/>
            form1: {JSON.stringify(state)}
            {JSON.stringify(toggle)}
            <input type='radio'  value={toggle} onClick={(e)=>{console.log(e.target.value);settoggle(!toggle)}} />
        </div>
    );
}

export default Form1;