import { createStore } from 'redux';

const incrementCount = ({ incrementBy = 1 } = {}) => ({
    type: 'INCREMENT',
    incrementBy
});

const decrementCount = ({ decreseBy = -1} = {}) => ({
    type: 'DECREMENT',
    decreseBy
});

const setCount = ({ count }) => ({
    type: 'SET',
    count
});

const resetCount = () => ({
    type: 'RESET'
});

// reducers:

const countReducer = (state = {count: 0}, action) => {
    // console.log('store running');

    switch(action.type){
        case 'INCREMENT':
            return {
                count: state.count + action.incrementBy
            };
        case 'DECREMENT':
            return {
                count: state.count - action.decreseBy
            };  
        case 'SET':    
            return{
                count: action.count
            }
        case 'RESET':
            return {
                count: 0
            };                  
        default:
            return state;
    }
};

const store = createStore(countReducer);

store.subscribe(() => {
    console.log(store.getState());
});

// store.dispatch({
//     type: 'INCREMENT',
//     incrementBy: 5
// });

store.dispatch(incrementCount({ incrementBy: 5}));

store.dispatch(incrementCount());

console.log(store.getState());

store.dispatch(resetCount());

store.dispatch(decrementCount({ decreseBy: 20 }));

store.dispatch(decrementCount());

store.dispatch(setCount({ count: 201 }));