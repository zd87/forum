import * as ajax from "../../js/ajax.js";
import * as utilsHtml from "../../js/utilsHtml.js";
import { formDataToJson } from "../../js/utilsForm.js";
import { storage } from "../../data/storage.js";

const displayComments = (comments)=> {
    const commentsContainer = document.getElementById("commentsContainer");
    commentsContainer.innerHTML="";
    for(let comment of comments) {
        utilsHtml.buildComment(comment, commentsContainer, addQuote);
    }
}

const displayTopic=(topic)=>{
    let topicName = document.getElementById("chosenTopic");
    let topicDescription = document.getElementById("chosenTopicDescription");
    let topicCreationDate = document.getElementById("chosenTopicCreationDate");
    topicName.innerHTML = topic.name;
    topicDescription.innerHTML = topic.description;
    topicCreationDate.innerHTML = topic.creationDate;
}

const toggleQuote =(display, comment)=>{
    let quotedComment = document.getElementById("quotedComment");
    quotedComment.style.display=display;    
    if(comment){
        let quotedCommentBody = document.getElementById("quotedCommentBody");
        quotedCommentBody.innerHTML="";
        quotedCommentBody.innerHTML=comment.comment;
        initRemoveButton();
    }
}
const initRemoveButton=()=>{
    const removeQuoteButton = document.getElementById("removeQuote");
    removeQuoteButton.onclick = function(){ removeQuote() };
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
    let form = document.getElementById("commentForm");
    let data = new FormData(form);
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
        document.getElementById("submitComment").addEventListener("click", submitComment);
    }
}

const fetchTopic = ()=> {
    ajax.get(`http://localhost:8085/topics/${storage.topics.chosenTopic}`, displayTopic);
}
const fetchComments = () =>{
    ajax.get(`http://localhost:8085/topics/${storage.topics.chosenTopic}/comments`, displayComments);

}


discussionInit();
