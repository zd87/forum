const toPage=(pageName, query)=>{
    let routes = {
        "home":"/pages/homePage/homePage.html",
        "discussion":"/pages/discussionPage/discussionPage.html"
    };
    let queryString = query || "";
    window.location.href = routes[pageName] + queryString;
}

export {
    toPage
}
