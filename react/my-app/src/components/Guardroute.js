import React from 'react';
import { useSelector } from 'react-redux';
import { useHistory } from 'react-router';
import Form1 from './Form1';
function Guardroute(props) {
    const history = useHistory()
    const state = useSelector(state => state.form1Reducer)
    function logout() {
        return (<>
            <h2>you have to login again</h2>
            <button type='button' onClick={() => history.push('/login')}>Login</button>
        </>)
    }

    return (
        <div>
            {state.auth ? <Form1 /> : logout()}
        </div>
    );
}

export default Guardroute;