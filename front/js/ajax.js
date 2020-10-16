
const post = (url, callback, payload, customOptions)=>{
    let defaultOptions = {
        method:"POST",
        headers: {
            "Content-Type":"application/json"
        },
        body:payload
    };
    let options = {...defaultOptions, ...customOptions};
    callFetch(url, callback, options);
}

const get = (url, callback, customOptions)=>{
    let defaultOptions = {
        method:"GET"
    };
    let options = {...defaultOptions, ...customOptions};
    callFetch(url, callback, options);
}

const callFetch = (url, callback, options)=>{
    fetch(url, options)
        .then(response => {
            if (response.ok){
                response.status !== 204 ?
                response.json().then(json => { callback(json)}) :
                callback();
            }
            console.log(response);
            
        //     if (response.ok){
        //         if (response.json()){

        //         }
        //     }
        //     response.json()
        // })
        // .then(json => { callback(json)})
        }).catch(err => console.log("ERROR from fetch: ", err));
}

export {
    post,
    get
}