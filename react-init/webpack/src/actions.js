//#region redux
// export const CHANGE_NAME = 'change-name';

// export const ADD_AGE = 'add-age';

// export function changeName(name){
//     return {
//         type:CHANGE_NAME,
//         value: name
//     }
// }

// export function addAge(value){
//     return {
//         type:ADD_AGE,
//         value
//     };
// }
//#endregion

export const GET_USERS = 'get-users';
export const ADD_USERS = 'add-users';

export function getUsers(users){
    return {
        type: GET_USERS,
        users
    }
}

export function addUser(user){
    return {
        type: ADD_USERS,
        user
    };
}