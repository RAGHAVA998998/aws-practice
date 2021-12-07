import React from 'react';
import Thirdfunc  from './Thirdfunc';

function SecFunc(props) {
    return (
        <div>
            <span>{props.state.counter}</span>
            <div>
                <label>email </label> 
                <input name='email' defaultValue={props.state.email}  onChange={props.changeState}></input>
            </div>
            <button type='submit' onClick={(e) => props.onCancel(e)}>cancel</button>

            <button type='submit' onClick={(e) => props.onSubmit(e)}>submit</button>
            
        </div>
    );
}

export default SecFunc;