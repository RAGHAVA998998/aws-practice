import React, { Component } from 'react';

class Classcomp extends Component {
    state={counter1:5,counter2:'6'}
    
    changestate1 =(e) =>{
        let {counter1,counter2} = this.state;
        const {value}=e.target;
        this.setState({...this.state,counter2:counter2+1})
       // this.state.counter2=counter2+1
        this.changestate2();
        
    }
    changestate2=(e)=>{
        let {counter1,counter2} = this.state;
        this.setState({...this.state,counter1:counter1+2})
        console.log(this.state.counter1);
    }
    render() {
        console.log('this is in render'+this.state.counter1)
        return (
            <div>
                <span>counter1:- {this.state.counter1}<br/> counter2:-{this.state.counter2}</span>
                <button type='button' onClick={(e)=>{console.log(e);this.changestate1(e);}}>increment</button>
            </div>
        );
    }
}

export default Classcomp;