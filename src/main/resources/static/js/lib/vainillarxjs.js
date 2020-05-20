const observable = {
    suscribe: observer => {

    },
    pipe: operator => {
        return operator(this)
    }
}

const Observer = {
    next: x => {
        console.log(x);
    },
    error: err => {
        console.error(err);
    }
}