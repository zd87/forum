import * as ajax from "../../js/ajax.js";
import { toPage } from "../../js/redirect.js";
import { formDataToJson } from "../../js/utilsForm.js";
import { el } from "../../js/utilsHtml.js";

const submitTopic= (event)=> {
    event.preventDefault();
    let data = new FormData(el.topicForm);
    let json = formDataToJson(data);
    ajax.post("http://localhost:8085/topics", redirectWithQuery, json); 
}
const redirectWithQuery=(response)=>{
    let query = `?topicId=${encodeURIComponent(response.id)}`
    toPage("discussion", query);
}

const initSubmitButton =()=>{
    el.submitTopicButton.addEventListener("click", submitTopic);
}

initSubmitButton();
