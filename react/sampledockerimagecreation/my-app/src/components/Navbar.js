import React from 'react';
import { Link } from 'react-router-dom';

function Navbar(props) {
    return (
        <div>
           <nav className='nav-bar'>
            <Link className='Link' to='/login'>Login</Link>   
            <Link className='Link' to='/form1'>Form1</Link>   
            </nav> 
        </div>
    );
}

export default Navbar;