import { combineReducers } from "redux";
import getFormatiReducers from "./GetFormatiReduces";

export default combineReducers ({
    formati: getFormatiReducers
});