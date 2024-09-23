// 假设这是你的三个异步函数，返回Promise
function asyncFunction1() {
    return new Promise((resolve) => {
        setTimeout(() => resolve('Result from asyncFunction1'), 1000);
    });
}

function asyncFunction2(previousResult) {
    return new Promise((resolve) => {
        setTimeout(() => resolve(`${previousResult}, Result from asyncFunction2`), 1000);
    });
}

function asyncFunction3(previousResult) {
    return new Promise((resolve) => {
        setTimeout(() => resolve(`${previousResult}, Result from asyncFunction3`), 1000);
    });
}


let results = [];
// 依次调用这些函数，并在asyncFunction2前进行条件判断
asyncFunction1()
    .then(result1 => {
        console.log(result1); // 输出: Result from asyncFunction1
        results.push(result1);

        // 假设这里有一个条件判断
        const shouldExecuteAsyncFunction2 = true; // 根据实际情况设置这个变量

        if (shouldExecuteAsyncFunction2) {
            return asyncFunction2(result1);
        } else {
            // 如果不执行asyncFunction2，可以直接返回result1或一个新的Promise
            return Promise.resolve(result1);
        }
    })
    .then(result2 => {
        console.log(result2); // 输出: Result from asyncFunction1, Result from asyncFunction2 或 Result from asyncFunction1

        results.push(result2)

        return asyncFunction3(result2);
    })
    .then(result3 => {
        console.log(result3); // 输出: Result from asyncFunction1, Result from asyncFunction2, Result from asyncFunction3 或 Result from asyncFunction1, Result from asyncFunction3

        results.push(result3);
        console.log(results)
    })
    .catch(error => {
        console.error('Error:', error);
    });
