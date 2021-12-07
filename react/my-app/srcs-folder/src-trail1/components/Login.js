import React, { createContext, useState } from 'react';
import { Redirect } from 'react-router';
import Guardroute from '../login/Guardroute';
export const logincontext=createContext();
function Login(props) {
    
    let obj={user:"",
            password:'',
            auth:false,
        loginpress:false,logoutpress:false,
        checked:false}

    const [state,setstate]=useState(obj);
    console.log(setstate);

    function onchange(e) {
        const {name,value}=e.target;
        setstate({...state,[name]:value,loginpress:false})
    }
    function handleloginbutton(e){
        console.log('in func')
        setstate({...state,loginpress:true})
        console.log('in func end')
    }
    return (
        <div>
            <logincontext.Provider value={{state:state,setstate:setstate}}>
            {JSON.stringify(state)}
            <form>
            user:  <input type='text' name='user' onChange={onchange}></input>
            <br/>
            password:  <input type='text' name='password' onChange={onchange} ></input>
            <br/>
            <button type='button' onClick={handleloginbutton}>login</button>
            </form>    
            {/* {state.loginpress && <Redirect to={{pathname:'/loginpage',state:{state}}}> </Redirect>}     */}
            {state.loginpress && <Guardroute state={state} setstate={(e)=>setstate(e)}></Guardroute>}    
            {/* {!state.auth && state.loginpress && 'enter valid user'} */}
            {state.checked && 'invaid user'} 
            {state.auth && <Redirect to={{pathname:'/firstfunc',
                                            state:{state,
                                            }}} ></Redirect> }
            </logincontext.Provider>
        </div>
    );


}
        
export default Login;