import { getFormati } from './../apis/Axios';


let getFormatiAction = function () {

    return async function (dispatch, getState ) {
        try{
            let formati = await getFormati();
            dispatch({ type: "GET_FORMATI", payload: formati})
        }catch(error){
            dispatch({ type: "GET_FORMATI", payload: [] });
        }
    }
}

export default getFormatiAction;