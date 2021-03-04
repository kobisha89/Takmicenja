const getFormatiReducers = function (formati = [], action) {
    switch(action.type) {
        case "GET_FORMATI":
            return action.payload;
        default:
            return formati;
    }
};

export default getFormatiReducers;