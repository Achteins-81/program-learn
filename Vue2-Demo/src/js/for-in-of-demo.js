const obj = {name: 'Tom', language: 'JavaScript', framework: 'Vue.js'};
const simpleArray = [1, 2, 3, 'a', 'b', 'c'];
const complexArray = [{name: 'Tom'}, {name: 'Jerry'}, {name: 'John'}, {name: 'Mike'}];

for (let key in obj) {
    console.log(key, obj[key]);
}
/**
 * TypeError: obj is not iterable
 */
/*for(let item of obj){
    console.log(item);
}*/

for (let item of simpleArray) {
    console.log(item)
}

for (let item of complexArray) {
    console.log(item)
}
