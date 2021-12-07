
function soltowerofhanoi(n,source,target,aux){
    if(n>0){
    soltowerofhanoi(n-1,source,aux,target);
    console.log('move tile from ' +source +' to '+target);
    }
    if(n>0){
    soltowerofhanoi(n-1,aux,target,source);
    }
}
const source='source';
const target='target';
const aux='auxillary';
soltowerofhanoi(4,source,target,aux)