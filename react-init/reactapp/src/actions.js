export const CHANGE_NAME = 'change-name';

export const ADD_AGE = 'add-age';

export function changeName(name){
    return {
        type:CHANGE_NAME,
        value: name
    }
}

export function addAge(value){
    return {
        type:ADD_AGE,
        value
    };
}