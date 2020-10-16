import * as ajax from "../../js/ajax.js";
import { toPage } from "../../js/redirect.js";
import { formDataToJson } from "../../js/utilsForm.js";

const submitTopic= (event)=> {
    event.preventDefault();
    let form = document.getElementById("topicForm");
    let data = new FormData(form);
    let json = formDataToJson(data);
    ajax.post("http://localhost:8085/topics", redirectWithQuery, json); 
}
const redirectWithQuery=(response)=>{
    let query = `?topicId=${encodeURIComponent(response.id)}`
    toPage("discussion", query);
}

const initSubmitButton =()=>{
    document.getElementById("submitTopic").addEventListener("click", submitTopic);
}

initSubmitButton();