const ax=require('axios')

const demo1=()=>{
    ax.get({URL:'https://www1.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol=UPL',
            })
        .then(res=>{
            const htmlfile=res.data;
            const stockp=htmlfile.document.getElementById("lastPrice").textContent
            console.log(stockp);
        })
        
}
demo1()