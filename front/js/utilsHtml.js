const addDomElement =(element, customClass, innerHtml)=>{
    let domElement = document.createElement(element);
    if (customClass) domElement.classList.add(customClass);
    if (innerHtml) domElement.innerHTML = innerHtml;
    return domElement;
}

const commentTemplate = (comment)=> {
    return `
        <div class="userInfo">
            <p>${comment.userName || "Anonymous"}</p>
            <p>${new Date(comment.creationDate).toUTCString() }</p>
        </div>
        <div class="commentText">
            ${ comment.quotedComment ? '<p class="quotedComment">'+comment.quotedComment.comment+'</p>' : ""}
            <p>${comment.comment}</p>
        </div>
    `;
}

const buildComment = (comment, commentsContainer, quoteCommentCallback)=>{
    let divComment = addDomElement("div", "comment");
    let div = addDomElement("div","", commentTemplate(comment));
    let button = addDomElement("button", "quoteButton", "Answer");
    button.onclick= function (){ quoteCommentCallback(comment)};
    divComment.appendChild(div);
    divComment.appendChild(button);
    commentsContainer.appendChild(divComment);
}

const el = {
    commentsContainer:      document.getElementById("commentsContainer"),
    topicName :             document.getElementById("chosenTopic"),
    topicDescription :      document.getElementById("chosenTopicDescription"),
    topicCreationDate :     document.getElementById("chosenTopicCreationDate"),
    quotedComment :         document.getElementById("quotedComment"),
    quotedCommentBody :     document.getElementById("quotedCommentBody"),
    removeQuoteButton :     document.getElementById("removeQuote"),
    commentForm :           document.getElementById("commentForm"),
    topicForm :             document.getElementById("topicForm"),
    submitCommentButton :   document.getElementById("submitComment"),
    submitTopicButton :     document.getElementById("submitTopic")
}

export{
    buildComment,
    el
}
