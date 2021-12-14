const Changname = (payload) => {
    
    return {
        type: "Changename",
        payload: payload
    }
}
const Loginauth=(payload)=>{
    console.log('in actionauth');
    return {
        type: "Changeauth",
        payload: payload
    }
}

export const action={Loginauth,Changname}