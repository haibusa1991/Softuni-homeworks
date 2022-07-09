function solve(arr,order){
    let orders = {
        asc:(a,b)=>a-b,
        desc:(a,b)=>b-a
    }
    return arr.sort((a,b)=>orders[order](a,b));
}