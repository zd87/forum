const formDataToJson =(formData)=> {
    let obj = Object.fromEntries(formData);
    let json = JSON.stringify(obj);
    return json;
}

export {
    formDataToJson
}