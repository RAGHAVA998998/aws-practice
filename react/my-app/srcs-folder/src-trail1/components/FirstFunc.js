import React, { useState, useEffect, createContext } from 'react';
import SecFunc from './SecFunc';
import Thirdfunc from './Thirdfunc';
import Logout from './Logout';
export const context1=createContext(null)
export  function FirstFunc(props) {

    const stateObj = { counter: 0, doubleCounter: 0, step: 0, name: "", email: '', phone: '', }
    const [state, setState] = useState(stateObj);
    
    const [num,setnum]=useState('added context value');
    
    const changeState = async (e) => {

        console.log('in change state');
        // setState((prev)=>{console.log(prev); return({...prev,counter:prev.counter+1})})
        const { name, value } = e.target;
        if (name === 'counter') {
        
            // setState({ ...state, [name]: state.counter + 5 })
            // state.doubleCounter+=1;
            //setState();
           await setState({ ...state, doubleCounter: state.doubleCounter + 2 })

            console.log('on changestate' + state.doubleCounter);
            setTimeout(() => {
                //dummy(state);
            }, 0);
           //dummy();
        } else {
            setState({ ...state, [name]: value, })
        }
    }
    function dummy(state1) {
        setState({ ...state1, counter: state.counter + 3 })
    }
    //  if (name === 'name') {
    //     setState({ ...thisstate, [name]: value })
    // } if (name === 'email') {
    //     setState({ ...thisstate, [name]: value })
    // }
    // if (name === 'phone') {
    //     setState({ ...thisstate, [name]: value })
    // }
    function addToState(obj) {
        setState(...state, obj)
    }
    const onSubmit = (e) => {
        // e.preventDefault();
        setState((p) => ({ ...state, step: p.step + 1 }))
    }
    const onCancel = (e) => {
        setState((p) => ({ ...state, step: p.step - 1 }))
    }

    useEffect(() => {
        console.log('in use effect')
    },[] )

    function pageNav() {
        switch (state.step) {
            case 0:
                return (
                    <div className='main'>
                        
                        <form>

                            <span>counter :- {state.counter}</span><br />
                            <span>doubleCounter;- {state.doubleCounter}</span>
                            {/* <button type='submit' >ex</button> */}
                            <button name='counter' type='button' onClick={(e) => { changeState(e)}}  defaultValue={state.counter}>add</button>
                            <div>
                                <label>name</label>
                                <input name='name' placeholder='enter name' defaultValue={state.name} onChange={(e) => { changeState(e) }}></input>
                            </div>
                            <span  onKeyPress={()=>{dummy()}} >{state.name}</span><br />

                            <div>
                                <button type='submit' onClick={(e) => onSubmit(e)}>submit</button>
                            </div>


                        </form>
                    </div>
                );
            //break;
            case 1:
                return (
                    <div>
                        <SecFunc state={state}
                            changeState={(e) => changeState(e)}
                            onSubmit={(e) => { onSubmit(e) }}
                            onCancel={(e) => { onCancel(e) }}
                            addToState={(Obj) => { addToState(Obj) }}
                        />
                    </div>
                );
            //break;
            case 2:
                return (
                    <div>
                        <Thirdfunc state={state} changeState={(e) => changeState(e)}
                            onSubmit={(e) => { onSubmit(e) }}
                            onCancel={(e) => { onCancel(e) }}
                            addToState={(Obj) => { addToState(Obj) }}
                        />
                    </div>
                );


            default:
                return (
                    <div>this page not written</div>
                )



        }
    }

    return (
        <div>
            <context1.Provider value={{num,setnum:((i)=>{setnum(i)})}}>
            <Logout state={props.location.state.state} setstate={props.location.state.setState} />
            {JSON.stringify(state)}
            {pageNav()}
            </context1.Provider>
        </div>
    );


    // return (
    //     <div>
    //         <form>
    //         {JSON.stringify(thisstate)}
    //         <span>counter :- {thisstate.counter}</span>
    //         <button name='counter'  onClick={(e)=>{changeState(e)}} defaultValue={state.counter}>add</button>
    //         <div>
    //             <label>name</label>
    //             <input name='name' placeholder='enter name' defaultValue={thisstate.name} onChange={(e)=>{changeState(e)}}></input>
    //         </div>
    //         <span>{thisstate.name}</span>
    //         <SecFunc state={thisstate} changeState={(e)=>changeState(e)}/>
    //         <div> 
    //             <button type='submit'>submit</button>
    //         </div>
    //     </form>
    //     </div>
    // );
}

//export default FirstFunc;