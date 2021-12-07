import React, { useContext, useEffect, useState } from 'react';
import { Redirect } from 'react-router';
import { FirstFunc } from '../components/FirstFunc';
import {logincontext} from '../components/Login'
function Guardroute(props) {
    const obj=useContext(logincontext) 
    // const obj1=props.location.state;
    // const [state,setstate]=useState(obj1.state)
    // useEffect(()=>{
    //     console.log(obj1.state.user)
    //     console.log(obj1.state.user==='raghava')
    //     if(obj1.state.user==='raghava'){
    //         setstate({...state,auth:true})
    //     }}
    //     ,[])  


    const state=props.state;
    // const [state,setstate]=useState(obj2);
    useEffect(()=>{
        if(state.user==='raghava' && state.loginpress){
            props.setstate({...state,auth:true,checked:true, loginpress:false})
            console.log('called guardroute if')
            console.log(state)
        }else if(state.user !='raghava' && state.loginpress){
            props.setstate({...state,loginpress:false,checked:true}) 
            console.log('called guardroute else')
        }
        if(props.logout){
            console.log('in logout1')
            props.setstate({...state,auth:false,logoutpress:false})
        }
        
    },[])
    useEffect(()=>{
        if(props.logout){
            console.log('in logout2')
            props.setstate({...state,auth:false,logoutpress:false})
            props.setlogout(false)
        }
    },)

    return (
        <div>
            {JSON.stringify(state)}
            <div>
              
              
            </div>
            
        </div>
    );
}

export default Guardroute;