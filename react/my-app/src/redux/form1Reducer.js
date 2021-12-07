const initialstate={name:'',auth:false}
export const form1Reducer=(state=initialstate,action)=>{
    console.log('inside reducer');
    switch (action.type) {
        case 'Changename':
            
            return ({...state,name:action.payload})
        case "Changeauth":
            console.log('in reducer auth');
            return({...state,auth:action.payload})
            
        default:
            return state;
    }
}