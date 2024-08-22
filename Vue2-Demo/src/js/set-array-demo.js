/**
 * Set集合与Array数组特性对比Demo
 * Set支持类似Array的元素增删，但是不会重复增加
 * @type {*[]}
 */

let demoArray = [];
let demoSet = new Set();

demoArray.push('1');
demoArray.push('2');
demoArray.push('3');
demoArray.push('1');

demoSet.add('1');
demoSet.add('2');
demoSet.add('3');
demoSet.add('1');

console.log(demoArray);
console.log(demoSet);

demoSet.delete('1')
console.log(demoSet);
console.log(demoSet.has('1'));
console.log(demoSet.has('2'));
