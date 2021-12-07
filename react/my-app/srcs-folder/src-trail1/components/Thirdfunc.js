import axios from 'axios';
import React, { useContext } from 'react';
import {context1} from './FirstFunc'
function axiosReq() {
    axios.get('https://www.youtube.com/watch?v=LlvBzyy-558&t=4386s')
        .then((res)=>{
            console.log(res.data);
        })
}

function Thirdfunc(props) {
    const num=useContext(context1);
    return (
        <div>
            {console.log(num.num)}
            <button type='button'onClick={()=>{num.setnum(num.num+' changed')}}>checking context</button>
            <span >{props.state.counter}</span>
            <label>phone</label>
            <input type='number' defaultValue={props.state.phone} name='phone' onChange={props.changeState}></input>
            <div>
                <button type='button' onClick={axiosReq}>axios req</button>
            <button  onClick={(e) => props.onCancel(e)}>cancel</button>

                <button type='submit' onClick={(e) => props.onSubmit(e)}>submit</button>
            </div>
        </div>
    );
}

export default Thirdfunc;