import * as ajax from "../../js/ajax.js";
import { buildComment, el } from "../../js/utilsHtml.js";
import { formDataToJson } from "../../js/utilsForm.js";
import { storage } from "../../data/storage.js";

const displayComments = (comments)=> {
    el.commentsContainer.innerHTML="";
    for(let comment of comments) {
        buildComment(comment, commentsContainer, addQuote);
    }
}

const displayTopic=(topic)=>{
    el.topicName.innerHTML = topic.name;
    el.topicDescription.innerHTML = topic.description;
    el.topicCreationDate.innerHTML = topic.creationDate;
}

const toggleQuote =(display, comment)=>{
    el.quotedComment.style.display=display;    
    if(comment){
        el.quotedCommentBody.innerHTML="";
        el.quotedCommentBody.innerHTML=comment.comment;
        initRemoveButton();
    }
}
const initRemoveButton=()=>{
    el.removeQuoteButton.onclick = function(){ removeQuote() };
}
const addQuote= (comment) => {
    storage.comments.quotedCommentId = comment.id;
    toggleQuote("flex", comment);
};
const removeQuote =()=>{
    storage.comments.quotedCommentId=null;
    toggleQuote("none");
}
const submitComment =(event)=>{
    event.preventDefault();
    let data = new FormData(el.commentForm);
    if(storage.comments.quotedCommentId) data.set("quotedCommentId", storage.comments.quotedCommentId);
    let json = formDataToJson(data);
    ajax.post(`http://localhost:8085/topics/${storage.topics.chosenTopic}/comments`, fetchComments, json); 
}

const discussionInit=()=>{
    let queryString = window.location.search;
    let queryObject = new URLSearchParams(queryString);
    for(let [key, value] of queryObject){
        if (key==="topicId" && value) storage.topics.chosenTopic=value;
        fetchTopic();
        fetchComments();
        el.submitCommentButton.addEventListener("click", submitComment);
    }
}

const fetchTopic = ()=> {
    ajax.get(`http://localhost:8085/topics/${storage.topics.chosenTopic}`, displayTopic);
}
const fetchComments = () =>{
    ajax.get(`http://localhost:8085/topics/${storage.topics.chosenTopic}/comments`, displayComments);

}


discussionInit();
