
import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import {  useHistory,  } from 'react-router';
import { action } from '../redux/actions';

function Login(props) {
    const state=useSelector(state=>state.form1Reducer)
    const dispatch=useDispatch();
    const [localstate,setstate]=useState(false)
    const history=useHistory()
    
    async function checkauth(){
        
        console.log('incheckauth');
        if(state.name==='raghava'){
            const dummyvar= await setTimeout(dummy(),10000)
            console.log(dummyvar);
            console.log('in if');
            dispatch(action.Loginauth(true));
            history.push('/form1')
        }else{
            setstate(true)
        }
    }
    function dummy() {
        return 5;
    }
    return (
        <div>
            <form>
            Login: {JSON.stringify(state)}
            <br/>
            name: <input type='text' onChange={(e)=>dispatch(action.Changname(e.target.value))}/><br/>
            <button type='button' onClick={checkauth}>Login</button><br/>
            {localstate && <h3>invalid login details</h3> }
            {/* {state.auth && <Redirect to='/form1'/> } */}
            </form>
        </div>
    );
}

export default Login;