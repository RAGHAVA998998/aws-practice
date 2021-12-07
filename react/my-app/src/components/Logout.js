import React from 'react';
import { useDispatch } from 'react-redux';
import { action } from '../redux/actions';

function Logout(props) {
    const dispatch=useDispatch();
    return (
        <div>
            <button type='button' onClick={()=>dispatch(action.Loginauth(false))}>logout</button>
        </div>
    );
}

export default Logout;