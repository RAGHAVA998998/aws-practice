// export const first=()=>{
//     console.log("first")

// }
// let first2=()=>{
//     console.log('first2');
// }
// class first3{

//     constructor(name){
//         this.name=name;
//     }
//     func1=()=>{
//         console.log("func1");
//     }
    
// }
// export {first,first3,first2}

function big() {
    console.log('starting');
    setTimeout(() => {
        console.log('inside async');
    }, 3000);
}
big();
console.log('outside');