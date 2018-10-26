import {creatStore, combineReducers } from 'redux';

const demoState = {
    expenses: [{
        id: '534gsdfg434',
        description: 'Travel expense',
        note: 'Travel to London',
        amount: 300,
        createAt: 0
    }],
    filters: {
        text: 'travel',
        sort: 'amount',
        startDate: undefined,
        endDate: undefined
    }
};